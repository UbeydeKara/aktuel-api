package com.ubeydekara.catalog.repository;

import com.ubeydekara.catalog.model.Market;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MarketRepository extends JpaRepository<Market, UUID> {
}
