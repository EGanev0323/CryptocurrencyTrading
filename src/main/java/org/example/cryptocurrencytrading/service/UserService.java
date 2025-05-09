package org.example.cryptocurrencytrading.service;

import org.example.cryptocurrencytrading.model.User;
import org.example.cryptocurrencytrading.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    private User user;

    public double getBalance(int userId){
        return userRepository.getBalance(userId);
    }

    public void resetBalance(int userId){
        userRepository.resetBalance(userId);
    }

    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }
    public int createUser(String username, double balance){
        return userRepository.createUser(username, balance);
    }
}
