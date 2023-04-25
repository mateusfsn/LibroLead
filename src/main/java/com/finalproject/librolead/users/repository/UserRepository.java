package com.finalproject.librolead.users.repository;

import com.finalproject.librolead.users.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
