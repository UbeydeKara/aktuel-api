package com.ubeydekara.catalog.service;

import com.ubeydekara.catalog.model.Brand;
import com.ubeydekara.catalog.model.Catalog;
import com.ubeydekara.catalog.model.Product;
import com.ubeydekara.catalog.repository.CatalogRepository;
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

    @Override
    public List<Catalog> getAll() {
        return catalogRepository.findAll();
    }

    @Override
    public List<Catalog> findAllByBrand(Brand brand) {
        return catalogRepository.findAllByBrand(brand);
    }

    @Override
    public Catalog save(Catalog catalog) {
        catalog.setCatalogID(UUID.randomUUID());
        catalog.setCreateAt(LocalDate.now());
        catalog.getProducts().forEach(x -> x.setCatalog(catalog));
        return catalogRepository.saveAndFlush(catalog);
    }

    @Override
    public Catalog update(Catalog catalog) {
        return catalogRepository.saveAndFlush(catalog);
    }

    @Override
    public void deleteAllByIds(List<UUID> catalogId) {
        catalogRepository.deleteAllById(catalogId);
    }

}
