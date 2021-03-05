package com.example.sistemapp.controller;

import com.example.sistemapp.entity.Conteudo;
import com.example.sistemapp.entity.Data;
import com.example.sistemapp.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
//@EnableAutoConfiguration(exclude = {MultipartAutoConfiguration.class})
public class DataController {

    @Autowired
    private DataRepository dataRepository;


    // Pasta de destino pra subir as imagens
    private static String uploadFolder = "C:\\Users\\s.santos.pimenta\\Desktop\\img";

    @RequestMapping(value = "/imagem", method = RequestMethod.GET)
    public String input() {
        return "/data/dataImagem";
    }


    @RequestMapping(value = "/imagem", method = RequestMethod.POST)
    public String upload(Model model, MultipartFile[] files) {
        StringBuilder filesNames = new StringBuilder();
        if (files != null) {
            for (MultipartFile file : files) {
                Path fileNameAndPath = Paths.get(uploadFolder, file.getOriginalFilename());
                filesNames.append(file.getOriginalFilename());
                try {
                    byte[] bytes = file.getBytes();
                    Path path = Paths.get(uploadFolder + file.getOriginalFilename());
                    Files.write(fileNameAndPath, file.getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                model.addAttribute("mensagem", "Upload feito com sucesso" + filesNames.toString());

            }
        }
        System.out.println("Funcionou");
        return "data/dataImagem";
    }

    @RequestMapping("/imagens")
    public ModelAndView ListaData() {
        ModelAndView cmv = new ModelAndView("data/listarData");
        Iterable<Data> Datas = dataRepository.findAll();
        cmv.addObject("data", Datas);
        return cmv;
    }
}
