package com.ubeydekara.catalog.controller;

import com.ubeydekara.catalog.model.Brand;
import com.ubeydekara.catalog.model.Catalog;
import com.ubeydekara.catalog.service.CatalogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ubeydekara.base.response.ResponseHandler;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/catalog")
@Slf4j
@RequiredArgsConstructor
public class CatalogController {

    private final CatalogService catalogService;

    @GetMapping
    public ResponseEntity<Object> getAll() {
        List<Catalog> catalogList = catalogService.getAll();
        return ResponseHandler.generateResponse(HttpStatus.OK, catalogList);
    }

    @PostMapping("/brand")
    public ResponseEntity<Object> findAllByBrand(@RequestBody Brand brand) {
        List<Catalog> catalogList = catalogService.findAllByBrand(brand);
        return ResponseHandler.generateResponse(HttpStatus.OK, catalogList);
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody Catalog catalog) {
        Catalog catalogResponse = catalogService.save(catalog);
        return ResponseHandler.generateResponse(HttpStatus.OK, catalogResponse);
    }

    @PutMapping
    public ResponseEntity<Object> update(@RequestBody Catalog catalog) {
        Catalog catalogResponse = catalogService.update(catalog);
        return ResponseHandler.generateResponse(HttpStatus.OK, catalogResponse);
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteAllByIds(@RequestParam List<UUID> catalogIDs) {
        catalogService.deleteAllByIds(catalogIDs);
        return ResponseHandler.generateResponse(HttpStatus.OK, "Catalog deleted successfully with ids: " + catalogIDs);
    }

}
