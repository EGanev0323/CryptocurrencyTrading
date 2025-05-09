package org.example.cryptocurrencytrading.controller;

import org.example.cryptocurrencytrading.model.TradeRequest;
import org.example.cryptocurrencytrading.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/trade")
public class TradeController {
    @Autowired
    private TradeService tradeService;

    @PostMapping
    public ResponseEntity<?> trade(@RequestBody TradeRequest req) {
        try {
            tradeService.trade(req.getUserId(), req.getSymbol(), req.getQuantity(), req.getType());
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
}
