package com.now.backend.data;

import com.now.backend.models.LoginDto;
import com.now.backend.models.RegisterDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AuthTest {

    public static LoginDto loginDto() {
       LoginDto loginDto = new LoginDto("user@email.com", "lejla123");
        return loginDto;
    }

    public static RegisterDto registerDto(){
        RegisterDto registerDto = new RegisterDto("User User", "061", "user@email.com", "lejla123");
        return registerDto;
    }
}
