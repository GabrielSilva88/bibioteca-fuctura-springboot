package br.com.fuctura.biblioteca.repositores;

import br.com.fuctura.biblioteca.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{

    //public boolean existsByGenero(String genero);

    public Optional<Categoria> findByGenero(String genero);
}
