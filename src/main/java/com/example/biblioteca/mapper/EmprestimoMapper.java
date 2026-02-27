package com.example.biblioteca.mapper;

import com.example.biblioteca.dto.EmprestimoRequisicaoDTO;
import com.example.biblioteca.dto.EmprestimoRespostaDTO;
import com.example.biblioteca.model.Emprestimo;
import org.springframework.stereotype.Component;

@Component
public class EmprestimoMapper {


    public Emprestimo paraEntidade(EmprestimoRequisicaoDTO requisicaoDTO){
        return new Emprestimo(
                requisicaoDTO.livro_id(),
                requisicaoDTO.usuario_id(),
                requisicaoDTO.data_emprestimo(),
                requisicaoDTO.data_devolucao()
                );
    }

    public EmprestimoRespostaDTO paraResposta(Emprestimo emprestimo){
        return new EmprestimoRespostaDTO(
                emprestimo.getId(),
                emprestimo.getLivro_id(),
                emprestimo.getUsuario_id(),
                emprestimo.getData_emprestimo(),
                emprestimo.getData_devolucao()
        );
    }


}
