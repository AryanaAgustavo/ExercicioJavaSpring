package br.com.rd.ecommerce.controller;

import br.com.rd.ecommerce.Model.Produto;
import br.com.rd.ecommerce.Model.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import br.com.rd.ecommerce.Model.User;
import br.com.rd.ecommerce.Model.UserRepository;

import java.util.List;

@RestController
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @PostMapping ("/create-product")
    public Produto save(@RequestBody Produto produto) {
        return repository.save(produto);
    }
}


