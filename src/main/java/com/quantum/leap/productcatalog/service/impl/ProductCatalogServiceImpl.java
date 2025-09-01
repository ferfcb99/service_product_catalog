package com.quantum.leap.productcatalog.service.impl;

import com.quantum.leap.productcatalog.entity.Product;
import com.quantum.leap.productcatalog.entity.ProductVariant;
import com.quantum.leap.productcatalog.repository.ProductRepository;
import com.quantum.leap.productcatalog.repository.ProductVariantRepository;
import com.quantum.leap.productcatalog.service.ProductCatalogService;
import com.quantum.leap.productcatalog.util.mapper.ProductMapper;
import com.quantum.leap.productcatalog.util.specification.ProductSpecification;
import com.quantum.leap.productcatalog.web.dto.response.SearchProductResponseDto;
import com.quantum.leap.productcatalog.web.exception.model.ProductCatalogExeption;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductCatalogServiceImpl implements ProductCatalogService {

    private final ProductVariantRepository productVariantRepository;

    public ProductCatalogServiceImpl(ProductVariantRepository productVariantRepository) {
        this.productVariantRepository = productVariantRepository;
    }

    @Override
    public List<SearchProductResponseDto> getProductsByNameCategoryColorSize(String name,
                                                                             String category,
                                                                             String size,
                                                                             String color,
                                                                             Double minPrice,
                                                                             Double maxPrice,
                                                                             Integer page,
                                                                             Integer sizePage) {
       try{
           Specification<ProductVariant> spec = (root, query, cb) -> null;

           spec = spec.and(ProductSpecification.hasName(name));
           spec = spec.and(ProductSpecification.hasCategory(category));
           spec = spec.and(ProductSpecification.hasSize(size));
           spec = spec.and(ProductSpecification.hasColor(color));
           spec = spec.and(ProductSpecification.priceBetween(minPrice, maxPrice));

           Pageable pageable = PageRequest.of(page, sizePage);
           Page<ProductVariant> productsFiltered = productVariantRepository.findAll(spec, pageable);

           List<SearchProductResponseDto> searchProductResponseDtos = ProductMapper.mapEntityToProductResponseDto(productsFiltered);
           System.out.println("Por lanzar exepcion");
           return searchProductResponseDtos;
       }catch (ProductCatalogExeption e){
           throw new ProductCatalogExeption(e.getCode(), e.getMessage(), e.getDetails());
       }
    }
}
