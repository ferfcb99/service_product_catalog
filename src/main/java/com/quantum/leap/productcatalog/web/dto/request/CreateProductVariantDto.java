package com.quantum.leap.productcatalog.web.dto.request;

import jakarta.validation.constraints.*;

public class CreateProductVariantDto {

    @NotNull
    private Long productId;

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

    protected CreateProductVariantDto() {}

    public CreateProductVariantDto(Long productId, String size, String color, Double price, Integer stock, String sku) {
        this.productId = productId;
        this.size = size;
        this.color = color;
        this.price = price;
        this.stock = stock;
        this.sku = sku;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
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
