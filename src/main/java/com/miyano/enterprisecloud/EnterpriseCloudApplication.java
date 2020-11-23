package com.miyano.enterprisecloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Miyano
 */
@SpringBootApplication
public class EnterpriseCloudApplication {
    public static void main (String[] args) {
        SpringApplication.run (EnterpriseCloudApplication.class, args);
    }

}