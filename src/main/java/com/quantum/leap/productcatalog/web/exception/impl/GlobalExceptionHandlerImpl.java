package com.quantum.leap.productcatalog.web.exception.impl;

import com.quantum.leap.productcatalog.web.dto.ResponseModelApi;
import com.quantum.leap.productcatalog.web.exception.GlobalExceptionHandler;
import com.quantum.leap.productcatalog.web.exception.model.ProductCatalogExeption;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandlerImpl implements GlobalExceptionHandler {

    @ExceptionHandler(ProductCatalogExeption.class)
    public ResponseEntity<ResponseModelApi<String>> handleProductCatalogException(ProductCatalogExeption productCatalogExeption) {
        return ResponseEntity.status(Integer.parseInt(productCatalogExeption.getCode()))
                .body(new ResponseModelApi<>(
                        productCatalogExeption.getCode(),
                        productCatalogExeption.getMessage(),
                        productCatalogExeption.getDetails()
                ));
    }

}
