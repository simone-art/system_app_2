package com.example.sistemapp.controller;

import com.example.sistemapp.entity.Conteudo;
import com.example.sistemapp.repository.ConteudoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ConteudoController {

    @Autowired
    private ConteudoRepository cr;


    @RequestMapping(value = "/conteudo", method = RequestMethod.GET)
    public String textarea() {
        return "/conteudo/conteudoTextarea";
    }

    @RequestMapping(value = "/conteudo", method = RequestMethod.POST)
    public String textarea(String material) {
        contarPalavras(material);
        return "redirect:/conteudo";

    }

    public Integer contarPalavras(String material) {
        Integer quantPalavras = 0;
        if (!(" ".equals(material.substring(0, 1))) || !(" ".equals(material.substring(material.length() - 1)))) {
            for (int i = 0; i < material.length(); i++) {
                if (material.charAt(i) == ' ') {
                    quantPalavras++;
                }
            }
            quantPalavras = quantPalavras + 1;
        }
        System.out.println("Palavras: " + quantPalavras);
        Conteudo conteudo = new Conteudo();
        conteudo.setMaterial(material);
        conteudo.setQuantPalavras(quantPalavras);
        cr.save(conteudo);
       return quantPalavras;
    }

    @RequestMapping("/conteudos")
    public ModelAndView ListaConteudos() {
        ModelAndView cmv = new ModelAndView("conteudo/conteudoUsuario");
        Iterable<Conteudo> Conteudos = cr.findAll();
        cmv.addObject("conteudos", Conteudos);
        return cmv;
    }

    //Não se pode ter duas url com a mesma direção/ elas devem ser únicas
    // Antes no GetMapping estava ("/editar/{codigo}") e isso estava iguazinho
    //No UsuarioController, aí na hora de compilar da erro.

    @GetMapping ("/editarConteudo/{codigo}")
    public ModelAndView editar(@PathVariable long codigo){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("conteudo/editarConteudo");
        Conteudo conteudo = cr.findByCodigo(codigo);
        mv.addObject("conteudo", conteudo);
        return mv;
    }

    @PostMapping("/editarConteudo")
    public ModelAndView editar(Conteudo conteudo){
        ModelAndView mv = new ModelAndView();
        contarPalavras(conteudo.getMaterial());
        mv.setViewName("redirect:/conteudos");
        return mv;
    }


    @GetMapping("/deletarConteudo/{codigo}")
    public String deletarConteudo(@PathVariable long codigo){
        Conteudo conteudo = cr.findByCodigo(codigo);
        cr.delete(conteudo);
        return "redirect:/conteudos";
    }

    /**
     * Métodos para fazer o upload da imagem na database
     */

    @RequestMapping(value = "/conteudo", method = RequestMethod.GET)
    public String input() {
        return "/conteudo/conteudoTextarea";
    }

    @RequestMapping(value = "/conteudo", method = RequestMethod.POST)
    public String input(String material) {
        return "redirect:/conteudo";

    }

}
