package com.amora;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.*")
public class PedidosEmCasaApp {
    public static void main(String[] args) {
        SpringApplication.run(PedidosEmCasaApp.class,args);
    }
}
