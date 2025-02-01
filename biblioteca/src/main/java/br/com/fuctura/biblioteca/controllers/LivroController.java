package br.com.fuctura.biblioteca.controllers;

import br.com.fuctura.biblioteca.models.Livro;
import br.com.fuctura.biblioteca.repositores.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {


    private final LivroRepository livroRepository;

    public LivroController(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @GetMapping("")
    public List<Livro> livros(){
        return livroRepository.findAll();
    }


}
