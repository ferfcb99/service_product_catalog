package com.quantum.leap.productcatalog.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "product_variant")
public class ProductVariant implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id")
    @JsonManagedReference
    private Product product;

    @Column(name = "size", nullable = false, unique = false, length = 10)
    private String size;

    @Column(name = "color", nullable = false, unique = false, length = 30)
    private String color;

    @Column(name = "price", nullable = false, unique = false)
    private Double price;

    @Column(name = "stock", nullable = false, unique = false)
    private Integer stock;

    @Column(name = "sku", nullable = false, unique = false, length = 50)
    private String sku;

    public ProductVariant() {}

    public ProductVariant(Long id, Product product, String size, String color, Double price, Integer stock, String sku) {
        this.id = id;
        this.product = product;
        this.size = size;
        this.color = color;
        this.price = price;
        this.stock = stock;
        this.sku = sku;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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
        return "ProductVariant{" +
                "id=" + id +
                ", product=" + product +
                ", size='" + size + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", sku='" + sku + '\'' +
                '}';
    }
}
