package org.example.cryptocurrencytrading.controller;

import org.example.cryptocurrencytrading.model.CryptoPrice;
import org.example.cryptocurrencytrading.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/crypto")
public class PriceController {
    @Autowired
    private PriceService priceService;

    @GetMapping("/top20")
    public List<CryptoPrice> getTop20(){
        return priceService.getTop20();
    }
}
