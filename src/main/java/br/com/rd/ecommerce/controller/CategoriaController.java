package br.com.rd.ecommerce.controller;

import br.com.rd.ecommerce.Model.Categoria;
import br.com.rd.ecommerce.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
public class CategoriaController {

    @Autowired
    private CategoriaRepository repository;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create-categoria")
    public Categoria save(@RequestBody Categoria categoria) {

        return repository.save(categoria);
    }

    @GetMapping("/categoria/{idCategoria}")
    public Categoria findById(@PathVariable("idCategoria") Long id) {
        return (Categoria) repository.findById(id).get();
    }

    @GetMapping("/categoria")
    public Categoria findCategoriaById(@PathParam("id") Long id) {
        return repository.findById(id).get();
    }

    @DeleteMapping("/categoria/{id}")
    public void deleteById(@PathVariable("id") Long id){
        repository.deleteById(id);
    }

    @PutMapping("/categoria/{id}")
    public Categoria alterar(@RequestBody Categoria categoria) {
        Categoria categoriaEntity = repository.getOne(categoria.getId()); //faz busca no banco
                categoriaEntity.setNome(categoria.getNome());
               return repository.save(categoriaEntity);
    }
}
