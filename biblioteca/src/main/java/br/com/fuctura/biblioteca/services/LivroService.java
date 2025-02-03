package br.com.fuctura.biblioteca.services;

import br.com.fuctura.biblioteca.models.Livro;
import br.com.fuctura.biblioteca.repositores.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public List<Livro> findAll() {
        return livroRepository.findAll();
    }

    public Livro findById(int id) {
        Optional<Livro> livros = livroRepository.findById(id);
        return livros.orElse(null);
    }

    public Livro save(Livro livro) {
        Livro liv = livroRepository.save(livro);
        return liv;
    }

    public Livro update(@RequestBody Livro livro) {
       Livro liv = livroRepository.save(livro);
       return liv;
    }

    public void delete(int id) {
        livroRepository.deleteById(id);
    }


}
