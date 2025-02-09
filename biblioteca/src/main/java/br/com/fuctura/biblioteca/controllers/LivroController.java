package br.com.fuctura.biblioteca.controllers;

import br.com.fuctura.biblioteca.dtos.LivroDto;
import br.com.fuctura.biblioteca.models.Livro;
import br.com.fuctura.biblioteca.repositores.LivroRepository;
import br.com.fuctura.biblioteca.services.LivroService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livro")
public class LivroController {
       /*
  @GetMapping("/{id}") = findById
  @GetMapping = findAll
  @PutMapping("/{id}") = atualizar - update
  @PostMapping = salvar - save
  @DeleteMapping("/{id}") = apagar - delete
  */
/*

    @Autowired
    private LivroService livroService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/id")
    public ResponseEntity<LivroDto> findById(@PathVariable Integer id) {
        Livro livro = livroService.findById(id);
        return ResponseEntity.ok().body(modelMapper.map(livro, LivroDto.class));
    }

    @GetMapping("/id")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        livroService.delete(id);
        return ResponseEntity.noContent().build();
    }*/
}
