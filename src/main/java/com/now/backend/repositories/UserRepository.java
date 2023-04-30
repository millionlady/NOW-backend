package com.now.backend.repositories;

import com.now.backend.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByEmail(String email);
    User findOneByEmail(String email);
}
