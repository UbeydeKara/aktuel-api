package com.ubeydekara.catalog.service;

import com.ubeydekara.catalog.model.Market;
import com.ubeydekara.catalog.repository.MarketRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class MarketServiceImpl implements MarketService {

    private final MarketRepository marketRepository;

    @Override
    public List<Market> findAll() {
        return marketRepository.findAll();
    }

    @Override
    public Market save(Market market) {
        return marketRepository.save(market);
    }

    @Override
    public void deleteById(UUID marketID) {
        marketRepository.deleteById(marketID);
    }

    @Override
    public Market getById(UUID marketID) {
        return marketRepository.getMarketByMarketID(marketID);
    }
}
