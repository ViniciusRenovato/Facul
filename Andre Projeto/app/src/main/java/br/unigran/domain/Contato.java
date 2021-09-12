package br.unigran.domain;

import android.graphics.Bitmap;
import android.text.Editable;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class Contato implements Serializable {
    private Integer id;
    private String nome;
    private String numTelefone;
    private String emailContato;
    private String enderecoContato;
    private byte[] imagem;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumTelefone() {
        return numTelefone;
    }

    public void setNumTelefone(String numTelefone) {
        this.numTelefone = numTelefone;
    }

    public String getEmailContato() {
        return emailContato;
    }

    public void setEmailContato(String emailContato) {
        this.emailContato = emailContato;
    }

    public String getEnderecoContato() {
        return enderecoContato;
    }

    public void setEnderecoContato(String enderecoContato) {
        this.enderecoContato = enderecoContato;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contato contato = (Contato) o;
        return Objects.equals(id, contato.id);
    }
}
