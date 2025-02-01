package br.com.fuctura.biblioteca.controllers;

import br.com.fuctura.biblioteca.dtos.CategoriaDto;
import br.com.fuctura.biblioteca.models.Categoria;
import br.com.fuctura.biblioteca.repositores.CategoriaRepository;
import br.com.fuctura.biblioteca.services.CategoriaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categoria")
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

    @GetMapping
    public ResponseEntity<List<CategoriaDto>> findAll(){
        List<Categoria> categorias = categoriaService.findAll();
        return ResponseEntity.ok().body(categorias.stream().map(obj -> modelMapper.map(obj, CategoriaDto.class)).collect(Collectors.toList()));
    }

    @PostMapping
    public Categoria save(@RequestBody Categoria categoria){
        Categoria cat = categoriaService.save(categoria);
        return cat;
    }

    @PutMapping("/{id}")
    public Categoria update(@PathVariable Integer id, @RequestBody Categoria categoria){
        categoria.setId(id);
        Categoria cat = categoriaService.update(categoria);
        return cat;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        categoriaService.delete(id);
    }


}
