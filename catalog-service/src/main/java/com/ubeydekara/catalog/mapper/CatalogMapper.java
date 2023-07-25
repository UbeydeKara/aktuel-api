package com.ubeydekara.catalog.mapper;

import com.ubeydekara.catalog.model.Catalog;
import com.ubeydekara.catalog.model.CatalogImage;
import com.ubeydekara.catalog.model.Product;
import com.ubeydekara.catalog.request.CatalogRequest;
import com.ubeydekara.catalog.response.CatalogResponse;
import com.ubeydekara.catalog.service.MarketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CatalogMapper {
    private final MarketService marketService;

    public Catalog toEntity(CatalogRequest catalogRequest) {
        List<CatalogImage> catalogImages = new ArrayList<>();
        List<Product> products = new ArrayList<>();
        UUID catalogID = catalogRequest.getCatalogID() != null ? catalogRequest.getCatalogID() : UUID.randomUUID();

        Catalog catalog = Catalog.builder()
                .catalogID(catalogID)
                .deadline(catalogRequest.getDeadline())
                .startAt(catalogRequest.getStartAt())
                .createAt(LocalDate.now())
                .market(marketService.getById(catalogRequest.getMarketID()))
                .build();

        catalogRequest.getProducts().forEach(
                x -> {
                    Product product = Product.builder().path(x).catalog(catalog).build();
                    products.add(product);
                }
        );

        catalogRequest.getImages().forEach(
                x -> {
                    CatalogImage catalogImage = CatalogImage.builder().path(x).catalog(catalog).build();
                    catalogImages.add(catalogImage);
                }
        );

        catalog.setProducts(products);
        catalog.setImages(catalogImages);
        return catalog;
    }

    public CatalogResponse toResponse(Catalog catalog) {
        return CatalogResponse.builder()
                .catalogID(catalog.getCatalogID())
                .deadline(catalog.getDeadline())
                .startAt(catalog.getStartAt())
                .createAt(catalog.getCreateAt())
                .market(catalog.getMarket())
                .images(catalog.getImages().stream().map(CatalogImage::getPath).toList())
                .products(catalog.getProducts().stream().map(Product::getPath).toList())
                .build();
    }

    public List<CatalogResponse> toResponse(List<Catalog> catalogList) {
        return catalogList.stream().map(this::toResponse).toList();
    }
}
