package com.quantum.leap.productcatalog.web.controller;

import com.quantum.leap.productcatalog.web.dto.response.SearchProductResponseDto;
import com.quantum.leap.productcatalog.web.dto.ResponseModelApi;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductCatalogController {

    ResponseEntity<ResponseModelApi<List<SearchProductResponseDto>>> filterByNameCategorySizeColor(String name,
                                                                                                   String category,
                                                                                                   String size,
                                                                                                   String color,
                                                                                                   Double minPrice,
                                                                                                   Double maxPrice);



}
