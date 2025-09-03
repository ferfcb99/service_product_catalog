package com.quantum.leap.productcatalog.web.dto.request;

public class UpdateProductDto {


    private Long productVariantId;

    private String productName;

    private Double variantPrice;

    private String variantSize;

    private String variantColor;

    private String variantUrlImage;

    private String productDescription;

    public UpdateProductDto() {}

    public UpdateProductDto(Long productVariantId, String productName, Double variantPrice, String variantSize, String variantColor, String variantUrlImage, String productDescription) {
        this.productVariantId = productVariantId;
        this.productName = productName;
        this.variantPrice = variantPrice;
        this.variantSize = variantSize;
        this.variantColor = variantColor;
        this.variantUrlImage = variantUrlImage;
        this.productDescription = productDescription;
    }


    public Long getProductVariantId() {
        return productVariantId;
    }

    public void setProductVariantId(Long productVariantId) {
        this.productVariantId = productVariantId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getVariantPrice() {
        return variantPrice;
    }

    public void setVariantPrice(Double variantPrice) {
        this.variantPrice = variantPrice;
    }

    public String getVariantSize() {
        return variantSize;
    }

    public void setVariantSize(String variantSize) {
        this.variantSize = variantSize;
    }

    public String getVariantColor() {
        return variantColor;
    }

    public void setVariantColor(String variantColor) {
        this.variantColor = variantColor;
    }

    public String getVariantUrlImage() {
        return variantUrlImage;
    }

    public void setVariantUrlImage(String variantUrlImage) {
        this.variantUrlImage = variantUrlImage;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    @Override
    public String toString() {
        return "UpdateProductDto{" +
                ", productVariantId=" + productVariantId +
                ", productName='" + productName + '\'' +
                ", variantPrice='" + variantPrice + '\'' +
                ", variantSize='" + variantSize + '\'' +
                ", variantColor='" + variantColor + '\'' +
                ", variantUrlImage='" + variantUrlImage + '\'' +
                ", productDescription='" + productDescription + '\'' +
                '}';
    }
}
