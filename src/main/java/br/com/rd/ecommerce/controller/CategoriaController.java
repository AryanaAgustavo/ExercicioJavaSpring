package br.com.rd.ecommerce.controller;

import br.com.rd.ecommerce.Model.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoriaController {
    @Autowired
    private CategoriaController repository;

    @PostMapping("/category")
    public Categoria save(@RequestBody Categoria categoria) {
        return repository.save(categoria);
    }
}
