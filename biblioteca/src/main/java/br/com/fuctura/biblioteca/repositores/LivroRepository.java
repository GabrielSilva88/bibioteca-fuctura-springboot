package br.com.fuctura.biblioteca.repositores;

import br.com.fuctura.biblioteca.models.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer> {

    // metodo para buscar livro
    public Livro findByTitulo(String titulo);

    /* JPQL direciona a class JQL referencia os atributos */
    @Query(value = "SELECT obj FROM Livro obj WHERE obj.categoria.id =: id_cat")
    public List<Livro> findAllLivrosByCategoriaId(@Param("id_cat") Integer id_cat);

    List<Livro> findByCategoriaGeneroContainingIgnoreCase(String genero);

}
