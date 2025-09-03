package com.quantum.leap.productcatalog.web.exception.impl;

import com.quantum.leap.productcatalog.web.dto.ResponseModelApi;
import com.quantum.leap.productcatalog.web.exception.GlobalExceptionHandler;
import com.quantum.leap.productcatalog.web.exception.model.ProductCatalogExeption;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandlerImpl implements GlobalExceptionHandler {

    @Override
    @ExceptionHandler(ProductCatalogExeption.class)
    public ResponseEntity<ResponseModelApi<String>> handleProductCatalogException(ProductCatalogExeption productCatalogExeption) {
        return ResponseEntity.status(Integer.parseInt(productCatalogExeption.getCode()))
                .body(new ResponseModelApi<>(
                        productCatalogExeption.getCode(),
                        productCatalogExeption.getMessage(),
                        productCatalogExeption.getDetails()
                ));
    }


    @Override
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseModelApi<Map<String, String>>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage())
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ResponseModelApi<>("400", "", errors));
    }

}
