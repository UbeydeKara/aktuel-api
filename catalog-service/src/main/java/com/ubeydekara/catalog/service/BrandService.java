package com.ubeydekara.catalog.service;

import com.ubeydekara.catalog.model.Brand;

import java.util.List;

public interface BrandService {
    List<Brand> getAll();
    Brand add(Brand brand);
}
