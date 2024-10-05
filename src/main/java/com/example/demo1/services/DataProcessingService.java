package com.example.demo1.services;

import com.example.demo1.domain.User;
import com.example.demo1.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataProcessingService {
    public UserRepository getUserRepository() {
        return userRepository;
    }

    @Autowired
    private UserRepository userRepository;

    public List<User> sortUsersByAge(List<User> users) {
        return users.stream().sorted(Comparator.comparing(User::getAge)).collect(Collectors.toList());
    }

    public List<User> filterUsersByAge(List<User> users, int age) {
        return users.stream().filter(user -> user.getAge() > age).collect(Collectors.toList());
    }

    public double calculateAverageAge(List<User> users) {
        return users.stream().mapToInt(User::getAge).average().orElse(0);
    }

    public void recordUser(User user) {
        userRepository.getUsers().add(user);
    }
}
