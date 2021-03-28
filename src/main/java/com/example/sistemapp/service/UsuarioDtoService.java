package com.example.sistemapp.service;

import com.example.sistemapp.dto.UsuarioDto;
import com.example.sistemapp.entity.Usuario;
import com.example.sistemapp.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioDtoService {

    @Autowired
    private UsuarioRepository ur;

    public List<UsuarioDto> getAllUsuarios() {
        return ((List<Usuario>) ur
                .findAll())
                .stream()
                .map(this::convertToEntityToDto)
                .collect(Collectors.toList());
    }

    public UsuarioDto convertToEntityToDto(Usuario usuario){
        UsuarioDto dto = new UsuarioDto();
        dto.setCodigo(usuario.getCodigo());
        dto.setNome(usuario.getNome());
        dto.setSobrenome(usuario.getSobrenome());
        return dto;
    }

}
