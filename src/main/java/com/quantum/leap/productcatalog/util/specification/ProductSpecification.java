package com.quantum.leap.productcatalog.util.specification;

import com.quantum.leap.productcatalog.entity.Brand;
import com.quantum.leap.productcatalog.entity.Category;
import com.quantum.leap.productcatalog.entity.Product;
import com.quantum.leap.productcatalog.entity.ProductVariant;
import jakarta.persistence.criteria.Join;
import org.springframework.data.jpa.domain.Specification;

public class ProductSpecification {

    public static Specification<ProductVariant> hasName(String name) {
        return (root, query, criteriaBuilder) -> {
            if(name == null || name.trim().isEmpty()) {
                System.out.println("Entro");
                return null;
            }
            System.out.println("Paso");
            return criteriaBuilder.equal(root.get("product").get("name"), name);
        };
    }

    public static Specification<ProductVariant> hasCategory(String category) {
        return (root, query, criteriaBuilder) -> {
            if(category == null || category.trim().isEmpty()) {
                return null;
            }
            return criteriaBuilder.equal(root.get("product").get("category").get("name"), category);
        };
    }

    public static Specification<ProductVariant> hasSize(String size){
        return(root, query, criteriaBuilder) -> {
            if(size == null || size.trim().isEmpty()) {
                return null;
            }
            return criteriaBuilder.equal(root.get("size"), size);
        };
    }


    public static Specification<ProductVariant> hasColor(String color){
        return(root, query, criteriaBuilder) -> {
            if(color == null || color.trim().isEmpty()) {
                return null;
            }
            return criteriaBuilder.equal(root.get("color"), color);
        };
    }

    public static Specification<ProductVariant> priceBetween(Double minPrice, Double maxPrice) {
        return (root, query, criteriaBuilder) -> {
            if (minPrice == null && maxPrice == null) {
                return null; // no filter
            }

            if (minPrice != null && maxPrice != null) {
                return criteriaBuilder.between(root.get("price"), minPrice, maxPrice);
            } else if (minPrice != null) {
                return criteriaBuilder.ge(root.get("price"), minPrice);
            } else {
                return criteriaBuilder.le(root.get("price"), maxPrice);
            }
        };
    }



}
