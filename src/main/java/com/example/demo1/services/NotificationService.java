package com.example.demo1.services;

import com.example.demo1.domain.User;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    public void notifyUser(User user) {
        System.out.println("A new user has been created: " + user.getName());
    }
    public void notifyOperation(String operation) {
        System.out.println("Operation " + operation + "has been performed");
    }
}
