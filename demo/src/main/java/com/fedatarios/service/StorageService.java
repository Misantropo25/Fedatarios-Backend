package com.fedatarios.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

@Service
public class StorageService {

    private final Path rootLocation = Paths.get("uploaded-documents");
    private String filename;

    public String store(MultipartFile file) {
        try {
            String originalFilename = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
            String fileExtension = StringUtils.getFilenameExtension(originalFilename);
            String filenameWithoutExtension = StringUtils.stripFilenameExtension(originalFilename);
            String filename = filenameWithoutExtension + "_" + System.currentTimeMillis() + "." + fileExtension;

//            String filename = StringUtils.cleanPath(file.getOriginalFilename());
            if (file.isEmpty()) {
                throw new RuntimeException("Failed to store empty file " + filename);
            }
            Files.copy(file.getInputStream(), this.rootLocation.resolve(filename), StandardCopyOption.REPLACE_EXISTING);

//            return this.rootLocation.resolve(filename).toString(); // Retorna la ruta completa del archivo
            return filename;

        } catch (IOException e) {
            throw new RuntimeException("Failed to store file " + filename, e);
        }
    }

    public Path load(String filename) {
        return rootLocation.resolve(filename);
    }
    // Método init y otros métodos...
    public void init() {
        try {
            Files.createDirectories(rootLocation);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize storage", e);
        }
    }
}