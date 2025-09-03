package com.quantum.leap.productcatalog.web.exception.model;

public class ProductCatalogExeption extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String code;

    private String details;

    public ProductCatalogExeption(String message) {
        super(message);
    }

    public ProductCatalogExeption(String code, String message, String details) {
        super(message);
        this.code = code;
        this.details = details;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

}
