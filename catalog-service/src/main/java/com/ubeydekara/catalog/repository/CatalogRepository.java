package com.ubeydekara.catalog.repository;

import com.ubeydekara.catalog.model.Catalog;
import com.ubeydekara.catalog.model.Market;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CatalogRepository extends JpaRepository<Catalog, UUID> {
    List<Catalog> findTop10ByOrderByCreateAtAsc();

    List<Catalog> findAllByMarket(Market marketID);

    Catalog getCatalogByCatalogID(UUID catalogID);
}
