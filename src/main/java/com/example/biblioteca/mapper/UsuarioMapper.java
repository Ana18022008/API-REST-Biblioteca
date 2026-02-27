package com.example.biblioteca.mapper;

import com.example.biblioteca.dto.UsuarioRequisicaoDTO;
import com.example.biblioteca.dto.UsuarioRespostaDTO;
import com.example.biblioteca.model.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public Usuario paraEntidade(UsuarioRequisicaoDTO usuarioRequisicaoDTO){
        return new Usuario(
                usuarioRequisicaoDTO.nome(),
                usuarioRequisicaoDTO.email()
        );
    }

    public UsuarioRespostaDTO paraResposta(Usuario usuario){
        return new UsuarioRespostaDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail()
        );
    }

}
