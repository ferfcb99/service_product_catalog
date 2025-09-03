package com.quantum.leap.productcatalog.web.dto.request;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateProductDto {

    @NotNull
    @NotEmpty
    @Size(min = 1, max = 100)
    private String productName;

    @Size(max = 255)
    private String productDescription;

    @NotNull
    @NotEmpty
    private String productCategory;

    @NotNull
    @NotEmpty
    private String productBrand;

    @NotNull
    @NotEmpty
    @Size(min = 1, max = 255)
    private String imageUrl;

    @NotNull
    private Boolean active;

    @NotNull
    @NotEmpty
    @Size(min = 1, max = 10)
    private String size;

    @NotNull
    @NotEmpty
    @Size(min = 1, max = 30)
    private String color;

    @NotNull
    private Double price;

    @NotNull
    @Min(0)
    @Max(100000)
    private Integer stock;

    @NotNull
    @NotEmpty
    @Size(min = 1, max = 50)
    private String sku;


    public CreateProductDto() {}

    public CreateProductDto(String productName, String productDescription, String productCategory, String productBrand, String imageUrl, Boolean active, String size, String color, Double price, Integer stock, String sku) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productCategory = productCategory;
        this.productBrand = productBrand;
        this.imageUrl = imageUrl;
        this.active = active;
        this.size = size;
        this.color = color;
        this.price = price;
        this.stock = stock;
        this.sku = sku;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }
}
