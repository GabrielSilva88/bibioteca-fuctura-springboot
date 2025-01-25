package br.com.fuctura.biblioteca.repositores;

import br.com.fuctura.biblioteca.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface categoriaRepository extends JpaRepository<Categoria, Integer>{

}
