package com.example.biblioteca.service;

import com.example.biblioteca.dao.LivroDAO;
import com.example.biblioteca.model.Livro;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class LivroService {

    private final LivroDAO livroDAO;

    public LivroService(LivroDAO livroDAO) {
        this.livroDAO = livroDAO;
    }


    public Livro salvar(Livro livro) throws SQLException{
        return livroDAO.salvar(livro);
    }

    public List<Livro> listarTodos () throws SQLException{
        return livroDAO.listarTodos();

    }

    public Livro buscarPorId(int id) throws SQLException{
        return livroDAO.buscarPorId(id);

    }

    public Livro atualizar(Livro livro, int id) throws SQLException{
        return livroDAO.atualizar(livro, id);
    }

    public void deletar(int id) throws SQLException{
        livroDAO.deletar(id);
    }


}
