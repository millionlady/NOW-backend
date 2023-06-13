package com.now.backend.services;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.now.backend.data.UserTest;
import com.now.backend.models.ProfileDto;
import com.now.backend.models.UpdateProfileDto;
import com.now.backend.models.UserDto;
import com.now.backend.models.entities.User;
import com.now.backend.repositories.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
public class UserServiceUnitTest {

    @MockBean
    private UserRepository userRepository;

    @TestConfiguration
    static class UserServiceTestConfiguration{

        @Bean
        @Primary
        public UserService userService (UserRepository userRepository){
            return new UserService(userRepository);
        }
    }

    @Autowired
    private UserService userService;

    @Test
    public void givenValidId_whenGetUser_thenUserFound(){
        Long id = 1L;
        Mockito.when(userRepository.findById(id))
                .thenReturn(Optional.of(UserTest.user()));

        ProfileDto userDto = userService.getProfile(id);

        assertThat(userDto.getUser().getEmail()).isEqualTo("user@email.com");
    }

    @Test
    public void givenInvalidId_whenGetUser_thenException(){
        assertThatThrownBy(() -> userService.getProfile(234))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("does not exist");
    }

    @Test
    public void givenValidId_whenUpdateProfile_thenUserReturned(){
        UpdateProfileDto updateProfile = UserTest.updateProfileDto();
        Long id = 3L;
        User user = UserTest.user();

        Mockito.when(userRepository.findById(id))
                .thenReturn(Optional.of(user));
        Mockito.when(userRepository.save(any(User.class)))
                .thenReturn(user);

        UserDto userResult = userService.updateProfile(id, updateProfile);

        assertThat(userResult).isNotNull();
    }

    @Test
    public void givenInvalidId_whenUpdate_thenException(){
        assertThatThrownBy(() -> userService.updateProfile(234, UserTest.updateProfileDto()))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("does not exist");
    }

    @Test
    public void givenId_whenDelete_thenRepositoryCalled(){

        long id = 4L;

        userService.deleteProfile(id);

        verify(userRepository, times(1)).deleteById(id);
    }
}
