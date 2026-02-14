package com.example.biblioteca.model;

import java.time.LocalDate;

public class Emprestimo {

    private long id;
    private long livro_id;
    private long usuario_id;
    private LocalDate data_emprestimo;
    private LocalDate data_devolucao;

    public Emprestimo() {
    }

    public Emprestimo(long id, long livro_id, long usuario_id, LocalDate data_emprestimo, LocalDate data_devolucao) {
        this.id = id;
        this.livro_id = livro_id;
        this.usuario_id = usuario_id;
        this.data_emprestimo = data_emprestimo;
        this.data_devolucao = data_devolucao;
    }

    public Emprestimo(long livro_id, long usuario_id, LocalDate data_emprestimo, LocalDate data_devolucao) {
        this.livro_id = livro_id;
        this.usuario_id = usuario_id;
        this.data_emprestimo = data_emprestimo;
        this.data_devolucao = data_devolucao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getLivro_id() {
        return livro_id;
    }

    public void setLivro_id(long livro_id) {
        this.livro_id = livro_id;
    }

    public long getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(long usuario_id) {
        this.usuario_id = usuario_id;
    }

    public LocalDate getData_emprestimo() {
        return data_emprestimo;
    }

    public void setData_emprestimo(LocalDate data_emprestimo) {
        this.data_emprestimo = data_emprestimo;
    }

    public LocalDate getData_devolucao() {
        return data_devolucao;
    }

    public void setData_devolucao(LocalDate data_devolucao) {
        this.data_devolucao = data_devolucao;
    }
}
