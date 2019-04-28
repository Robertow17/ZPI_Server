package com.zpi.user;


import com.zpi.user.enums.Gender;
import com.zpi.user.enums.UserType;
import lombok.Data;


@Data
public class UserDTO
{

    private String login;
    private String password;
    private Gender gender;
    private UserType type;


}
