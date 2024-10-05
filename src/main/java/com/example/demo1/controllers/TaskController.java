package com.example.demo1.controllers;

import com.example.demo1.services.DataProcessingService;
import com.example.demo1.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private DataProcessingService service;

    @GetMapping
    public List<String> getTasks() {
        List<String> tasks = new ArrayList<>();
        tasks.add("sort");
        tasks.add("filter");
        tasks.add("calc");
        return tasks;
    }

    @GetMapping("/sort")
    public List<User> sortUsersByAge()
    {
        return service.sortUsersByAge(service.getUserRepository().getUsers());
    }

    @GetMapping("/filter")
    public List<User> filterUsersByAge(int age) {
        return service.filterUsersByAge(service.getUserRepository().getUsers(), age);
    }

    @GetMapping("/calc")
    public double calculateAverageAge() {
        return service.calculateAverageAge(service.getUserRepository().getUsers());
    }
}
