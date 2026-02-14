package com.example.biblioteca.controller;

import com.example.biblioteca.model.Usuario;
import com.example.biblioteca.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/usuario")

public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    private Usuario salvar(@RequestBody Usuario usuario){

        try{
            return usuarioService.salvar(usuario);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }

    }

    @GetMapping
    private List<Usuario>listar(){

        try{
            return usuarioService.listarTodos();
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }

    }

    @GetMapping("/{id}")
    private Usuario pesquisarPorId(@PathVariable int id){

        try{
            return usuarioService.buscarPorId(id);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }

    }

    @PutMapping("/{id}")
    private Usuario atualizar(@RequestBody Usuario usuario,@PathVariable int id){

        try{
            return usuarioService.atualizar(usuario, id);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }

    }

    @DeleteMapping("/{id}")
    private void deletar(@PathVariable int id){

        try{
            usuarioService.deletar(id);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

}
