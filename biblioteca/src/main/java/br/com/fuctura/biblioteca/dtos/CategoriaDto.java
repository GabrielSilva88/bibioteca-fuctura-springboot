package br.com.fuctura.biblioteca.dtos;


import br.com.fuctura.biblioteca.models.Livro;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDto {

    private Integer id;

    @Length(min = 3, max = 20, message = "letras Minimo 3 e Maximo 20")
    @NotBlank(message = "campo GENERO é requerido")
    private String genero;
    @Length(min = 30, max = 50, message = "letras Minimo 3 e Maximo 20")
    @NotBlank(message = "campo DESCRIÇÃO é requerido")
    private String descricao;

    public CategoriaDto() {
    }

    public CategoriaDto(Integer id, String genero, String descricao) {
        this.id = id;
        this.genero = genero;
        this.descricao = descricao;

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

}
