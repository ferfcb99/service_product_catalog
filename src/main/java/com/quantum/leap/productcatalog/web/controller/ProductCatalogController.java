package com.quantum.leap.productcatalog.web.controller;

import com.quantum.leap.productcatalog.web.dto.request.CreateProductDto;
import com.quantum.leap.productcatalog.web.dto.request.CreateProductVariantDto;
import com.quantum.leap.productcatalog.web.dto.request.UpdateProductDto;
import com.quantum.leap.productcatalog.web.dto.response.SearchProductResponseDto;
import com.quantum.leap.productcatalog.web.dto.ResponseModelApi;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ProductCatalogController {

    ResponseEntity<ResponseModelApi<List<SearchProductResponseDto>>> filterByNameCategorySizeColor(String name,
                                                                                                   String category,
                                                                                                   String size,
                                                                                                   String color,
                                                                                                   Double minPrice,
                                                                                                   Double maxPrice,
                                                                                                   Integer page,
                                                                                                   Integer sizePage,
                                                                                                   String sortBy);


    ResponseEntity<ResponseModelApi<CreateProductDto>> createProduct(CreateProductDto createProductDto);

    ResponseEntity<ResponseModelApi<CreateProductVariantDto>> createProductVariant(
            CreateProductVariantDto createProductVariantDto);

    ResponseEntity<ResponseModelApi<UpdateProductDto>> updateProductOrVariant(UpdateProductDto updateProductDto);




}
