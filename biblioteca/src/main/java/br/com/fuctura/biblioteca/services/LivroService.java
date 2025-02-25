package br.com.fuctura.biblioteca.services;

import br.com.fuctura.biblioteca.dtos.LivroDto;
import br.com.fuctura.biblioteca.exeptions.ObjectNotFoundExepiton;
import br.com.fuctura.biblioteca.models.Categoria;
import br.com.fuctura.biblioteca.models.Livro;
import br.com.fuctura.biblioteca.repositores.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private CategoriaService categoriaService;

    public Livro findById(Integer id) {
        Optional<Livro> livro = livroRepository.findById(id);
        if (livro.isPresent()) {
            return livro.get();
        }
        throw new ObjectNotFoundExepiton("Livro nao encontrado ou não existente");
        //return livro.orElseThrow(() -> new ObjectNotFoundException("Livro não Encontrador"));
    }

    public List<Livro> findAll(Integer id_cat) {
        categoriaService.findById(id_cat);
        return livroRepository.findAllLivrosByCategoriaId(id_cat);
    }

    public Livro save(Integer id, LivroDto livroDto) {
        livroDto.setId(null);
        Categoria cat = categoriaService.findById(id);
        livroDto.setCategoria(cat);
       return livroRepository.save(new Livro(livroDto));
    }

    public void delete(Integer id) {
        findById(id);
        livroRepository.deleteById(id);
    }

    public Livro update(Integer idCat, LivroDto livroDto){
        findById(livroDto.getId());
        Categoria oldCategoria = categoriaService.findById(idCat);
        livroDto.setCategoria(oldCategoria);

        return livroRepository.save(new Livro(livroDto));
    }

    public List<Livro> findAllLivrosByCategoriaName(String genero){
        categoriaService.findByGenero(genero);
        return livroRepository.findByCategoriaGeneroContainingIgnoreCase(genero);
    }
}
