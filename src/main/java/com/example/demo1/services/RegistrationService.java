package com.example.demo1.services;

import com.example.demo1.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationService {
    @Autowired
    private DataProcessingService processingService;

    @Autowired
    private UserService userService;

    @Autowired NotificationService notificationService;

    public void registerUser(String name, int age, String email) {
        processingService.recordUser(userService.createUser(name, age, email));
    }

    public List<User> sortUsersByAge()
    {
        notificationService.notifyOperation("sortUsersByAge");
        return processingService.sortUsersByAge(processingService.getUserRepository().getUsers());
    }

    public List<User> filterUsersByAge(int age) {
        notificationService.notifyOperation("filterUsersByAge");
        return processingService.filterUsersByAge(processingService.getUserRepository().getUsers(), age);
    }

    public double calculateAverageAge() {
        notificationService.notifyOperation("calculateAverageAge");
        return processingService.calculateAverageAge(processingService.getUserRepository().getUsers());
    }
}
