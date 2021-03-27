package com.example.sistemapp.controller;


import com.example.sistemapp.entity.Data;
import com.example.sistemapp.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
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
import java.time.LocalDateTime;
import java.util.Date;


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

    @PostMapping("/imagem")
    public String uploadFiles(@RequestParam("conteudo")  MultipartFile multipartFile, RedirectAttributes redirectAttributes ) throws IOException {
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        Data conteudo = new Data();
        conteudo.setNomeArquivo(fileName);
        conteudo.setUploadTime(new Date());
        conteudo.setConteudo(multipartFile.getBytes());

        dataRepository.save(conteudo);

        redirectAttributes.addFlashAttribute("message", "Upload feito com sucesso");
        System.out.println("Funcionou");
        return "data/dataImagem";

    }


    @RequestMapping("/datas")
    public ModelAndView ListaData() {
        ModelAndView cmv = new ModelAndView("data/listarData");
        Iterable<Data> Datas = dataRepository.findAll();
        cmv.addObject("datas", Datas);
        return cmv;
    }

}
