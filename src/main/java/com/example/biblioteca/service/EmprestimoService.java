package com.example.biblioteca.service;

import com.example.biblioteca.dao.EmprestimoDAO;
import com.example.biblioteca.dto.EmprestimoRequisicaoDTO;
import com.example.biblioteca.dto.EmprestimoRespostaDTO;
import com.example.biblioteca.mapper.EmprestimoMapper;
import com.example.biblioteca.model.Emprestimo;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmprestimoService {

    private final EmprestimoDAO emprestimoDAO;
    private final EmprestimoMapper emprestimoMapper;

    public EmprestimoService(EmprestimoDAO emprestimoDAO, EmprestimoMapper emprestimoMapper) {
        this.emprestimoDAO = emprestimoDAO;
        this.emprestimoMapper = emprestimoMapper;
    }

    public EmprestimoRespostaDTO salvar(EmprestimoRequisicaoDTO requisicaoDTO) throws SQLException {

        Emprestimo emprestimo = emprestimoMapper.paraEntidade(requisicaoDTO);

        EmprestimoRespostaDTO respostaDTO = emprestimoMapper.paraResposta(emprestimoDAO.salvar(emprestimo));

        return respostaDTO;
    }

    public List<EmprestimoRespostaDTO> listarTodos () throws SQLException{

        List<Emprestimo> emprestimos = emprestimoDAO.listarTodos();
        List<EmprestimoRespostaDTO> emprestimoRespostas = new ArrayList<>();

        emprestimos.forEach(emprestimo -> {
            emprestimoRespostas.add(emprestimoMapper.paraResposta(emprestimo));
        });

        return emprestimoRespostas;

    }

    public EmprestimoRespostaDTO buscarPorId(int id) throws SQLException{

        EmprestimoRespostaDTO respostaDTO = emprestimoMapper.paraResposta(emprestimoDAO.buscarPorId(id));
        return  respostaDTO;


    }

    public EmprestimoRespostaDTO atualizar(EmprestimoRequisicaoDTO requisicaoDTO, int id) throws SQLException{

        Emprestimo emprestimo = emprestimoMapper.paraEntidade(requisicaoDTO);
        EmprestimoRespostaDTO respostaDTO = emprestimoMapper.paraResposta(emprestimoDAO.atualizar(emprestimo, id));
        return respostaDTO;


    }

    public void deletar(int id) throws SQLException{
        emprestimoDAO.deletar(id);
    }



}
