package com.example.sistemapp.controller;

import com.example.sistemapp.dto.UsuarioDto;
import com.example.sistemapp.entity.Conteudo;
import com.example.sistemapp.entity.Usuario;
import com.example.sistemapp.repository.UsuarioRepository;
import org.dom4j.rule.Mode;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;


@Controller
public class UsuarioController {

    @Autowired
    private UsuarioRepository ur;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UsuarioDto usuarioDto;

    @RequestMapping(value = "/cadastrarUsuario", method = RequestMethod.GET)
    public String form() {
        return "usuario/formUsuario";
    }


//    @RequestMapping(value = "/cadastrarUsuario", method = RequestMethod.POST)
//    public String form(@Valid Usuario usuario) {
//         ur.save(usuario);
//         return "redirect:/cadastrarUsuario";
//    }


   @PostMapping("/cadastrarUsuario")
    public String form(@Valid Usuario usuario, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            attributes.addFlashAttribute("mensagem", "Verifique os campos!");
            return "redirect:/cadastrarUsuario";
        } else{
            ur.save(usuario);
            attributes.addFlashAttribute("mensagem", "Cadastro feito com sucesso!");
        }
            return "redirect:/conteudo";

    }

    @RequestMapping("/usuarios")
    public ModelAndView ListaUsuarios(){
        ModelAndView mv = new ModelAndView("index");
        //ModelAndView mv = new ModelAndView("usuario/listaTodosUsuarios");
        Iterable<Usuario>Usuarios = ur.findAll();
        mv.addObject("usuarios", Usuarios);
        return mv;
    }

    @RequestMapping("dadosUsuario/{codigo}")
    public ModelAndView dadosUsuario(@PathVariable("codigo") long codigo) {
        Usuario usuario = ur.findByCodigo(codigo);
        ModelAndView mv = new ModelAndView("usuario/dadosUsuario");
        mv.addObject("usuario", usuario);
        return mv;
    }

//    Este código get e post pra editar e salvar o dado novo na database,
//    para poder funcionar, o nome de ambos métodos deve ser um verbo o uma
//    palavra curta. Com palavras compostas ele não funciona!

  @GetMapping ("/editar/{codigo}")
    public ModelAndView editar(@PathVariable long codigo){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("usuario/editarUsuario");
       Usuario usuario = ur.findByCodigo(codigo);
       mv.addObject("usuario", usuario);
        return mv;
  }

  @PostMapping("/editar")
    public ModelAndView editar(Usuario usuario){
        ModelAndView mv = new ModelAndView();
        ur.save(usuario);
        mv.setViewName("redirect:/usuarios");
        return mv;
   }


    @GetMapping("/deletar/{codigo}")
    public String deletarUsuario(@PathVariable long codigo){
        Usuario usuario = ur.findByCodigo(codigo);
        ur.delete(usuario);
        return "redirect:/usuarios";
    }


    // Cadastro Usuario edit
//    @RequestMapping(value = "/usuarios", method = RequestMethod.GET)
//    public ModelAndView editarUsuario(long codigo) {
//        Usuario usuario = ur.findByCodigo(codigo);
//        ModelAndView mv = new ModelAndView("usuario/index");
//        mv.addObject("usuario", usuario);
//        return mv;
//    }

//    @RequestMapping(value = "{codigo}", method = RequestMethod.DELETE)
//    public String deletarUsuario(@PathVariable long codigo, Usuario usuario, RedirectAttributes attributes) {
//        ur.delete(usuario);
//        attributes.addFlashAttribute("success", "Usuário deletado com sucesso!");
//        return "redirect:/cadastrarUsuario";
//    }


//    @RequestMapping ("/usuarios/{id}")
//    public String deletarUsuario( long codigo){
//        Usuario usuario = ur.findByCodigo(codigo);
//        ur.delete(usuario);
//        return "redirect:/cadastrarUsuario";
//    }
//



}


