package com.quantum.leap.productcatalog.web.controller.impl;

import com.quantum.leap.productcatalog.service.ProductCatalogService;
import com.quantum.leap.productcatalog.web.controller.ProductCatalogController;
import com.quantum.leap.productcatalog.web.dto.response.SearchProductResponseDto;
import com.quantum.leap.productcatalog.web.dto.ResponseModelApi;
import com.quantum.leap.productcatalog.web.exception.model.ProductCatalogExeption;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/product-catalog")
public class ProductCatalogControllerImpl implements ProductCatalogController {

    private final ProductCatalogService productCatalogService;

    public ProductCatalogControllerImpl(ProductCatalogService productCatalogService) {
        this.productCatalogService = productCatalogService;
    }

    @Override
    @GetMapping(value = "/filter-products", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseModelApi<List<SearchProductResponseDto>>> filterByNameCategorySizeColor(
            @RequestParam(required = false, name = "name") String name,
            @RequestParam(required = false, name = "category") String category,
            @RequestParam(required = false, name = "size") String size,
            @RequestParam(required = false, name = "color") String color,
            @RequestParam(required = false, name = "minPrice") Double minPrice,
            @RequestParam(required = false, name = "maxPrice") Double maxPrice,
            @RequestParam(required = false, name = "page", defaultValue = "0") Integer page,
            @RequestParam(required = false, name = "sizePage", defaultValue = "5") Integer sizePage,
            @RequestParam(required = false, name = "sortBy", defaultValue = "id") String sortBy){
        try{
            List<SearchProductResponseDto> productsFiltered =
                    this.productCatalogService
                            .getProductsByNameCategoryColorSize(name, category, size, color, minPrice, maxPrice, page, sizePage);
            return new ResponseEntity<>(new ResponseModelApi<>(String.valueOf(HttpStatus.OK.value()), "gotten", productsFiltered), HttpStatus.OK);
        }catch (ProductCatalogExeption e){
            //e.printStackTrace();
            throw new ProductCatalogExeption(e.getCode(), e.getMessage(), e.getDetails());
        }
    }


}



















