package com.quantum.leap.productcatalog.service;

import com.quantum.leap.productcatalog.web.dto.response.SearchProductResponseDto;

import java.util.List;

public interface ProductCatalogService {


    List<SearchProductResponseDto> getProductsByNameCategoryColorSize(String name,
                                                                      String category,
                                                                      String size,
                                                                      String color,
                                                                      Double minPrice,
                                                                      Double maxPrice,
                                                                      Integer page,
                                                                      Integer sizePage);

}
