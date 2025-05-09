package org.example.cryptocurrencytrading.controller;

import org.example.cryptocurrencytrading.model.User;
import org.example.cryptocurrencytrading.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}/balance")
    public double getBalance(@PathVariable("id") int userId){
        return userService.getBalance(userId);
    }

    // Ресетни баланса (POST)
    @PostMapping("/{id}/reset")
    public void resetBalance(@PathVariable("id") int userId){
        userService.resetBalance(userId);
    }

    // Създай потребител (POST)
    @PostMapping("/register")
    public int createUser(@RequestBody User user){
        return userService.createUser(user.getUsername(), user.getBalance());
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
