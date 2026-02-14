package com.example.biblioteca.service;

import com.example.biblioteca.dao.EmprestimoDAO;
import com.example.biblioteca.model.Emprestimo;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class EmprestimoService {

    private final EmprestimoDAO emprestimoDAO;

    public EmprestimoService(EmprestimoDAO emprestimoDAO) {
        this.emprestimoDAO = emprestimoDAO;
    }

    public Emprestimo salvar(Emprestimo emprestimo) throws SQLException {
        return emprestimoDAO.salvar(emprestimo);
    }

    public List<Emprestimo> listarTodos () throws SQLException{
        return emprestimoDAO.listarTodos();
    }

    public Emprestimo buscarPorId(int id) throws SQLException{
        return emprestimoDAO.buscarPorId(id);

    }

    public Emprestimo atualizar(Emprestimo emprestimo, int id) throws SQLException{
        return emprestimoDAO.atualizar(emprestimo, id);

    }

    public void deletar(int id) throws SQLException{
        emprestimoDAO.deletar(id);
    }



}
