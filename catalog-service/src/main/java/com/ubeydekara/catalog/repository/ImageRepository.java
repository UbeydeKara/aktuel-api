package com.ubeydekara.catalog.repository;

import com.ubeydekara.catalog.model.Catalog;
import com.ubeydekara.catalog.model.CatalogImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ImageRepository extends JpaRepository<CatalogImage, UUID> {
    void deleteAllByCatalog(Catalog catalog);
}
