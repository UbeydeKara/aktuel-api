package com.ubeydekara.catalog.controller;

import com.ubeydekara.catalog.model.Market;
import com.ubeydekara.catalog.response.ResponseHandler;
import com.ubeydekara.catalog.service.MarketService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/market")
@Slf4j
@RequiredArgsConstructor
public class MarketController {
    private final MarketService marketService;

    @GetMapping("/findAll")
    public ResponseEntity<Object> findAll() {
        List<Market> marketList = marketService.findAll();
        return ResponseHandler.generateResponse(HttpStatus.OK, marketList);
    }

    @PostMapping("/save")
    public ResponseEntity<Object> save(@RequestBody @Valid Market market) {
        Market newMarket = marketService.save(market);
        return ResponseHandler.generateResponse(HttpStatus.OK, newMarket);
    }
}
