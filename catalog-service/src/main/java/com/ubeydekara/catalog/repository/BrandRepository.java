package com.ubeydekara.catalog.repository;

import com.ubeydekara.catalog.model.Brand;
import com.ubeydekara.catalog.model.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BrandRepository extends JpaRepository<Brand, UUID> {
}
