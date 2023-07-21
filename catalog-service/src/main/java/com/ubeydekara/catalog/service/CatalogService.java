package com.ubeydekara.catalog.service;

import com.ubeydekara.catalog.model.Market;
import com.ubeydekara.catalog.model.Catalog;

import java.util.List;
import java.util.UUID;

public interface CatalogService {

    List<Catalog> getAll();

    List<Catalog> findByRecentlyAdded();

    List<Catalog> findAllByMarket(Market market);
    Catalog save(Catalog catalog);
    Catalog update(Catalog catalog);
    void deleteAllByIds(List<UUID> catalogId);
}
