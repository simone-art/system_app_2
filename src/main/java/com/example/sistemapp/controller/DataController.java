package com.example.sistemapp.controller;

import com.example.sistemapp.entity.Data;
import com.example.sistemapp.repository.DataRepository;
import com.example.sistemapp.service.DataStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
//@EnableAutoConfiguration(exclude = {MultipartAutoConfiguration.class})
public class DataController {

//    @Autowired
//    private DataRepository dataRepository;

    @Autowired
    private DataStorageService dataStorageService;

    private Data data;

    // Pasta de destino pra subir as imagens
    private static String uploadFolder = "C:\\Users\\s.santos.pimenta\\Desktop\\img";

    @RequestMapping(value = "/imagem", method = RequestMethod.GET)
    public String input() {
        return "/data/dataImagem";
    }

//    @Bean
//    public MultipartConfigElement multipartConfigElement() {
//        return new MultipartConfigElement("");
//    }
//
//    @Bean
//    public MultipartResolver multipartResolver() {
//        org.springframework.web.multipart.commons.CommonsMultipartResolver multipartResolver = new org.springframework.web.multipart.commons.CommonsMultipartResolver();
//        multipartResolver.setMaxUploadSize(2000000);
//        return multipartResolver;
//    }

    @RequestMapping(value = "/imagem", method = RequestMethod.POST)
    public String uploadMultipleFiles(@RequestParam("files") MultipartFile[] files){
        for (MultipartFile file : files) {
            dataStorageService.saveFile(file);
        }
        return "redirect:/imagem";
    }

//    public String upload(Model model, @RequestParam("files") MultipartFile[] files) {
//        StringBuilder filesNames = new StringBuilder();
//        for (MultipartFile file : files) {
//            Path fileNameAndPath = Paths.get(uploadFolder, file.getOriginalFilename());
//            filesNames.append(file.getOriginalFilename());
//            try {
//                byte[] bytes = file.getBytes();
//                Path path = Paths.get(uploadFolder + file.getOriginalFilename());
//                //Files.write(fileNameAndPath, file.getBytes());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            model.addAttribute("mensagem", "Upload feito com sucesso" + filesNames.toString());
//
//        }
//        return "/imagem";
//    }


//    public ModelAndView fileUpload(@RequestParam("files") MultipartFile file, RedirectAttributes redirectAttributes){
//        if (file.isEmpty()){
//            return new ModelAndView("status", "message",
//                    "Por favor, seleciona um arquivo e faz o upload ");
//
//        }
//        try{
//            //Lê e escreve o arquivo selecionado na pasta
//            byte[] bytes = file.getBytes();
//            Path path = Paths.get(uploadFolder + file.getOriginalFilename());
//            //Files.write(path, bytes);
//        } catch (IOException e){
//            e.printStackTrace();
//        }
//        return new ModelAndView("status", "message", "Upload feito com sucesso");
//    }

//    public String input(Files imagem ) {
//        filesRepository.save(imagem);
//        System.out.println("Funciona");
//        return "redirect:/files";
//
//    }


    }


