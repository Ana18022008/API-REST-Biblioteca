package com.example.biblioteca.dto;

import java.time.LocalDate;

public record EmprestimoRespostaDTO(

        long id,
        long livro_id,
        long usuario_id,
        LocalDate data_emprestimo,

        LocalDate data_devolucao
) {
}
