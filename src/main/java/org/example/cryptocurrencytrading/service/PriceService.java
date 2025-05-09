package org.example.cryptocurrencytrading.service;

import org.example.cryptocurrencytrading.model.CryptoPrice;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class PriceService {
    private final Map<String, CryptoPrice> priceMap = new ConcurrentHashMap<>();

    public PriceService() {
        priceMap.put("BTC", new CryptoPrice("BTC", "Bitcoin", 65000));
        priceMap.put("ETH", new CryptoPrice("ETH", "Ethereum", 3200));
    }

    public List<CryptoPrice> getTop20() {
        return new ArrayList<>(priceMap.values());
    }

    public double getCurrentPrice(String symbol) {
        return priceMap.get(symbol).getPrice();
    }
}
