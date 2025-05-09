package org.example.cryptocurrencytrading.controller;

import org.example.cryptocurrencytrading.model.Transaction;
import org.example.cryptocurrencytrading.repository.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class TransactionsController {
    @Autowired
    private TransactionsRepository transactionsRepository;

    @GetMapping("/{id}/transactions")
    public List<Transaction> getTransactions(@PathVariable int id){
        return transactionsRepository.getAll(id);
    }
}
