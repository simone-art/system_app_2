package com.example.sistemapp.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Conteudo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="native")
    @GenericGenerator(name="native", strategy = "native")
    private long codigo;

    @Column
    private String Material;
    @Column
    private int quantPalavras;
    @Column
    private int quantCaracteres;

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getMaterial() {
        return Material;
    }

    public void setMaterial(String material) {
        Material = material;
    }

    public int getQuantPalavras() {
        return quantPalavras;
    }

    public void setQuantPalavras(int quantPalavras) {
        quantPalavras = quantPalavras;
    }

    public int getQuantCaracteres() {
        return quantCaracteres;
    }

    public void set(int quantCaracteres) {
        quantCaracteres = quantCaracteres;
    }
}
