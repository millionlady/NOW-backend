package com.now.backend.services;

import com.now.backend.models.UpdateProfileDto;
import com.now.backend.models.UserDto;
import com.now.backend.models.entities.User;
import com.now.backend.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public UserDto getProfile(long id) {
        return toDto(getEntity(id));
    }

    public UserDto updateProfile(long id, UpdateProfileDto updateProfileDto) {
        User userEntity = getEntity(id);
        userEntity.setUniversityYear(updateProfileDto.getUniversityYear());
        userEntity.setShortBio(updateProfileDto.getShortBio());
        userEntity.setCertificates(updateProfileDto.getCertificates());
        userEntity.setProfileImageUrl(updateProfileDto.getProfileImage());

        User user = userRepository.save(userEntity);
        return toDto(user);
    }

    public void deleteProfile(long id) {
        userRepository.deleteById(id);
    }

    private static UserDto toDto(User user){
        return new UserDto(user.getId(), user.getFullName(), user.getPhoneNumber(), user.getEmail(), user.getPasswordHash(), user.getUniversityName(), user.getUniversityYear(), user.getShortBio(),user.getCertificates(), user.getLinkedinUrl(), user.getProfileImageUrl());
    }

    private static User toEntity(UserDto userDto){
        return new User(userDto.getId(), userDto.getFullName(), userDto.getPhoneNumber(), userDto.getEmail(), userDto.getPassword(), userDto.getUniversityName(), userDto.getUniversityYear(), userDto.getShortBio(), userDto.getCertificates(), userDto.getLinkedinUrl(), userDto.getProfileImage());
    }

    private User getEntity(long id){
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isPresent()){
            return userOptional.get();
        }
        throw new RuntimeException("User with id:" + id + " does not exist!");
    }
}
