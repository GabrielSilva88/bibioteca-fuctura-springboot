package br.com.fuctura.biblioteca.models;

import br.com.fuctura.biblioteca.enums.Tamanho;

public class Livro {

    private Integer id;
    private String titulo;
    private String autor;
    private String texto;
    private Categoria categoria;

    private Tamanho tamanho;

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

    public Livro(Integer id, String titulo, String autor, String texto) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.texto = texto;
    }

    public Livro(){
        super();
    }

}
