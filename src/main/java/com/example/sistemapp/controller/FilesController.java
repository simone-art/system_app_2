package com.example.sistemapp.controller;

import com.example.sistemapp.entity.Files;
import com.example.sistemapp.repository.FilesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class FilesController {

    @Autowired
    private FilesRepository filesRepository;

    // Pasta de destino pra subir as imagens
    private static String uploadFolder = "C:\\Users\\s.santos.pimenta\\Desktop\\img";

    @RequestMapping(value = "/imagem", method = RequestMethod.GET)
    public String input() {
        return "/files/filesImagem";
    }

    @RequestMapping(value = "/imagem", method = RequestMethod.POST)

    public ModelAndView fileUpload(@RequestParam("files") MultipartFile file, RedirectAttributes redirectAttributes){
        if (file.isEmpty()){
            return new ModelAndView("status", "message",
                    "Por favor, seleciona um arquivo e faz o upload ");

        }
        try{
            //Lê e escreve o arquivo selecionado na pasta
            byte[] bytes = file.getBytes();
            Path path = Paths.get(uploadFolder + file.getOriginalFilename());
            //Files.write(path, bytes);
        } catch (IOException e){
            e.printStackTrace();
        }
        return new ModelAndView("status", "message", "Upload feito com sucesso");
    }

//    public String input(Files imagem ) {
//        filesRepository.save(imagem);
//        System.out.println("Funciona");
//        return "redirect:/files";
//
//    }


    }


