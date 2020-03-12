package br.com.rd.ecommerce.controller;

import br.com.rd.ecommerce.Model.*;
import br.com.rd.ecommerce.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ProdutoController {

    @Autowired //injetando a classe repository para cá
    private ProdutoRepository repository;

    @PostMapping ("/create-produto")
    public Produto save(@RequestBody Produto produto) {
        return repository.save(produto);
    }

    @GetMapping("/produto/{id}")
    public Produto buscarPorId(@PathVariable("id") Long id) {return repository.findById(id).get();}

//    @GetMapping("/produto/buscar-produto/{nomeProduto}")
//    public List<Produto> buscarPorNome(@PathParam("nomeProduto") String descricao){
//        return repository.findByNome(descricao);
//    }

    @GetMapping("/produto")  //não fica obrigado a preencher os dois na URL usando o ResponseEntity
    public ResponseEntity<List<Produto>> buscarPorDescricao(@PathParam("id") Long id, @PathParam("descricao") String nome) {

        List<Produto> produto = new ArrayList<>();

        if(id != null && nome != null)
            produto = repository.findByIdAndNome(id, nome);
        else if (id != null)
            produto.add(repository.findById(id).get()); //add à lista pois esse método só retornaria um objeto produto
        else if(nome !=null)
            produto = repository.findByNome(nome); //esse já retorna uma lista, por isso não precisamos add nada

        if (produto != null && produto.size() > 0)
            return ResponseEntity.ok().body(produto);
        else
            return (ResponseEntity.badRequest().build());
    }

    @PutMapping("/produto")
    public Produto alterar(@RequestBody Produto produto){
        Produto produtoEntity = repository.getOne(produto.getId());

        produtoEntity.setNome(produto.getNome());
        produtoEntity.setPreco(produto.getPreco());
        produtoEntity.setQuantidadeEstoque(produto.getQuantidadeEstoque());

        return repository.save(produtoEntity);
    }

    @DeleteMapping("/produto/{id}")
    public void excluirProduto(@PathVariable ("id") Long id) {
        repository.deleteById(id);
    }

}