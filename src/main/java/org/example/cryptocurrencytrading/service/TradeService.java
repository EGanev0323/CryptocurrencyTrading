package org.example.cryptocurrencytrading.service;

import org.example.cryptocurrencytrading.repository.HoldingsRepository;
import org.example.cryptocurrencytrading.repository.TransactionsRepository;
import org.example.cryptocurrencytrading.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TradeService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private HoldingsRepository holdingsRepository;
    @Autowired
    private TransactionsRepository transactionsRepository;
    @Autowired
    private PriceService priceService;

    public void trade(int userId, String symbol, double quantity, String type){
        double price = priceService.getCurrentPrice(symbol);
        double cost=price*quantity;
        double balance=userRepository.getBalance(userId);

        if(type.equals("BUY")){
            if(balance<cost){
                return;
            }
            holdingsRepository.addOrUpdate(userId, symbol, quantity);
            userRepository.updateBalance(userId, balance-cost);
        }else if(type.equals("SELL")){
            if(holdingsRepository.getQuantity(userId, symbol)<quantity){
                return;
            }

            userRepository.updateBalance(userId, balance+cost);
            holdingsRepository.addOrUpdate(userId,symbol, -quantity);
        }

        transactionsRepository.insert(userId, symbol, quantity, price, type);
    }
}
