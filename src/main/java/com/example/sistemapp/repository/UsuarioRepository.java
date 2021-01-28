package com.example.sistemapp.repository;

import com.example.sistemapp.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository <Usuario, String> {
   Usuario findByCodigo(long codigo);


}
