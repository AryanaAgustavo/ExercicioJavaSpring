package br.com.rd.ecommerce.repository;

import br.com.rd.ecommerce.Model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository <Produto, Long> {

    List<Produto> findByNome (String nome);
    List<Produto> findByQuantidadeEstoque (Integer quantidade);
    List<Produto> findByPreco (Double preco);
    List<Produto> findByCategoria (Double categoria);

    List<Produto> findByIdAndNome (Long id, String nome);

}
