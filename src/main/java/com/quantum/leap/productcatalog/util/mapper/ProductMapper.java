package com.quantum.leap.productcatalog.util.mapper;

import com.quantum.leap.productcatalog.entity.Product;
import com.quantum.leap.productcatalog.entity.ProductVariant;
import com.quantum.leap.productcatalog.web.dto.response.SearchProductResponseDto;

import java.util.ArrayList;
import java.util.List;

public final class ProductMapper {

    ProductMapper() {}

    public static List<SearchProductResponseDto> mapEntityToProductResponseDto(List<ProductVariant> products) {
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

}
