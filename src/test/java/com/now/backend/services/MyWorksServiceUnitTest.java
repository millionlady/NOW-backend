package com.now.backend.services;

import com.now.backend.data.MyWorksTest;
import com.now.backend.models.MyWorksDto;
import com.now.backend.repositories.MyWorksRepository;
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
public class MyWorksServiceUnitTest {
    @MockBean
    private MyWorksRepository myWorksRepositoryRepository;
    @TestConfiguration
    static class MyWorksServiceTestConfiguration {

        @Bean
        @Primary
        public MyWorksService myWorksService(MyWorksRepository myWorksRepository) {
            return new MyWorksService(myWorksRepository);
        }
    }
    @Autowired
    private MyWorksService myWorksServiceService;
    @Test
    public void givenMyWorksService_whenGetMyWorksService_thenListShouldBeFound() {
        Mockito.when(MyWorksRepository.findAll()).thenReturn(List.of(MyWorksTest.myWorks()));

        List<MyWorksDto> resultList = myWorksServiceService.getMyWorks();

        assertThat(resultList).hasSize(1);
    }
    @Test
    public void givenNoMyWorksService_whenGetMyWorksService_thenListShouldBeEmpty() {

        List<MyWorksDto> resultList = MyWorksService.getMyWorks();

        assertThat(resultList).isEmpty();
    }
}