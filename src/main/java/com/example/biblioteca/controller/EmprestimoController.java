package com.example.biblioteca.controller;

import com.example.biblioteca.model.Emprestimo;
import com.example.biblioteca.service.EmprestimoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/emprestimo")

public class EmprestimoController {

    private final EmprestimoService emprestimoService;

    public EmprestimoController(EmprestimoService emprestimoService) {
        this.emprestimoService = emprestimoService;
    }

    @PostMapping
    public Emprestimo salvar(@RequestBody Emprestimo emprestimo){

        try{
            return emprestimoService.salvar(emprestimo);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }

    }

    @GetMapping
    public List<Emprestimo> listar(){

        try{
            return emprestimoService.listarTodos();
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }

    }

    @GetMapping("/{id}")
    public Emprestimo buscarPorId(@PathVariable int id){

        try{
            return emprestimoService.buscarPorId(id);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }

    }

    @PutMapping("/{id}")
    public Emprestimo atualizar(@RequestBody Emprestimo emprestimo, @PathVariable int id){

        try{
            return emprestimoService.atualizar(emprestimo, id);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }

    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable int id){

        try{
            emprestimoService.deletar(id);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }

    }
}
