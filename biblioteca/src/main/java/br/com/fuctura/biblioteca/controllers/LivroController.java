package br.com.fuctura.biblioteca.controllers;

import br.com.fuctura.biblioteca.dtos.LivroDto;
import br.com.fuctura.biblioteca.models.Livro;
import br.com.fuctura.biblioteca.repositores.LivroRepository;
import br.com.fuctura.biblioteca.services.LivroService;
import io.swagger.v3.oas.annotations.Operation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/livro")
@CrossOrigin("*")
public class LivroController {
       /*
  @GetMapping("/{id}") = findById
  @GetMapping = findAll
  @PutMapping("/{id}") = atualizar - update
  @PostMapping = salvar - save
  @DeleteMapping("/{id}") = apagar - delete
  */


    /*
     *       criar dois metodos no controler
     *       findById e findAll
     *
     * */

    @Autowired
    private LivroService livroService;

    /* removido redundancia
    @Autowired
    private ModelMapper modelMapper;
    */

    @GetMapping(value = "/{id}")
    public ResponseEntity<LivroDto> findById(@PathVariable Integer id) {
        Livro livro = livroService.findById(id);
        return ResponseEntity.ok().body(new LivroDto(livro));
    }

    // localhost:8082/livro?categoria=1
    @Operation(summary = "Busca todos os livros pelo ID de uma categoria")
    @GetMapping
    public ResponseEntity<List<LivroDto>> findAll(@RequestParam(value = "categoria", defaultValue = "0") Integer id) {
        List<Livro> livros = livroService.findAll(id);
        return ResponseEntity.ok().body(livros.stream().map(obj -> new LivroDto(obj)).collect(Collectors.toList()));
    }

    // fazer tratamento para evitar duplicidade. redige.
    @PostMapping
    public ResponseEntity<LivroDto> save(@RequestParam(value = "categoria", defaultValue = "0") Integer id,
                                         @RequestBody LivroDto livroDto) {
        Livro livro = livroService.save(id, livroDto);
        return ResponseEntity.ok().body(new LivroDto(livro));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        livroService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<LivroDto> update(@PathVariable Integer id,
                                           @RequestParam(value = "categoria", defaultValue = "0")Integer id_Cat,
                                           @RequestBody LivroDto livroDto){
        livroDto.setId(id);
        Livro livro = livroService.update(id_Cat, livroDto);
        return ResponseEntity.ok().body(new LivroDto(livro));
    }

}
