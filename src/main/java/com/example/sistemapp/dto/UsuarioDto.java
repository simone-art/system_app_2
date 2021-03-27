package com.example.sistemapp.dto;

import org.springframework.context.annotation.Configuration;

@Configuration
public class UsuarioDto {

    private long codigo;
    private String Nome;
    private String Sobrenome;

    /*
    Criação Getters and Setters
     */

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getSobrenome() {
        return Sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        Sobrenome = sobrenome;
    }
}
