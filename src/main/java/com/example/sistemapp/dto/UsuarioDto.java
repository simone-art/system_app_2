package com.example.sistemapp.dto;


import org.springframework.stereotype.Component;
import java.io.Serializable;

@Component
public class UsuarioDto implements Serializable {

    private static  final long serialVersionUID = 1L;
    private long codigo;
    private String nome;
    private String sobrenome;

    /*
    Criação Constructores, Getters and Setters
     */

    public UsuarioDto(long codigo, String nome, String sobrenome) {
        this.codigo = codigo;
        this.nome = nome;
        this.sobrenome = sobrenome;
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
        return nome;
    }

    public void setNome(String nome) {
        nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        sobrenome = sobrenome;
    }


}
