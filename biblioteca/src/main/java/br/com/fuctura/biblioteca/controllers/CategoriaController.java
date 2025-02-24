package br.com.fuctura.biblioteca.controllers;

import br.com.fuctura.biblioteca.dtos.CategoriaDto;
import br.com.fuctura.biblioteca.models.Categoria;
import br.com.fuctura.biblioteca.repositores.CategoriaRepository;
import br.com.fuctura.biblioteca.services.CategoriaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categoria")
@CrossOrigin("*")
public class CategoriaController {

    /*
    @GetMapping("/{id}") = findById
    @GetMapping = findAll
    @PutMapping("/{id}") = atualizar - update
    @PostMapping = salvar - save
    @DeleteMapping("/{id}") = apagar - delete
    */

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDto> findById(@PathVariable Integer id){
        Categoria categoria = categoriaService.findById(id);
        return ResponseEntity.ok().body(modelMapper.map(categoria, CategoriaDto.class));
    }
    //adicionado para biscar por nome do genero.
   @GetMapping("/name/{genero}")
    public ResponseEntity<CategoriaDto> findByName(@PathVariable String genero){
        Categoria categoria = categoriaService.findByName(genero);
        return ResponseEntity.ok(modelMapper.map(categoria, CategoriaDto.class));
    }
/* versão antiga
    @GetMapping
    public ResponseEntity<List<CategoriaDto>> findAll(){
        List<Categoria> categorias = categoriaService.findAll();
        return ResponseEntity.ok().body(categorias.stream().map(obj -> modelMapper.map(obj, CategoriaDto.class)).collect(Collectors.toList()));
    }
*/ //nova versao encontrar todos
    @GetMapping
    public ResponseEntity<List<CategoriaDto>> findAll(){
        List<Categoria> list = categoriaService.findAll();
        List<CategoriaDto> listDto = new ArrayList<>();
        for(Categoria cat : list){
            listDto.add(modelMapper.map(cat, CategoriaDto.class));
        }
        return ResponseEntity.ok().body(listDto);
    }

    // adicionado @valid para acionar as validações.
    @PostMapping
    public ResponseEntity<CategoriaDto> save(@Valid @RequestBody CategoriaDto categoriaDto){
        Categoria categoria = modelMapper.map(categoriaDto, Categoria.class);
        Categoria cat = categoriaService.save(categoria);
        return ResponseEntity.ok().body(modelMapper.map(cat, CategoriaDto.class));
    }
    // adicionado @valid para acionar as validações.
    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDto> update(@Valid @PathVariable Integer id, @RequestBody CategoriaDto categoriaDto){
        categoriaDto.setId(id);
        Categoria categoria = modelMapper.map(categoriaDto, Categoria.class);
        Categoria cat = categoriaService.update(categoria);
        return ResponseEntity.ok().body(modelMapper.map(cat, CategoriaDto.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        categoriaService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
