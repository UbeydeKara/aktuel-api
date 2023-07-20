package com.ubeydekara.catalog.service;

import com.ubeydekara.catalog.model.Brand;
import com.ubeydekara.catalog.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

    @Override
    public List<Brand> getAll() {
        return brandRepository.findAll();
    }

    @Override
    public Brand add(Brand brand) {
        return brandRepository.save(brand);
    }
}
