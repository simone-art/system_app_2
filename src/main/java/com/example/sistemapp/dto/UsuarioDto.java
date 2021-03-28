package com.example.sistemapp.dto;

import java.io.Serializable;

public class UsuarioDto implements Serializable {

    private static  final long serialVersionUID = 1L;
    private long codigo;
    private String Nome;
    private String Sobrenome;

    /*
    Criação Constructores, Getters and Setters
     */

    public UsuarioDto(long codigo, String nome, String sobrenome) {
        this.codigo = codigo;
        Nome = nome;
        Sobrenome = sobrenome;
    }

    public UsuarioDto() {
    }

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
