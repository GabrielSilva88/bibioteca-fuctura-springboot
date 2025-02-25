package br.com.fuctura.biblioteca.services;

import br.com.fuctura.biblioteca.exeptions.ObjectNotFoundExepiton;
import br.com.fuctura.biblioteca.models.Categoria;
import br.com.fuctura.biblioteca.repositores.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
        if (categoria.isPresent()) {
            return categoria.get();
        }
        throw new ObjectNotFoundExepiton("Categorai Não encontrada ou não existe");
    }
   public Categoria findByName(String nome) {
        Optional<Categoria> cat = categoriaRepository.findByGenero(nome);
        if( cat.isPresent() ) {
            return cat.get();
        }
        throw new ObjectNotFoundExepiton("Categoria Não encontrada");
   }
    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    public Categoria save(Categoria categoria) {
        findByGenero(categoria);
        Categoria cat = categoriaRepository.save(categoria);
        return cat;
    }

    public Categoria update(@RequestBody Categoria categoria) {
        findById(categoria.getId());
        findByGenero(categoria);
        Categoria cat = categoriaRepository.save(categoria);
        return cat;
    }

    public void delete(Integer id) {
        Categoria cat = findById(id);
        if (!cat.getLivros().isEmpty()) {

            throw new DataIntegrityViolationException("Categoria possui livros, não pode ser deletada");
        }
        categoriaRepository.deleteById(id);
    }

    public void findByGenero(Categoria categoria) {
        Optional<Categoria> cat = categoriaRepository.findByGenero(categoria.getGenero());
        if (cat.isPresent() && cat.get().getGenero().equals(categoria.getGenero())) {
            throw new IllegalArgumentException("Já existe uma categoria cadastrada com este genero");
        }
    }
}
