package com.example.sistemapp.controller;

import com.example.sistemapp.converter.UsuarioDtoConverter;
import com.example.sistemapp.dto.UsuarioDto;
import com.example.sistemapp.entity.Usuario;
import com.example.sistemapp.repository.UsuarioDtoRepository;
import com.example.sistemapp.repository.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UsuarioDtoController {

    @Autowired
    private  UsuarioDtoRepository usuarioDtoRepository;

    @Autowired
    private UsuarioRepository ur;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UsuarioDtoConverter converter;

//   @GetMapping("/findAll")
//    public List<UsuarioDto> findAll(Usuario usuario){
//       Iterable<Usuario> Usuarios = ur.findAll();
//       return converter.entityToDto(usuario);
//
//   }


//    @GetMapping("/find/{codigo}")
//    public UsuarioDto findbyId(@PathVariable(value = "id") long codigo){
//        ur.findByCodigo(codigo);
//        return converter.entityToDto("id");
//
//    }

    @PostMapping("/save")
    public UsuarioDto save(@RequestBody UsuarioDto dto){
        Usuario usuario = converter.dtoToEntity(dto);
        usuario = ur.save(usuario);
        return converter.entityToDto(usuario);

    }

}
