package com.ubeydekara.catalog.repository;

import com.ubeydekara.catalog.model.Brand;
import com.ubeydekara.catalog.model.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CatalogRepository extends JpaRepository<Catalog, UUID> {
    List<Catalog> findAllByBrand(Brand brand);
}
