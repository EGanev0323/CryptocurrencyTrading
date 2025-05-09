package org.example.cryptocurrencytrading.repository;

import org.example.cryptocurrencytrading.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public double getBalance(int userId){
        String sql = "SELECT balance FROM users WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, Double.class, userId);
    }
    public void updateBalance(int userId, double balance){
        String sql = "UPDATE users SET balance = ? WHERE id = ?";
        jdbcTemplate.update(sql, balance, userId);
    }

    public int createUser(String username, double balance){
        String sql = "INSERT INTO users (username, balance) OUTPUT INSERTED.id VALUES (?, ?)";
        return jdbcTemplate.queryForObject(sql, Integer.class, username, balance);
    }

    public List<User> getAllUsers() {
        String sql = "SELECT id, username, balance FROM users";
        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new User(rs.getInt("id"), rs.getString("username"), rs.getDouble("balance"))
        );
    }

    public void resetBalance(int userId){
        String sql = "UPDATE users SET balance = 10000 WHERE id = ?";
        jdbcTemplate.update(sql, userId);
    }
}
