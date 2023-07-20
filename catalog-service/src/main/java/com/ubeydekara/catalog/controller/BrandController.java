package com.ubeydekara.catalog.controller;

import com.ubeydekara.base.response.ResponseHandler;
import com.ubeydekara.catalog.model.Brand;
import com.ubeydekara.catalog.service.BrandService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/brand")
@Slf4j
@RequiredArgsConstructor
public class BrandController {

    private final BrandService brandService;

    @GetMapping
    public ResponseEntity<Object> getAll() {
        List<Brand> brandList = brandService.getAll();
        return ResponseHandler.generateResponse(HttpStatus.OK, brandList);
    }

    @PostMapping
    public ResponseEntity<Object> add(@RequestBody @Valid Brand brand) {
        Brand newBrand = brandService.add(brand);
        return ResponseHandler.generateResponse(HttpStatus.OK, newBrand);
    }

}
