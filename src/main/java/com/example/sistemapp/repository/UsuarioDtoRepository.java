package com.example.sistemapp.repository;

import com.example.sistemapp.dto.UsuarioDto;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioDtoRepository extends CrudRepository<UsuarioDto,String > {
    UsuarioDto findByCodigo(long codigo);
}
