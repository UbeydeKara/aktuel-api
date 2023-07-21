package com.ubeydekara.catalog.service;

import com.ubeydekara.catalog.model.Market;

import java.util.List;

public interface MarketService {
    List<Market> getAll();
    Market add(Market market);
}
