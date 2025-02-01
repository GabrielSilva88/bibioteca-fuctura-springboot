package br.com.fuctura.biblioteca.services;

import br.com.fuctura.biblioteca.models.Categoria;
import br.com.fuctura.biblioteca.repositores.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria findById(Integer id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        return categoria.orElse(null);
    }

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    public Categoria save(Categoria categoria) {
       Categoria cat = categoriaRepository.save(categoria);
       return cat;
    }

    public Categoria update(@RequestBody Categoria categoria) {
        Categoria cat = categoriaRepository.save(categoria);
        return cat;
    }

    public void delete(Integer id) {
        categoriaRepository.deleteById(id);
    }
}
