package com.ubeydekara.catalog.mapper;

import com.ubeydekara.catalog.model.Catalog;
import com.ubeydekara.catalog.model.CatalogImage;
import com.ubeydekara.catalog.model.Product;
import com.ubeydekara.catalog.repository.ImageRepository;
import com.ubeydekara.catalog.repository.ProductRepository;
import com.ubeydekara.catalog.request.CatalogRequest;
import com.ubeydekara.catalog.response.CatalogResponse;
import com.ubeydekara.catalog.service.MarketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CatalogMapper {
    private final MarketService marketService;
    private final ImageRepository imageRepository;
    private final ProductRepository productRepository;

    @Transactional
    public Catalog toEntity(CatalogRequest catalogRequest) {
        List<CatalogImage> catalogImages = new ArrayList<>();
        List<Product> products = new ArrayList<>();

        if (catalogRequest.getCatalogID() == null) catalogRequest.setCatalogID(UUID.randomUUID());

        Catalog catalog = Catalog.builder()
                .catalogID(catalogRequest.getCatalogID())
                .deadline(catalogRequest.getDeadline())
                .startAt(catalogRequest.getStartAt())
                .market(marketService.getById(catalogRequest.getMarketID()))
                .build();

        catalogRequest.getImages().forEach(x -> {
            CatalogImage catalogImage = CatalogImage.builder().catalogImageID(UUID.randomUUID()).path(x).catalog(catalog).build();
            catalogImages.add(catalogImage);
        });

        catalogRequest.getProducts().forEach(x -> {
            Product product = Product.builder().productID(UUID.randomUUID()).path(x).catalog(catalog).build();
            products.add(product);
        });

        imageRepository.deleteAllByCatalog(catalog);
        productRepository.deleteAllByCatalog(catalog);

        catalog.setProducts(products);
        catalog.setImages(catalogImages);

        return catalog;
    }

    public CatalogResponse toResponse(Catalog catalog) {
        return CatalogResponse.builder().catalogID(catalog.getCatalogID()).deadline(catalog.getDeadline()).startAt(catalog.getStartAt()).createAt(catalog.getCreateAt()).market(catalog.getMarket()).images(catalog.getImages().stream().map(CatalogImage::getPath).toList()).products(catalog.getProducts().stream().map(Product::getPath).toList()).build();
    }

    public List<CatalogResponse> toResponse(List<Catalog> catalogList) {
        return catalogList.stream().map(this::toResponse).toList();
    }
}
