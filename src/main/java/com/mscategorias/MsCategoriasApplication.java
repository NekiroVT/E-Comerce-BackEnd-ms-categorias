package com.mscategorias;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient // ✅ Para que se registre en Eureka (cuando lo configures)
public class MsCategoriasApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsCategoriasApplication.class, args);
    }

}
