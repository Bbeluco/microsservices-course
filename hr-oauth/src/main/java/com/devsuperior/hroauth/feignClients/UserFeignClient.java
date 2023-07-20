package com.devsuperior.hroauth.feignClients;

import com.devsuperior.hroauth.DTOs.UserEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "hr-user", path = "/user")
public interface UserFeignClient {

    @GetMapping(value = "/search")
    ResponseEntity<UserEntity> findUserByEmail(@RequestParam String email);
}
