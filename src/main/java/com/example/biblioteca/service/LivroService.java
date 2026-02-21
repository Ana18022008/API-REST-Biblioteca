package com.example.biblioteca.service;

import com.example.biblioteca.dao.LivroDAO;
import com.example.biblioteca.dto.LivroRequisicaoDTO;
import com.example.biblioteca.dto.LivroRespostaDTO;
import com.example.biblioteca.mapper.LivroMapper;
import com.example.biblioteca.model.Livro;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class LivroService {

    private final LivroDAO livroDAO;
    private final LivroMapper livroMapper;

    public LivroService(LivroDAO livroDAO, LivroMapper livroMapper) {
        this.livroDAO = livroDAO;
        this.livroMapper = livroMapper;
    }


    public LivroRespostaDTO salvar(LivroRequisicaoDTO requisicaoDTO) throws SQLException{

        // A requisição de livro, do cliente,  é transformado em dado bruto
        Livro livro = livroMapper.paraEntidade(requisicaoDTO);

        // O dado bruto é enviado para o banco de dados
        Livro livroBancoDados = livroDAO.salvar(livro);

        // A partir do banco de dados é gerado uma resposta, que será enviado para o cliente
        return livroMapper.paraRespostaDTO(livroBancoDados);
    }

    public List<LivroRespostaDTO> listarTodos () throws SQLException{

        // Puxa uma lista de livros do livroDAO
        List<Livro> livros = livroDAO.listarTodos();

        //Cria uma lista do LivroResposta - pois o método retorna uma lista assim
        List<LivroRespostaDTO> livroResposta = new ArrayList<>();

        //faz um forEach dos livros normais
        livros.forEach(livro -> {

            //Transforma os livros normais em livros resposta para poder retornar
            livroResposta.add(livroMapper.paraRespostaDTO(livro));
            // A transformação é feita pelo Mapper pegando o normal como parâmetro

        });


        return livroResposta;

    }

    public LivroRespostaDTO buscarPorId(int id) throws SQLException{

      LivroRespostaDTO livroRespostaDTO = livroMapper.paraRespostaDTO(livroDAO.buscarPorId(id));

      return livroRespostaDTO;

    }

    public LivroRespostaDTO atualizar(LivroRequisicaoDTO livroRequisicaoDTO, int id) throws SQLException{

        Livro livro = livroMapper.paraEntidade(livroRequisicaoDTO);

        LivroRespostaDTO livroRespostaDTO = livroMapper.paraRespostaDTO(livroDAO.atualizar(livro, id));

        return livroRespostaDTO;
    }

    public void deletar(int id) throws SQLException{
        livroDAO.deletar(id);
    }


}
