package com.example.sistemapp.converter;

import com.example.sistemapp.dto.UsuarioDto;
import com.example.sistemapp.entity.Usuario;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UsuarioDtoConverter {

    public UsuarioDto entityToDto(Usuario usuario){
        UsuarioDto dto = new UsuarioDto();
        dto.setCodigo(usuario.getCodigo());
        dto.setNome(usuario.getNome());
        dto.setSobrenome(usuario.getSobrenome());
        return dto;
    }

    public List<UsuarioDto> entityToDto(List<Usuario> usuario){
        return usuario.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
    }

    public Usuario dtoToEntity(UsuarioDto dto){
        Usuario usuario = new Usuario();
        usuario.setCodigo(dto.getCodigo());
        usuario.setNome(dto.getNome());
        usuario.setSobrenome(dto.getSobrenome());
        return usuario;
    }

    public List<Usuario> dtoToEntity(List<UsuarioDto> dto){
        return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
    }
}
