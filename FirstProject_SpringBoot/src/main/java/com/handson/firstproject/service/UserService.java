package com.handson.firstproject.service;

import com.handson.firstproject.entity.User;
import com.handson.firstproject.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public User saveUser(String name) {
        return repo.save(new User(name));
    }

    public List<User> getAllUsers() {
        return repo.findAll();
    }
}
