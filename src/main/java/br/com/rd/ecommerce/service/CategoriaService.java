package br.com.rd.ecommerce.service;

import br.com.rd.ecommerce.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("CategoriaService")

public class CategoriaService {

    @Autowired
    CategoriaRepository repository;



}
