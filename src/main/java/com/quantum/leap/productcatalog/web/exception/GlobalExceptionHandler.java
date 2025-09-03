package com.quantum.leap.productcatalog.web.exception;

import com.quantum.leap.productcatalog.web.dto.ResponseModelApi;
import com.quantum.leap.productcatalog.web.exception.model.ProductCatalogExeption;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.Map;

public interface GlobalExceptionHandler {

    ResponseEntity<ResponseModelApi<String>> handleProductCatalogException(ProductCatalogExeption productCatalogExeption);

    ResponseEntity<ResponseModelApi<Map<String, String>>>  handleMethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException);


}
