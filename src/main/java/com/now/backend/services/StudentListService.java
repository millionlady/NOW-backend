package com.now.backend.services;

import com.now.backend.models.UserDto;
import com.now.backend.models.entities.User;
import com.now.backend.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentListService {
    private final UserRepository userRepository;

    public StudentListService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDto> getStudenList() {
        List<UserDto> studentList = new ArrayList<>();
        List<User> students = userRepository.findAll();
        for (User user : students) {
            studentList.add(new UserDto(user.getId(), user.getFullName(), user.getPhoneNumber(), user.getEmail(), user.getPasswordHash(), user.getUniversityName(), user.getUniversityYear(), user.getShortBio(), user.getCertificates(), user.getLinkedinUrl(), user.getProfileImageUrl()));
        }

        return studentList;
    }
}
