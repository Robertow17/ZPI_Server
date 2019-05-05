package com.zpi.account;

import com.zpi.service.ServiceDTO;
import com.zpi.user.UserDTO;
import lombok.Data;

@Data
public class AccountDTO
{
    private ServiceDTO service;
    private UserDTO user;

}
