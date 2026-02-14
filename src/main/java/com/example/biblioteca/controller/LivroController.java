package com.example.biblioteca.controller;

import com.example.biblioteca.model.Livro;
import com.example.biblioteca.service.LivroService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/livro")
public class LivroController {

   private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @PostMapping
    public Livro salvarLivro(@RequestBody Livro livro){

        try{
            return livroService.salvar(livro);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping
    public List<Livro> listar(){

        try {
            return livroService.listarTodos();
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public Livro buscarPorId(@PathVariable int id){
        try{
            return livroService.buscarPorId(id);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public Livro atualizar(@RequestBody Livro livro, @PathVariable int id){
        try{
            return livroService.atualizar(livro, id);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable int id){
        try{
           livroService.deletar(id);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }




}
