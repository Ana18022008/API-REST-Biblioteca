package com.example.biblioteca.controller;

import com.example.biblioteca.dto.UsuarioRequisicaoDTO;
import com.example.biblioteca.dto.UsuarioRespostaDTO;
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
    private UsuarioRespostaDTO salvar(@RequestBody UsuarioRequisicaoDTO requisicaoDTO){

        try{
            return usuarioService.salvar(requisicaoDTO);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }

    }

    @GetMapping
    private List<UsuarioRespostaDTO>listar(){

        try{
            return usuarioService.listarTodos();
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }

    }

    @GetMapping("/{id}")
    private UsuarioRespostaDTO pesquisarPorId(@PathVariable int id){

        try{
            return usuarioService.buscarPorId(id);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }

    }

    @PutMapping("/{id}")
    private UsuarioRespostaDTO atualizar(@RequestBody UsuarioRequisicaoDTO requisicaoDTO,@PathVariable int id){

        try{
            return usuarioService.atualizar(requisicaoDTO, id);
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
