package com.ubeydekara.catalog.service;

import com.ubeydekara.catalog.model.Market;

import java.util.List;
import java.util.UUID;

public interface MarketService {
    List<Market> findAll();

    Market save(Market market);
    Market getById(UUID marketID);
}
