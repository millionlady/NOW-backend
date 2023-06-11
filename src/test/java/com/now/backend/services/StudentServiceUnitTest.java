package com.now.backend.services;

import com.now.backend.data.StudentListTest;
import com.now.backend.data.UserTest;
import com.now.backend.models.StudentListDto;
import com.now.backend.models.UserDto;
import com.now.backend.repositories.StudentListRepository;
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

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
@RunWith(SpringRunner.class)
public class StudentServiceUnitTest {
    @MockBean
    private UserRepository userRepository;
    @TestConfiguration
    static class StudentServiceTestConfiguration {

        @Bean
        @Primary
        public StudentListService orgOpportunityService(UserRepository userRepository) {
            return new StudentListService(userRepository);
        }
    }
    @Autowired
    private StudentListService studentListService;
    @Test
    public void givenStudentList_whenGetStudentList_thenListShouldBeFound() {
        Mockito.when(userRepository.findAll()).thenReturn(List.of(UserTest.user()));

        List<UserDto> resultList = studentListService.getStudenList();

        assertThat(resultList).hasSize(1);
    }
    @Test
    public void givenNoStudents_whenGetStudentLists_thenListShouldBeEmpty() {

        List<UserDto> resultList = studentListService.getStudenList();

        assertThat(resultList).isEmpty();
    }
}
