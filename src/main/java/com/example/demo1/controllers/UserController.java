package com.example.demo1.controllers;

import com.example.demo1.services.RegistrationService;
import com.example.demo1.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class UserController {
    @Autowired
    private RegistrationService service;

    @GetMapping
    public void registerUser(String name, int age, String email) {
        service.registerUser(name, age, email);
    }

    @GetMapping
    public List<User> sortUsersByAge()
    {
        return service.sortUsersByAge();
    }

    @GetMapping
    public List<User> filterUsersByAge(int age)
    {
        return service.filterUsersByAge(age);
    }

    @GetMapping
    public double calculateAverageAge()
    {
        return service.calculateAverageAge();
    }
}
