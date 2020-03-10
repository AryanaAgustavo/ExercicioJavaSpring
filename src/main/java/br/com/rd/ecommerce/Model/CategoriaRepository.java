package br.com.rd.ecommerce.Model;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository {

    List<Categoria> findByNome (String nome);
}
