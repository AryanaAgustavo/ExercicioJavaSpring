package br.com.rd.ecommerce.Model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository <Produto, Long> {

    List<Produto> findByNome (String nome);
    List<Produto> findByQuantidadeEstoque (Integer quantidade);
    List<Produto> findByPreco (Double preco);
    List<Produto> findByCategoria (Double preco);

}
