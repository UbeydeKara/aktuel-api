package com.ubeydekara.catalog.service;

import com.ubeydekara.catalog.model.Market;
import com.ubeydekara.catalog.repository.MarketRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MarketServiceImpl implements MarketService {

    private final MarketRepository marketRepository;

    @Override
    public List<Market> getAll() {
        return marketRepository.findAll();
    }

    @Override
    public Market add(Market market) {
        return marketRepository.save(market);
    }
}
