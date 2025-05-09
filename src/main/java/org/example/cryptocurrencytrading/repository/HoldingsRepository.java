package org.example.cryptocurrencytrading.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class HoldingsRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public double getQuantity(int userId, String symbol){
        String sql = "SELECT quantity FROM holdings WHERE user_id = ? AND crypto_symbol = ?";
        Double result = jdbcTemplate.queryForObject(sql, Double.class, userId, symbol);
        return result == null ? 0:result;
    }

    public void addOrUpdate(int userId, String symbol, double quantity) {
        String selectSql = "SELECT COUNT(*) FROM holdings WHERE user_id = ? AND crypto_symbol = ?";
        int count = jdbcTemplate.queryForObject(selectSql, new Object[]{userId, symbol}, Integer.class);
        if (count == 0) {
            String insertSql = "INSERT INTO holdings (user_id, crypto_symbol, quantity) VALUES (?, ?, ?)";
            jdbcTemplate.update(insertSql, userId, symbol, quantity);
        } else {
            String updateSql = "UPDATE holdings SET quantity = quantity + ? WHERE user_id = ? AND crypto_symbol = ?";
            jdbcTemplate.update(updateSql, quantity, userId, symbol);
        }
    }

    public void deleteAll(int userId) {
        String sql = "DELETE FROM holdings WHERE user_id = ?";
        jdbcTemplate.update(sql, userId);
    }
}
