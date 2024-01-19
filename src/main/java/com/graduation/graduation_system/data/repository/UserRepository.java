package com.graduation.graduation_system.data.repository;

import com.graduation.graduation_system.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
