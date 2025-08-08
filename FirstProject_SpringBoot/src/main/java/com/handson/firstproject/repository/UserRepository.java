package com.handson.firstproject.repository;

import  com.handson.firstproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {}
