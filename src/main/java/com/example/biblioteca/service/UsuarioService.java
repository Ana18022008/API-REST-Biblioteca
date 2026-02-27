package com.example.biblioteca.service;

import com.example.biblioteca.dao.UsuarioDAO;
import com.example.biblioteca.dto.LivroRespostaDTO;
import com.example.biblioteca.dto.UsuarioRequisicaoDTO;
import com.example.biblioteca.dto.UsuarioRespostaDTO;
import com.example.biblioteca.mapper.UsuarioMapper;
import com.example.biblioteca.model.Livro;
import com.example.biblioteca.model.Usuario;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioDAO usuarioDAO;
    private final UsuarioMapper usuarioMapper;

    public UsuarioService(UsuarioDAO usuarioDAO, UsuarioMapper usuarioMapper) {
        this.usuarioDAO = usuarioDAO;
        this.usuarioMapper = usuarioMapper;
    }

    public UsuarioRespostaDTO salvar(UsuarioRequisicaoDTO requisicaoDTO) throws SQLException {
           Usuario usuario = usuarioMapper.paraEntidade(requisicaoDTO);

           Usuario usuarioBancoDeDados = usuarioDAO.salvar(usuario);

           return usuarioMapper.paraResposta(usuarioBancoDeDados);

    }

    public List<UsuarioRespostaDTO> listarTodos () throws SQLException{

        List<Usuario> usuarios = usuarioDAO.listarTodos();

        List<UsuarioRespostaDTO> usuarioRespostas = new ArrayList<>();

        usuarios.forEach(usuario -> {
            usuarioRespostas.add(usuarioMapper.paraResposta(usuario));
        });

        return usuarioRespostas;
    }

    public UsuarioRespostaDTO buscarPorId(int id) throws SQLException{

        UsuarioRespostaDTO usuarioRespostaDTO = usuarioMapper.paraResposta(usuarioDAO.buscarPorId(id));

        return usuarioRespostaDTO;
    }

    public UsuarioRespostaDTO atualizar(UsuarioRequisicaoDTO requisicaoDTO, int id) throws SQLException{

        Usuario usuario = usuarioMapper.paraEntidade(requisicaoDTO);

        UsuarioRespostaDTO usuarioRespostaDTO = usuarioMapper.paraResposta(usuarioDAO.atualizar(usuario, id));

        return usuarioRespostaDTO;
    }

    public void deletar(int id) throws SQLException{
        usuarioDAO.deletar(id);
    }




}
