package com.now.backend.services;

import com.now.backend.models.*;
import com.now.backend.models.entities.Opportunity;
import com.now.backend.models.entities.OpportunityApplication;
import com.now.backend.repositories.OpportunityApplicationRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OpportunityApplicationService {

    private final OpportunityApplicationRepository opportunityApplicationRepository;
    private final UserService userService;
    private final OpportunityService opportunityService;

    public OpportunityApplicationService(OpportunityApplicationRepository opportunityApplicationRepository, UserService userService, OpportunityService opportunityService) {
        this.opportunityApplicationRepository = opportunityApplicationRepository;
        this.userService = userService;
        this.opportunityService = opportunityService;
    }

    public OpportunityApplicationDto createApplication(OpportunityApplicationDto opportunityApplicationDto) {
        OpportunityApplication application = new OpportunityApplication();

        application.setOpportunityId(opportunityApplicationDto.getOpportunityId());

        application.setUserId(opportunityApplicationDto.getUserId());

        application.setAdditionalInfo(opportunityApplicationDto.getAdditionalInfo());

        application.setStatus("Pending");

        application.setCreatedAt(new Date());

        opportunityApplicationRepository.save(application);

        return toDto(application);
    }

    public List<MyApplicationDto> getMyApplications(Long userId) {

       List<OpportunityApplication> applications = opportunityApplicationRepository.findAllByUserId(userId);
       List<MyApplicationDto> myApplications = new ArrayList<>();
        for (OpportunityApplication application : applications) {
            OpportunityDto opportunity = opportunityService.getOpportunityId(application.getOpportunityId());
            UserDto org = userService.getById(opportunity.getOrganizationId());


            MyApplicationDto myApplication = new MyApplicationDto(toDto(application), opportunity, org.getFullName());
            myApplications.add(myApplication);
        }

        return myApplications;
    }

    public OpportunityApplicationDto getMyApplication(Long userId, Long opportunityId) {

        OpportunityApplication myApplication = opportunityApplicationRepository.findByUserIdAndOpportunityId(userId, opportunityId);

        return toDto(myApplication);
    }

    public List<OpportunityApplicationWithUserDto> getAllApplications(Long opportunityId) {

        List<OpportunityApplicationWithUserDto> opportunityWithApplications = new ArrayList<>();
        List<OpportunityApplication> applications = opportunityApplicationRepository.findAllByOpportunityId(opportunityId);
        for (OpportunityApplication application : applications) {
            UserDto user = this.userService.getById(application.getUserId());
            opportunityWithApplications.add(new OpportunityApplicationWithUserDto(toDto(application), user));
        }
        return opportunityWithApplications;
    }

    public OpportunityApplicationDto setStatus(Long opportunityId, String status) {
        OpportunityApplication application = getEntity(opportunityId);
        application.setStatus(status);
        opportunityApplicationRepository.save(application);
        return toDto(application);
    }

    private static OpportunityApplicationDto toDto(OpportunityApplication opportunityApplication){
        return new OpportunityApplicationDto(opportunityApplication.getId(),opportunityApplication.getUserId(), opportunityApplication.getOpportunityId(), opportunityApplication.getAdditionalInfo(), opportunityApplication.getStatus(), opportunityApplication.getCreatedAt());
    }

    private static OpportunityApplication toEntity(OpportunityApplicationDto opportunityApplicationDto){
        return new OpportunityApplication(opportunityApplicationDto.getId(),opportunityApplicationDto.getUserId(), opportunityApplicationDto.getOpportunityId(), opportunityApplicationDto.getAdditionalInfo(), opportunityApplicationDto.getStatus(), opportunityApplicationDto.getCreatedAt());
    }

    private OpportunityApplication getEntity(long id){
        Optional<OpportunityApplication> opportunityApplicationOptional = opportunityApplicationRepository.findById(id);
        if(opportunityApplicationOptional.isPresent()){
            return opportunityApplicationOptional.get();
        }
        throw new RuntimeException("Opportunity Application with id:" + id + " does not exist!");
    }
}
