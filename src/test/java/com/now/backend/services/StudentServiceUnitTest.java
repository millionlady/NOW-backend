package com.now.backend.services;

import com.now.backend.data.StudentListTest;
import com.now.backend.models.StudentListDto;
import com.now.backend.repositories.StudentListRepository;
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
    private StudentListRepository studentListRepository;
    @TestConfiguration
    static class StudentServiceTestConfiguration {

        @Bean
        @Primary
        public StudentListService orgOpportunityService(StudentListRepository studentListRepository) {
            return new StudentListService(studentListRepository);
        }
    }
    @Autowired
    private StudentListService studentListService;
    @Test
    public void givenStudentList_whenGetStudentList_thenListShouldBeFound() {
        Mockito.when(studentListRepository.findAll()).thenReturn(List.of(StudentListTest.student()));

        List<StudentListDto> resultList = studentListService.getStudenList();

        assertThat(resultList).hasSize(1);
    }
    @Test
    public void givenNoStudents_whenGetStudentLists_thenListShouldBeEmpty() {

        List<StudentListDto> resultList = studentListService.getStudenList();

        assertThat(resultList).isEmpty();
    }
}
