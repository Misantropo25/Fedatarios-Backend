package com.fedatarios.config;

import com.fedatarios.service.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StorageServiceInitializer implements CommandLineRunner {

    private final StorageService storageService;

    public StorageServiceInitializer(StorageService storageService) {
        this.storageService = storageService;
    }

    @Override
    public void run(String... args) {
        storageService.init();
    }
}