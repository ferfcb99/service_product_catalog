package com.quantum.leap.productcatalog.util.mapper;

import com.quantum.leap.productcatalog.entity.Brand;
import com.quantum.leap.productcatalog.entity.Category;
import com.quantum.leap.productcatalog.entity.Product;
import com.quantum.leap.productcatalog.entity.ProductVariant;
import com.quantum.leap.productcatalog.web.dto.request.CreateProductDto;
import com.quantum.leap.productcatalog.web.dto.request.CreateProductVariantDto;
import com.quantum.leap.productcatalog.web.dto.response.SearchProductResponseDto;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

public final class ProductMapper {

    ProductMapper() {}

    public static List<SearchProductResponseDto> mapEntityToProductResponseDto(Page<ProductVariant> products) {
        List<SearchProductResponseDto> productResponseDtos =
                products.stream()
                        .map(productVariantEntity ->
                                new SearchProductResponseDto(
                                        productVariantEntity.getId(),
                                        productVariantEntity.getProduct().getName(),
                                        productVariantEntity.getProduct().getDescription(),
                                        productVariantEntity.getProduct().getCategory().getName(),
                                        productVariantEntity.getProduct().getBrand().getName(),
                                        productVariantEntity.getProduct().getImageUrl(),
                                        productVariantEntity.getSize(),
                                        productVariantEntity.getColor(),
                                        productVariantEntity.getPrice(),
                                        productVariantEntity.getStock(),
                                        productVariantEntity.getSku()

                                ))
                        .toList();
        return productResponseDtos;
    }

    public static Product mapProductCreateRequestToProductEntity(CreateProductDto createProductDto,
                                                                 Category category,
                                                                 Brand brand) {

        Product product = new Product();
        product.setId(null);
        product.setName(createProductDto.getProductName());
        product.setDescription(createProductDto.getProductDescription());
        product.setImageUrl(createProductDto.getImageUrl());
        product.setActive(createProductDto.getActive());
        product.setCategory(category);
        product.setBrand(brand);
        return product;
    }

    public static ProductVariant mapProductVariantCreateRequestToProductVariantEntity(CreateProductVariantDto productVariantDto,
                                                                                      Product product) {
        ProductVariant productVariant = new ProductVariant();
        productVariant.setId(null);
        productVariant.setProduct(product);
        productVariant.setSize(productVariantDto.getSize());
        productVariant.setColor(productVariantDto.getColor());
        productVariant.setPrice(productVariantDto.getPrice());
        productVariant.setStock(productVariantDto.getStock());
        productVariant.setSku(productVariantDto.getSku());
        return productVariant;
    }


}
