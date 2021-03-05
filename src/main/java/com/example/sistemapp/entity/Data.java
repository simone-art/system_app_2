package com.example.sistemapp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name= "files")
public class Data implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    private long codigo;

    @Column
    @JsonFormat(pattern = "dd-MM-yyyy HH: mm: ss")
    private LocalDateTime createDate;

    @Column
    @JsonFormat(pattern = "dd-MM-yyyy HH: mm: ss")
    private LocalDateTime updateDate;

    private String nomeArquivo;

    private byte[] imagem;

    public Data(long codigo, LocalDateTime createDate, LocalDateTime updateDate, String nomeArquivo, byte[] imagem) {
        this.codigo = codigo;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.nomeArquivo = nomeArquivo;
        this.imagem = imagem;
    }

    public Data(String dataname, String contentType, byte[] bytes) {
    }


    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

    // @PrePersist salva o momento exato do file
    @PrePersist
    protected void onCreate(){
        this.createDate = LocalDateTime.now();
    }

    //@PreUpdate atualiza a hora que está sendo persistido o objeto no banco
    //De dados. Neste caso, quando for atualizado
    @PreUpdate
    protected void onUpdate(){
        this.updateDate = LocalDateTime.now();
    }
}
