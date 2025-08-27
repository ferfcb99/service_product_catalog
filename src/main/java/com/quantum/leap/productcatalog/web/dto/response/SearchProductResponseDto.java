package com.quantum.leap.productcatalog.web.dto.response;

public class SearchProductResponseDto {

    private Long variantId;

    private String name;

    private String description;

    private String category;

    private String brand;

    private String imageUrl;

    private String size;

    private String color;

    private Double price;

    private Integer stock;

    private String sku;

    public SearchProductResponseDto() {}

    public SearchProductResponseDto(Long variantId,
                                    String name,
                                    String description,
                                    String category,
                                    String brand,
                                    String imageUrl,
                                    String size,
                                    String color,
                                    Double price,
                                    Integer stock,
                                    String sku) {
        this.variantId = variantId;
        this.name = name;
        this.description = description;
        this.category = category;
        this.brand = brand;
        this.imageUrl = imageUrl;
        this.size = size;
        this.color = color;
        this.price = price;
        this.stock = stock;
        this.sku = sku;
    }

    public Long getVariantId() {
        return variantId;
    }

    public void setVariantId(Long variantId) {
        this.variantId = variantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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

    @Override
    public String toString() {
        return "SearchProductDto{" +
                "variantId=" + variantId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", brand='" + brand + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", size='" + size + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", sku='" + sku + '\'' +
                '}';
    }
}
