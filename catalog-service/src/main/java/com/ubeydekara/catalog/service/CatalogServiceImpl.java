package com.ubeydekara.catalog.service;

import com.ubeydekara.catalog.mapper.CatalogMapper;
import com.ubeydekara.catalog.model.Catalog;
import com.ubeydekara.catalog.repository.CatalogRepository;
import com.ubeydekara.catalog.request.CatalogRequest;
import com.ubeydekara.catalog.response.CatalogResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class CatalogServiceImpl implements CatalogService {
    private final CatalogRepository catalogRepository;
    private final MarketService marketService;
    private final CatalogMapper catalogMapper;

    @Override
    public List<CatalogResponse> findAll() {
        List<Catalog> catalogList = catalogRepository.findAll();
        return catalogMapper.toResponse(catalogList);
    }

    @Override
    public List<CatalogResponse> findByRecentlyAdded() {
        List<Catalog> catalogList = catalogRepository.findTop10ByOrderByCreateAtAsc();
        return catalogMapper.toResponse(catalogList);
    }

    @Override
    public List<CatalogResponse> findAllByMarket(UUID marketID) {
        List<Catalog> catalogList = catalogRepository.findAllByMarket(marketService.getById(marketID));
        return catalogMapper.toResponse(catalogList);
    }

    @Override
    public Catalog getById(UUID catalogID) {
        return catalogRepository.getCatalogByCatalogID(catalogID);
    }

    @Override
    public CatalogResponse save(CatalogRequest catalogRequest) {
        Catalog catalogEntity = catalogMapper.toEntity(catalogRequest);
        catalogEntity.setCreateAt(LocalDate.now());
        Catalog catalog = catalogRepository.save(catalogEntity);
        return catalogMapper.toResponse(catalog);
    }

    @Override
    public CatalogResponse update(CatalogRequest catalogRequest) {
        Catalog catalogEntity = catalogMapper.toEntity(catalogRequest);
        Catalog catalog = catalogRepository.save(catalogEntity);
        return catalogMapper.toResponse(catalog);
    }

    @Override
    public void deleteAllByIds(List<UUID> catalogId) {
        catalogRepository.deleteAllById(catalogId);
    }

}
