package com.example.sistemapp.repository;

import com.example.sistemapp.entity.Data;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DataRepository extends CrudRepository<Data, String> {
    Data findByCodigo(long codigo);
}
