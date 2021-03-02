package com.example.sistemapp.repository;

import com.example.sistemapp.entity.Files;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FilesRepository extends CrudRepository<Files, String> {
    Files findByCodigo(long codigo);
}
