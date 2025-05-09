package org.example.cryptocurrencytrading.repository;

import org.example.cryptocurrencytrading.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TransactionsRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert(int userId, String symbol, double quantity, double price, String type) {
        String sql = "INSERT INTO transactions (user_id, crypto_symbol, quantity, price, type) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, userId, symbol, quantity, price, type);
    }

    public List<Transaction> getAll(int userId) {
        String sql = "SELECT * FROM transactions WHERE user_id = ? ORDER BY timestamp DESC";
        return jdbcTemplate.query(sql, new Object[]{userId}, new RowMapper<Transaction>() {
            @Override
            public Transaction mapRow(ResultSet rs, int rowNum) throws SQLException {
                Transaction t = new Transaction();
                t.setId(rs.getInt("id"));
                t.setUserId(rs.getInt("user_id"));
                t.setCrypto_symbol(rs.getString("crypto_symbol"));
                t.setQuantity(rs.getDouble("quantity"));
                t.setPrice(rs.getDouble("price"));
                t.setType(rs.getString("type"));
                t.setTimestamp(rs.getTimestamp("timestamp"));
                return t;
            }
        });
    }
}
