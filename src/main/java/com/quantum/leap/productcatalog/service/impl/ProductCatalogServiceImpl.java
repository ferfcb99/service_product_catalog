package com.quantum.leap.productcatalog.service.impl;

import com.quantum.leap.productcatalog.entity.Brand;
import com.quantum.leap.productcatalog.entity.Category;
import com.quantum.leap.productcatalog.entity.Product;
import com.quantum.leap.productcatalog.entity.ProductVariant;
import com.quantum.leap.productcatalog.repository.BrandRepository;
import com.quantum.leap.productcatalog.repository.CategoryRepository;
import com.quantum.leap.productcatalog.repository.ProductRepository;
import com.quantum.leap.productcatalog.repository.ProductVariantRepository;
import com.quantum.leap.productcatalog.service.ProductCatalogService;
import com.quantum.leap.productcatalog.service.UtilService;
import com.quantum.leap.productcatalog.util.mapper.ProductMapper;
import com.quantum.leap.productcatalog.util.specification.ProductSpecification;
import com.quantum.leap.productcatalog.web.dto.request.CreateProductDto;
import com.quantum.leap.productcatalog.web.dto.request.CreateProductVariantDto;
import com.quantum.leap.productcatalog.web.dto.request.UpdateProductDto;
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
import java.util.Optional;

@Service
public class ProductCatalogServiceImpl implements ProductCatalogService {

    private final ProductVariantRepository productVariantRepository;

    private final ProductRepository productRepository;

    private final CategoryRepository categoryRepository;

    private final BrandRepository brandRepository;

    private final UtilService utilService;

    public ProductCatalogServiceImpl(ProductVariantRepository productVariantRepository, UtilService utilService,
                                      ProductRepository productRepository, CategoryRepository categoryRepository,
                                     BrandRepository brandRepository) {
        this.productVariantRepository = productVariantRepository;
        this.utilService = utilService;
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.brandRepository = brandRepository;
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

    @Override
    public CreateProductDto createProduct(CreateProductDto createProductDto) {

        try{
            Category category = this.categoryRepository.findByName(createProductDto.getProductCategory());
            if(category == null){
                throw new ProductCatalogExeption(createProductDto.getProductCategory() + " category doesn't exist");
            }

            Brand brand = this.brandRepository.findByName(createProductDto.getProductBrand());
            if(brand == null){
                throw new ProductCatalogExeption(createProductDto.getProductBrand() + " brand doesn't exist");
            }

            Product product = ProductMapper.mapProductCreateRequestToProductEntity(createProductDto, category, brand);
            this.productRepository.save(product);

            return createProductDto;
        }catch (Exception e){
            e.printStackTrace();
            throw new ProductCatalogExeption("500", e.getMessage(), "Error creating product");
        }

    }

    @Override
    public CreateProductVariantDto createProductVariant(CreateProductVariantDto createProductVariantDto) {
        try{
            Optional<Product> product = this.productRepository.findById(createProductVariantDto.getProductId());

            if(product.isEmpty()){
                throw new ProductCatalogExeption(createProductVariantDto.getProductId() + " idProduct doesn't exist");
            }

            ProductVariant productVariant = ProductMapper.mapProductVariantCreateRequestToProductVariantEntity(
                    createProductVariantDto, product.get()
            );

            this.productVariantRepository.save(productVariant);

            return createProductVariantDto;

        }catch (Exception e){
            e.printStackTrace();
            throw new ProductCatalogExeption("500", e.getMessage(), "Error creating variant");
        }
    }

    @Override
    public UpdateProductDto updateProductOrVariant(UpdateProductDto updateProductDto) {
       try{
           Optional<ProductVariant> productVariant =
                   this.productVariantRepository.findById(updateProductDto.getProductVariantId());

           if(productVariant.isEmpty()){
               throw new ProductCatalogExeption(updateProductDto.getProductVariantId() + " id variant doesn't exist");
           }

           if(updateProductDto.getVariantPrice() != null){
               productVariant.get().setPrice(updateProductDto.getVariantPrice());
           }

           if(updateProductDto.getVariantColor() != null){
               productVariant.get().setColor(updateProductDto.getVariantColor());
           }

           if(updateProductDto.getVariantSize() != null){
               productVariant.get().setSize(updateProductDto.getVariantSize());
           }

           if(updateProductDto.getProductName() != null){
               productVariant.get().getProduct().setName(updateProductDto.getProductName());
           }

           if(updateProductDto.getProductDescription() != null){
               productVariant.get().getProduct().setDescription(updateProductDto.getProductDescription());
           }

           if(updateProductDto.getVariantUrlImage() != null){
               productVariant.get().getProduct().setImageUrl(updateProductDto.getVariantUrlImage());
           }

           this.productVariantRepository.save(productVariant.get());

           return updateProductDto;
       }catch (Exception e){
           e.printStackTrace();
           throw new ProductCatalogExeption("500", e.getMessage(), "Error updating variant");
       }
    }





}
