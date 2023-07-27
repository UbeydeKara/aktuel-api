package com.ubeydekara.catalog.repository;

import com.ubeydekara.catalog.model.Catalog;
import com.ubeydekara.catalog.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
    void deleteAllByCatalog(Catalog catalog);
}
