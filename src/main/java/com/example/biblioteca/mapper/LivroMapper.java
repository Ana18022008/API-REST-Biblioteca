package com.example.biblioteca.mapper;

import com.example.biblioteca.dto.LivroRequisicaoDTO;
import com.example.biblioteca.dto.LivroRespostaDTO;
import com.example.biblioteca.model.Livro;
import org.springframework.stereotype.Component;

@Component
public class LivroMapper {

    public Livro paraEntidade(LivroRequisicaoDTO livroRequisicaoDTO) {
        return new Livro(
                livroRequisicaoDTO.titulo(),
                livroRequisicaoDTO.autor(),
                livroRequisicaoDTO.ano_publicacao()
        );
    }
    public LivroRespostaDTO paraRespostaDTO(Livro livro){
             return new LivroRespostaDTO(
                     livro.getId(),
                     livro.getTitulo(),
                     livro.getAutor(),
                     livro.getAno_publicacao()
             );

    }


}
