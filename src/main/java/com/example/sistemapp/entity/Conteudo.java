package com.example.sistemapp.entity;


import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Conteudo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    private long codigo;

    @Column
    private String material;
    @Column
    private Integer quantPalavras;

    @Column
    private Integer quantCaracteres;


    public Conteudo() {
    }

    public Conteudo(long codigo, String material, Integer quantPalavras, Integer quantCaracteres) {
        this.codigo = codigo;
        this.material = material;
        this.quantPalavras = quantPalavras;
        this.quantCaracteres = quantCaracteres;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Integer getQuantPalavras() {
        return this.quantPalavras;
    }

    public void setQuantPalavras(Integer quantPalavras) {
        this.quantPalavras = quantPalavras;
    }

    public Integer getQuantCaracteres() {
        return quantCaracteres;
    }

    public void setQuantCaracteres(int quantCaracteres) {
        this.quantCaracteres = quantCaracteres;
    }


  //  public Integer getQuantPalavras() {
        //return quantPalavras;
    //}

//    public  Integer salvar()
//    {
//        try
//        {
//            quantPalavras = getQuantPalavras();
//            return quantPalavras;
//
//        }
//        catch (Exception error)
//        {
//            throw error;
//
//        }
   }





