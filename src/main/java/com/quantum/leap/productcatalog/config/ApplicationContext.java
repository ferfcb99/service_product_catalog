package com.quantum.leap.productcatalog.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(
        basePackages = {"com.quantum.leap.productcatalog.repository"}
)
@EntityScan(
        basePackages = {"com.quantum.leap.productcatalog.entity"}
)
public class ApplicationContext {
}
