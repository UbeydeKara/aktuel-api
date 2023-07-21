package com.ubeydekara.catalog.repository;

import com.ubeydekara.catalog.model.Market;
import com.ubeydekara.catalog.model.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CatalogRepository extends JpaRepository<Catalog, UUID> {
    List<Catalog> findAllByMarket(Market market);
    List<Catalog> findTop10ByOrderByCreateAtAsc();
}
