package br.com.rd.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import br.com.rd.ecommerce.Model.User;
import br.com.rd.ecommerce.repository.UserRepository;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping ("/create-user")
    public User save(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/find-user/list")
    public List<User> find() {return userRepository.findAll(); }
}
