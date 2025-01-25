package br.com.fuctura.biblioteca.repositores;

import br.com.fuctura.biblioteca.models.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface livroRepository extends JpaRepository<Livro, Integer> {

}
