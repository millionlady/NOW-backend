package com.now.backend.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String fullName;
    private String email;
    private String password;
    private String universityName;
    private int universityYear;
    private String shortBio;
    private String certificates;
    private String linkedinUrl;
    private String profileImage;
}
