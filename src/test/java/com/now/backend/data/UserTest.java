package com.now.backend.data;

import com.now.backend.models.UpdateProfileDto;
import com.now.backend.models.UserDto;
import com.now.backend.models.entities.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserTest {

    public static User user() {
        User user = new User();
        user.setId(3L);
        user.setFullName("User User");
        user.setEmail("user@email.com");
        user.setPasswordHash("4aa7d14fb716955a52b6cc4ddabb0615");
        user.setShortBio("I am test user");
        user.setUniversityYear(1);
        user.setProfileImageUrl("https://facebook.com/myimage.png");
        user.setUniversityName("SSST");
        user.setLinkedinUrl("https://linekdin.com/myprofile");

        return user;
    }

    public static UpdateProfileDto updateProfileDto(){
        return new UpdateProfileDto("hash", 2, "I am now new student", "1. place", "https://facebool.com.image2");
    }

    public static UserDto userProfile(){
        UserDto user = new UserDto();
        user.setId(3L);
        user.setFullName("User User");
        user.setEmail("user@email.com");
        user.setShortBio("I am test user");
        user.setUniversityYear(1);
        user.setProfileImage("https://facebook.com/myimage.png");
        user.setUniversityName("SSST");
        user.setLinkedinUrl("https://linekdin.com/myprofile");

        return user;
    }
}
