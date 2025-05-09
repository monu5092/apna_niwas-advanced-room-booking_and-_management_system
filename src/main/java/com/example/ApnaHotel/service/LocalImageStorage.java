package com.example.ApnaHotel.service;

import com.example.ApnaHotel.exception.OurException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class LocalImageStorage {

    private final String folderName = "Hotel_Room_Images";

    public String saveImageToLocal(MultipartFile photo){
        try{
            String fileName = photo.getOriginalFilename();

            if(fileName == null || fileName.isEmpty()){
                throw new OurException("Invalid File Name");
            }

            File folder = new File(folderName);
            if(!folder.exists()){
                folder.mkdirs();
            }

            Path filePath = Paths.get(folderName,fileName);
            Files.write(filePath, photo.getBytes());
            return folderName+"/"+fileName;
        }
        catch (IOException e){
            throw new OurException("Unable to save image locally: "+ e.getMessage());
        }
    }
}
