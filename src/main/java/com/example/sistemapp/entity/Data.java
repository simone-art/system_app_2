package com.example.sistemapp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name= "data")
public class Data implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    private long codigo;

    @Column
    private Date uploadTime;
    @Column
     String nomeArquivo;

    @Column (length = 5000)
    private byte[] conteudo;

    public Data(long codigo, Date uploadTime, String nomeArquivo, byte[] conteudo) {
        this.codigo = codigo;
        this.uploadTime = uploadTime;
        this.nomeArquivo = nomeArquivo;
        this.conteudo = conteudo;
    }

    public Data() {
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public byte[] getConteudo() {
        return conteudo;
    }

    public void setConteudo(byte[] conteudo) {
        this.conteudo = conteudo;
    }
}
