package br.com.guruDelivery.GuruDelivey.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
@Getter
@Setter
public class FileUploadService {

    @Value("${upload.path}")
    private String uploadPath;

    public String saveFile(MultipartFile file){
        Path root = Paths.get(uploadPath);
        var filename = UUID.randomUUID();
        var extension = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        var fullname = filename+extension;
        try {
            Files.copy(file.getInputStream(), root.resolve(fullname));
        } catch (IOException e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
            throw new RuntimeException(e);
        }
        return fullname;
    }
}
