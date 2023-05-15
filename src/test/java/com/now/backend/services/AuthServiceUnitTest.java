package com.now.backend.services;

import com.now.backend.data.AuthTest;
import com.now.backend.data.UserTest;
import com.now.backend.models.LoginDto;
import com.now.backend.models.RegisterDto;
import com.now.backend.models.entities.User;
import com.now.backend.repositories.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


import java.util.Optional;

@RunWith(SpringRunner.class)
public class AuthServiceUnitTest {

    @MockBean
    private UserRepository userRepository;

    @TestConfiguration
    static class AuthServiceTestConfiguration{
        @Bean
        @Primary
        public AuthService authService (UserRepository userRepository){
            return new AuthService(userRepository);
        }
    }

    @Autowired
    private AuthService authService;

    @Test
    public void givenInValidLoginInfo_toLogin_shouldReturnException(){
        LoginDto invalidLogin = new LoginDto("adasdas@skjdas.com", "asdnajksd");

        assertThatThrownBy(() -> authService.login(invalidLogin));
    }

    @Test
    public void givenInValidLoginInfo_toLogin_shouldReturnUser(){
        User user = UserTest.user();
        LoginDto loginDto = AuthTest.loginDto();

        Mockito.when(userRepository.findOneByEmail(any(String.class)))
                .thenReturn(user);

        User loginUser = authService.login(loginDto);

        assertThat(loginUser).isNotNull();
        assertThat(loginUser).isEqualTo(user);
    }

    @Test
    public void givenInValidLoginInfo_toLogin_thenRepositoryCalled(){
        User user = UserTest.user();
        LoginDto loginDto = AuthTest.loginDto();

        Mockito.when(userRepository.findOneByEmail(any(String.class)))
                .thenReturn(user);

        User loginUser = authService.login(loginDto);

        verify(userRepository, times(1)).findOneByEmail(any(String.class));
    }

    @Test
    public void givenUserInfo_whenRegister_thenUserCreated(){
        RegisterDto registerDto = AuthTest.registerDto();
        Mockito.when(userRepository.save(any(User.class)))
                        .thenReturn(UserTest.user());

        User userResult = authService.register(registerDto);

        assertThat(userResult).isNotNull();
        assertThat(userResult.getEmail()).isEqualTo(registerDto.getEmail());
        assertThat(userResult.getFullName()).isEqualTo(registerDto.getFullName());
        assertThat(userResult.getPhoneNumber()).isEqualTo(registerDto.getPhoneNumber());
    }

    @Test
    public void givenUserInfo_whenRegister_thenRepositoryCalled(){
        RegisterDto registerDto = AuthTest.registerDto();
        Mockito.when(userRepository.save(any(User.class)))
                .thenReturn(UserTest.user());

        authService.register(registerDto);

        verify(userRepository, times(1)).save(any(User.class));
    }
}
