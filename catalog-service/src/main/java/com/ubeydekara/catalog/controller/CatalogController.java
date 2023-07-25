package com.ubeydekara.catalog.controller;

import com.ubeydekara.catalog.request.CatalogRequest;
import com.ubeydekara.catalog.response.CatalogResponse;
import com.ubeydekara.catalog.response.ResponseHandler;
import com.ubeydekara.catalog.service.CatalogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/catalog")
@Slf4j
@RequiredArgsConstructor
public class CatalogController {

    private final CatalogService catalogService;

    @GetMapping("findAll")
    public ResponseEntity<Object> findAll() {
        List<CatalogResponse> catalogList = catalogService.findAll();
        return ResponseHandler.generateResponse(HttpStatus.OK, catalogList);
    }

    @GetMapping("/recently-added")
    public ResponseEntity<Object> findByRecentlyAdded() {
        List<CatalogResponse> catalogList = catalogService.findByRecentlyAdded();
        return ResponseHandler.generateResponse(HttpStatus.OK, catalogList);
    }

    @GetMapping("/market/{marketID}")
    public ResponseEntity<Object> findAllByMarket(@PathVariable("marketID") UUID marketID) {
        List<CatalogResponse> catalogList = catalogService.findAllByMarket(marketID);
        return ResponseHandler.generateResponse(HttpStatus.OK, catalogList);
    }

    @PostMapping("/save")
    public ResponseEntity<Object> save(@RequestBody CatalogRequest catalogRequest) {
        CatalogResponse catalogResponse = catalogService.save(catalogRequest);
        return ResponseHandler.generateResponse(HttpStatus.OK, catalogResponse);
    }

    @PutMapping("/update")
    public ResponseEntity<Object> update(@RequestBody CatalogRequest catalogRequest) {
        CatalogResponse catalogResponse = catalogService.update(catalogRequest);
        return ResponseHandler.generateResponse(HttpStatus.OK, catalogResponse);
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteAllByIds(@RequestParam List<UUID> catalogIDs) {
        catalogService.deleteAllByIds(catalogIDs);
        return ResponseHandler.generateResponse(HttpStatus.OK, "Catalog deleted successfully with ids: " + catalogIDs);
    }

}
