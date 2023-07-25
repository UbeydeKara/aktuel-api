package com.ubeydekara.catalog.service;

import com.ubeydekara.catalog.request.CatalogRequest;
import com.ubeydekara.catalog.response.CatalogResponse;

import java.util.List;
import java.util.UUID;

public interface CatalogService {

    List<CatalogResponse> findAll();

    List<CatalogResponse> findByRecentlyAdded();
    List<CatalogResponse> findAllByMarket(UUID marketID);

    CatalogResponse save(CatalogRequest catalogRequest);

    CatalogResponse update(CatalogRequest catalogRequest);

    void deleteAllByIds(List<UUID> catalogId);
}
