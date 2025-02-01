package br.com.fuctura.biblioteca.dtos;


import br.com.fuctura.biblioteca.models.Livro;

import java.util.ArrayList;
import java.util.List;

public class CategoriaDto {

    private Integer id;
    private String genero;
    private String descricao;

    private List<Livro> livros = new ArrayList<>();

    public CategoriaDto() {
    }

    public CategoriaDto(Integer id, String genero, String descricao, List<Livro> livros) {
        this.id = id;
        this.genero = genero;
        this.descricao = descricao;
        this.livros = livros;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }
}
