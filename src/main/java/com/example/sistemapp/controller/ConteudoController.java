package com.example.sistemapp.controller;

import com.example.sistemapp.entity.Conteudo;
import com.example.sistemapp.entity.Usuario;
import com.example.sistemapp.repository.ConteudoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.Document;

import javax.print.Doc;
import javax.swing.*;
import java.util.Locale;
import java.util.Scanner;
import java.util.StringTokenizer;

@Controller
public class ConteudoController {

    @Autowired
    private ConteudoRepository cr;

    @RequestMapping(value = "/conteudo", method = RequestMethod.GET)
    public String textarea() {
        return "/conteudo/conteudoTextarea";
    }

    @RequestMapping(value = "/conteudo", method = RequestMethod.POST)
    public String textarea(Conteudo conteudo) {
        cr.save(conteudo);
        //contadorPalavras(conteudo.getMaterial());
        //JOptionPane.showMessageDialog(null, "A aquantidade de palavras é: " + conteudo.getMaterial());
        //contadorCaracteres(conteudo.getMaterial());

        return "redirect:/conteudo";

    }

//    public static int contadorPalavras (String Material){
//        Scanner lerPalavras = new Scanner(System.in);
//        lerPalavras.next().trim();
    //Material = Material.trim();
//        int quantPalavras = 0 ;
//        if (Material.isEmpty()) {
//            quantPalavras = 0;
//        } else {
//            Material.indexOf(" ");
//            for (int x = 0; x <Material.length(); x++);{
//                quantPalavras = Material.indexOf(" ", quantPalavras + 1);
//            }
//        }
//        return quantPalavras;
//
//    }

    //public static int contadorCaracteres(String Material) {
    //String[] arr;
    //Scanner sc = new Scanner(System.in);
    //String material = sc.nextLine();
    //int palavras = 0;
    //int palavras = palavras.length();
    //arr = new String[palavras];
    //for (int i = 0; i <palavras; i++) {
    //char a = palavras.charAt(pa);
    //arr[i] = String.valueOf(a);
    //}
    //return palavras;
    //}


    @RequestMapping("/conteudos")
    public ModelAndView ListaConteudos() {
        ModelAndView cmv = new ModelAndView("conteudo/conteudoUsuario");
        Iterable<Conteudo> Conteudos = cr.findAll();
        cmv.addObject("conteudos", Conteudos);
        return cmv;
    }


//    @RequestMapping("conteudo/dadosConteudo/{codigo}")
//    public ModelAndView dadosConteudo(@PathVariable("codigo") long codigo) {
//        Conteudo conteudo = cr.findByCodigo(codigo);
//        ModelAndView cmv = new ModelAndView("conteudo/dadosConteudo");
//        cmv.addObject("conteudo", conteudo);
//        return cmv;
//
//    }

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
        cr.save(conteudo);
        mv.setViewName("redirect:/conteudos");
        return mv;
    }


//    @GetMapping("/deletar/{codigo}")
//    public String deletarConteudo(@PathVariable long codigo){
//        Conteudo conteudo = cr.findByCodigo(codigo);
//        cr.delete(conteudo);
//        return "redirect:/usuarios";
//    }

}
