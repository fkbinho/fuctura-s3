package com.biblioteca.fuctura.dtos;

import com.biblioteca.fuctura.enuns.Tamanho;
import com.biblioteca.fuctura.models.Categoria;
import com.biblioteca.fuctura.models.Livro;

public class LivroDto {

    private Integer id;
    private String titulo;
    private String autor;
    private String texto;
    private Categoria categoria;
    private Tamanho tamanho;

    public LivroDto() {
    }

    public LivroDto(Integer id, String titulo, String autor, String texto, Categoria categoria, Tamanho tamanho) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.texto = texto;
        this.categoria = categoria;
        this.tamanho = tamanho;
    }

    public LivroDto(Livro livro){
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
        this.autor = livro.getAutor();
        this.texto = livro.getTexto();
        this.categoria = livro.getCategoria();
        this.tamanho = livro.getTamanho();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Tamanho getTamanho() {
        return tamanho;
    }

    public void setTamanho(Tamanho tamanho) {
        this.tamanho = tamanho;
    }
}
