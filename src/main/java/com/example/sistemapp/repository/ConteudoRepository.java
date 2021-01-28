package com.example.sistemapp.repository;

import com.example.sistemapp.entity.Conteudo;
import org.springframework.data.repository.CrudRepository;



public interface ConteudoRepository extends CrudRepository<Conteudo, String> {
    Conteudo findByCodigo(long codigo);
}
