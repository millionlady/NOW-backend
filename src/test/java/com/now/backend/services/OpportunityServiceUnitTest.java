package com.now.backend.services;

import com.now.backend.data.OpportunityTest;
import com.now.backend.models.OpportunityDto;
import com.now.backend.models.entities.Opportunity;
import com.now.backend.repositories.OpportunityRepository;
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
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

@RunWith(SpringRunner.class)
public class OpportunityServiceUnitTest {
    @MockBean
    private OpportunityRepository opportunityRepository;
    @TestConfiguration
    static class OpportunityServiceTestConfiguration {

        @Bean
        @Primary
        public OpportunityService orgOpportunityService(OpportunityRepository opportunityRepository) {
            return new OpportunityService(opportunityRepository);
        }
    }
    @Autowired
    private OpportunityService orgOpportunityService;
    @Test
    public void givenOpportunity_whenGetOpportunity_thenListShouldBeFound() {
        Mockito.when(opportunityRepository.findAll()).thenReturn(List.of(OpportunityTest.opportunity()));

        List<OpportunityDto> resultList = orgOpportunityService.getOpportunity();

        assertThat(resultList).hasSize(1);
    }
    @Test
    public void givenNoOpportunity_whenGetOpportunity_thenListShouldBeEmpty() {

        List<OpportunityDto> resultList = orgOpportunityService.getOpportunity();

        assertThat(resultList).isEmpty();
    }
    @Test
    public void givenValidOpportunityId_whenGetOpportunity_thenOpportunityShouldBeFound() {
        long opportunityId = 1L;
        Mockito.when(opportunityRepository.findById(opportunityId)).thenReturn(Optional.of(OpportunityTest.opportunity()));

        OpportunityDto resultOpportunity = orgOpportunityService.getOpportunityId(opportunityId);

        assertThat(resultOpportunity.getTitle()).isEqualTo("App Developer");
    }
    @Test
    public void givenInvalidOpportunityId_whenGetOpportunity_thenExceptionShouldBeThrown() {
        assertThatThrownBy(() -> orgOpportunityService.getOpportunityId(10L)).isInstanceOf(RuntimeException.class).hasMessageContaining("This opportunity does not exist");
    }
    @Test
    public void givenOpportunity_whenCreateOpportunity_thenOpportunityShouldBeFound() {
        OpportunityDto inputOpportunityDto = OpportunityTest.opportunityDto1();
        inputOpportunityDto.setId(0L);
        Opportunity outputOpportunity = OpportunityTest.opportunity();

        Mockito.when(opportunityRepository.save(any(Opportunity.class)))
                .thenReturn(outputOpportunity);

        OpportunityDto resultOpportunity = orgOpportunityService.createOpportunity(inputOpportunityDto);

        assertThat(resultOpportunity).isNotNull();
        assertThat(resultOpportunity.getTitle()).isEqualTo(inputOpportunityDto.getTitle());
        assertThat(resultOpportunity.getId()).isNotEqualTo(0L);
    }
    @Test
    public void givenOpportunity_whenCreateOpportunity_thenRepositoryIsCalled() {
        OpportunityDto opportunityDto = OpportunityTest.opportunityDto2();
        Mockito.when(opportunityRepository.save(any(Opportunity.class))).thenReturn(OpportunityTest.opportunity());
        orgOpportunityService.createOpportunity(opportunityDto);
        verify(opportunityRepository, times(1)).save(any(Opportunity.class));
    }
}
