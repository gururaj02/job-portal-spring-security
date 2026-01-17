package com.example.spring_boot_jobApp.repo;

import com.example.spring_boot_jobApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {

    User findByUsername(String username);

}
