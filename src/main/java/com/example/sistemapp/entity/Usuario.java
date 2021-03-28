package com.example.sistemapp.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;


@Entity
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="native")
    @GenericGenerator(name="native", strategy = "native")
    private long codigo;

    @Column
    @NotBlank
    @Size(min= 3, max = 40, message = "O nome deve contar no mínimo 3 caracteres")
    private String nome;

    @Column
    @NotBlank
    @Size(min= 3, max = 40, message = "O nome deve contar no mínimo 3 caracteres")
    private String sobrenome;

    @Column(unique = true)
    @NotBlank
    @Email
    private String email;

    @Column
    @NotBlank
    @Size(min= 3, max = 40, message = "A senha deve contar no mínimo  com 6 caracteres, uma letra em maiúscula e caracteres especiais")
    private String senha;

    @Transient
    private String confirmaSenha;

    public Usuario() {
    }

    public Usuario(long codigo, @NotBlank @Size(min = 3, max = 40, message = "O nome deve contar no mínimo 3 caracteres") String nome, @NotBlank @Size(min = 3, max = 40, message = "O nome deve contar no mínimo 3 caracteres") String sobrenome, @NotBlank @Email String email, @NotBlank @Size(min = 3, max = 40, message = "A senha deve contar no mínimo  com 6 caracteres, uma letra em maiúscula e caracteres especiais") String senha, String confirmaSenha) {
        this.codigo = codigo;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.senha = senha;
        this.confirmaSenha = confirmaSenha;
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
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getConfirmaSenha() {
        return confirmaSenha;
    }

    public void setConfirmaSenha(String confirmaSenha) {
        this.confirmaSenha = confirmaSenha;
    }
}
