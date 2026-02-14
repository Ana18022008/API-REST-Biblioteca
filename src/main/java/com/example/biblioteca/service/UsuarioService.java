package com.example.biblioteca.service;

import com.example.biblioteca.dao.UsuarioDAO;
import com.example.biblioteca.model.Livro;
import com.example.biblioteca.model.Usuario;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioDAO usuarioDAO;

    public UsuarioService(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    public Usuario salvar(Usuario usuario) throws SQLException {
           return usuarioDAO.salvar(usuario);

    }

    public List<Usuario> listarTodos () throws SQLException{
        return usuarioDAO.listarTodos();
    }

    public Usuario buscarPorId(int id) throws SQLException{

        return usuarioDAO.buscarPorId(id);
    }

    public Usuario atualizar(Usuario usuario, int id) throws SQLException{
        return usuarioDAO.atualizar(usuario, id);
    }

    public void deletar(int id) throws SQLException{
        usuarioDAO.deletar(id);
    }




}
