package com.ubeydekara.catalog.controller;

import com.ubeydekara.base.response.ResponseHandler;
import com.ubeydekara.catalog.model.Market;
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

    @GetMapping
    public ResponseEntity<Object> getAll() {
        List<Market> marketList = marketService.getAll();
        return ResponseHandler.generateResponse(HttpStatus.OK, marketList);
    }

    @PostMapping
    public ResponseEntity<Object> add(@RequestBody @Valid Market market) {
        Market newMarket = marketService.add(market);
        return ResponseHandler.generateResponse(HttpStatus.OK, newMarket);
    }

}
