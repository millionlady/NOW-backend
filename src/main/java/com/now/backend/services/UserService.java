package com.now.backend.services;

import com.now.backend.models.OnboardingDto;
import com.now.backend.models.ProfileDto;
import com.now.backend.models.UpdateProfileDto;
import com.now.backend.models.UserDto;
import com.now.backend.models.entities.User;
import com.now.backend.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final OnboardingService onboardingService;
    public UserService(UserRepository userRepository, OnboardingService onboardingService){
        this.userRepository = userRepository;
        this.onboardingService = onboardingService;
    }
    public ProfileDto getProfile(long id) {

        UserDto user = toDto(getEntity(id));
        OnboardingDto onboarding = onboardingService.getOnboardingByUserId(id);

        ProfileDto profileDto = new ProfileDto(user, onboarding);

        return profileDto;
    }

    public UserDto getByEmail(String email) {
        User user = this.userRepository.findOneByEmail(email);
        return toDto(user);
    }

    public UserDto getById(Long id) {
        User user = getEntity(id);
        return toDto(user);
    }

    public boolean isOrganization(Long id) {
        User user =  getEntity(id);
        return user.isOrganization();
    }

    public UserDto updateProfile(long id, UpdateProfileDto updateProfileDto) {
        User userEntity = getEntity(id);

        User user = userRepository.save(userEntity);
        return toDto(user);
    }

    public void deleteProfile(long id) {
        userRepository.deleteById(id);
    }

    private static UserDto toDto(User user){
        return new UserDto(user.getId(), user.getFullName(), user.getPhoneNumber(), user.getEmail(), user.getPasswordHash(), user.isOrganization());
    }

    private static User toEntity(UserDto userDto){
        return new User(userDto.getId(), userDto.getFullName(), userDto.getPhoneNumber(), userDto.getEmail(), userDto.getPassword(), userDto.isOrganization());
    }

    private User getEntity(long id){
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isPresent()){
            return userOptional.get();
        }
        throw new RuntimeException("User with id:" + id + " does not exist!");
    }
}
