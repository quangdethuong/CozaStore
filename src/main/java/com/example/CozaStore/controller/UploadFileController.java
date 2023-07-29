package com.example.CozaStore.controller;

import com.example.CozaStore.payload.response.BaseResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@RestController
@RequestMapping("/file")
public class UploadFileController {

    @Value("${path.root}")
    private String sPath;
    @PostMapping("/uploadFile")
    public ResponseEntity<?> uploadFile(
            @RequestParam MultipartFile file) {
        Path rootPath = Paths.get(sPath);

        try {
            if (!Files.exists(rootPath)) {
                Files.createDirectories(rootPath);
            }

            // take file name and format
            String fileName = file.getOriginalFilename();
            Files.copy(
                    file.getInputStream(),
                    rootPath.resolve(fileName),
                    StandardCopyOption.REPLACE_EXISTING
            );
        } catch (Exception e) {
            System.out.println("UploadFileController _ Exception " + e.getMessage());
        }
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @GetMapping("/{filename}")
    public ResponseEntity<?> loadFile(
            @PathVariable String filename){

        BaseResponse response = new BaseResponse();

        try{
          // images folder
            Path rootPath = Paths.get(sPath);
            Resource resource =  new UrlResource(rootPath.resolve(filename).toUri());

            if(resource.exists()){

                return ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_DISPOSITION,
                                "att achment; filename=\"" + resource.getFilename() + "\"")
                        .body(resource);
            }
        }catch(Exception e){
            System.out.println("UploadFileController _ Exception " + e.getMessage());
            response.setStatusCode(500);
            response.setData(e.getMessage());
        }
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
