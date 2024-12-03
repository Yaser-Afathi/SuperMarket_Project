package org.example.supermarketwebapp;

import org.example.supermarketwebapp.Entities.Account;
import org.example.supermarketwebapp.Utilities.DatabaseUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.core.annotation.Order;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication

public class SuperMarketWebAppApplication implements CommandLineRunner {
    @Autowired
    DatabaseUtility databaseUtility;

    public static void main(String[] args) {
        SpringApplication.run(SuperMarketWebAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
         databaseUtility.initDatabase();
    }
}

