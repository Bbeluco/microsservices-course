package com.devsuperior.hroauth.services;

import com.devsuperior.hroauth.DTOs.UserEntity;
import com.devsuperior.hroauth.feignClients.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserFeignClient userFeignClient;

    public UserEntity findUserByEmail(String email) {
        UserEntity user = userFeignClient.findUserByEmail(email).getBody();
        if(user == null)  {
            throw new IllegalArgumentException("Email not found: " + email);
        }
        return user;
    }
}
