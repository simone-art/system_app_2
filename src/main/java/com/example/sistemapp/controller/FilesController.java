package com.example.sistemapp.controller;

import com.example.sistemapp.repository.FilesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class FilesController {

    @Autowired
    private FilesRepository filesRepository;

}
