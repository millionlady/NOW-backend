package com.now.backend.services;

import com.now.backend.models.UpdateProfileDto;
import com.now.backend.models.UserDto;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserDto testUser = new UserDto(1L, "Lejla Omerovic", "lejla@sst.com", "pass123", "SST University", 1, "I am Lejla, 3. year student", "1. place coding competition, 1. place math competition", "https://www.linkedin.com/in/lejla-omerovic", "https://storage.radiosarajevo.ba/image/478820/1180x732/lejla_omerovic_ministry_of_programming.jpg");

    public UserDto getProfile() {
        return this.testUser;
    }

    public UserDto updateProfile(UpdateProfileDto updateProfileDto) {
        if(!updateProfileDto.getProfileImage().equals(testUser.getProfileImage())){
            testUser.setProfileImage(updateProfileDto.getProfileImage());
        }

        if(!updateProfileDto.getPassword().equals(testUser.getPassword())){
            testUser.setPassword(updateProfileDto.getPassword());
        }

        if(!(updateProfileDto.getUniversityYear() == testUser.getUniversityYear())){
            testUser.setUniversityYear(updateProfileDto.getUniversityYear());
        }

        if(!(updateProfileDto.getUniversityYear() == testUser.getUniversityYear())){
            testUser.setUniversityYear(updateProfileDto.getUniversityYear());
        }

        if(!updateProfileDto.getShortBio().equals(testUser.getShortBio())){
            testUser.setShortBio(updateProfileDto.getShortBio());
        }

        if(!updateProfileDto.getCertificates().equals(testUser.getCertificates())){
            testUser.setCertificates(updateProfileDto.getCertificates());
        }

        return this.testUser;
    }

    public UserDto deleteProfile() {
        this.testUser = new UserDto();
        return this.testUser;
    }
}
