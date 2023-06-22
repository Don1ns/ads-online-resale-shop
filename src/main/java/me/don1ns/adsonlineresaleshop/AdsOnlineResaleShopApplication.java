package me.don1ns.adsonlineresaleshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AdsOnlineResaleShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdsOnlineResaleShopApplication.class, args);
    }

}
