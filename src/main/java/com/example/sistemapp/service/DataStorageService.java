package com.example.sistemapp.service;

import com.example.sistemapp.entity.Data;
import com.example.sistemapp.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class DataStorageService {

    @Autowired
    private DataRepository dataRepository;

    public Data saveFile(MultipartFile file){
        String dataname = file.getOriginalFilename();
        try{
            Data data = new Data(dataname,
                    file.getContentType(),
                    file.getBytes());
            return dataRepository.save(data);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

//    public Optional<Data>getFile(long codigo){
//        return dataRepository.findById(codigo);
//    }
//
//    public List<Data>getFiles(){
//        return dataRepository.findAll();
//    }
}
