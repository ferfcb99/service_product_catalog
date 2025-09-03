package com.quantum.leap.productcatalog.service.impl;

import com.quantum.leap.productcatalog.service.UtilService;
import org.springframework.stereotype.Service;

@Service
public class UtilServiceImpl implements UtilService {

    public UtilServiceImpl() {}

    @Override
    public Boolean isStringEmptyOrNull(String str) {
        return str == null || str.isEmpty();
    }

    @Override
    public Boolean isNumberNull(Long num) {
        return num == null;
    }

}
