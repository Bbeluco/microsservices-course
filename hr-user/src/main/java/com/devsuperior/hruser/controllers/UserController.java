package com.devsuperior.hruser.controllers;

import com.devsuperior.hruser.entities.UserEntity;
import com.devsuperior.hruser.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserEntity> findById(@PathVariable Long id) {
        UserEntity obj = userRepository.findById(id).get();
        return ResponseEntity.ok(obj);
    }

    @GetMapping(value = "/search")
    public ResponseEntity<UserEntity> findUserByEmail(@RequestParam String email) {
        UserEntity user = userRepository.findByEmail(email);
        return ResponseEntity.ok(user);
    }
}
