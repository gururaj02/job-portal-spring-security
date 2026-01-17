package com.example.spring_boot_jobApp.service;

import com.example.spring_boot_jobApp.model.User;
import com.example.spring_boot_jobApp.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;

    public User saveUser(User user) {

        return repo.save(user);
    }
}
