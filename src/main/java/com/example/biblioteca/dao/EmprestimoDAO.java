package com.example.biblioteca.dao;

import com.example.biblioteca.model.Emprestimo;
import com.example.biblioteca.model.Livro;
import com.example.biblioteca.util.Conexao;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Repository
public class EmprestimoDAO {

    public Emprestimo salvar(Emprestimo emprestimo) throws SQLException {
        String query = """
                INSERT INTO emprestimo
                (livro_id, usuario_id, data_emprestimo, data_devolucao)
                VALUES
                (?,?,?,?)
                """;

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){

            stmt.setLong(1, emprestimo.getLivro_id());
            stmt.setLong(2, emprestimo.getUsuario_id());
            stmt.setDate(3, Date.valueOf(emprestimo.getData_emprestimo()));
            stmt.setDate(4, Date.valueOf(emprestimo.getData_devolucao()));
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();

            if(rs.next()){
                emprestimo.setId(rs.getLong(1));
            }
            return emprestimo;
        }

    }

    public List<Emprestimo> listarTodos () throws SQLException{
        List<Emprestimo> emprestimos = new ArrayList<>();

        String query = """
                SELECT id, livro_id, usuario_id, data_emprestimo, data_devolucao
                FROM emprestimo
                """;

        try(Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(query)){

            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                int id = rs.getInt("id");
                long livro_id = rs.getLong("livro_id");
                long usuario_id = rs.getLong("usuario_id");
                LocalDate data_emprestimo = rs.getDate("data_emprestimo").toLocalDate();
                LocalDate data_devolucao = rs.getDate("data_devolucao").toLocalDate();

                emprestimos.add(new Emprestimo(id,livro_id, usuario_id, data_emprestimo, data_devolucao));
            }
            return emprestimos;

        }
    }

    public Emprestimo buscarPorId(int id) throws SQLException{

        String query = """
                SELECT id, livro_id, usuario_id, data_emprestimo, data_devolucao
                FROM emprestimo
                WHERE id = ?
                """;

        try(Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                int livro_id = rs.getInt("livro_id");
                int usuario_id = rs.getInt("usuario_id");
                LocalDate data_emprestimo = rs.getDate("data_emprestimo").toLocalDate();
                LocalDate data_devolucao = rs.getDate("data_devolucao").toLocalDate();

                return new Emprestimo(id, livro_id, usuario_id, data_emprestimo, data_devolucao);
            }

        }

        return null;
    }

    public Emprestimo atualizar(Emprestimo emprestimo, int id) throws SQLException{

        String query = """
                UPDATE emprestimo
                SET livro_id = ?,
                usuario_id = ?,
                data_emprestimo = ?,
                data_devolucao = ?
                where id = ?
                """;

        try(Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setLong(1, emprestimo.getLivro_id());
            stmt.setLong(2, emprestimo.getUsuario_id());
            stmt.setDate(3, Date.valueOf(emprestimo.getData_emprestimo()));
            stmt.setDate(4, Date.valueOf(emprestimo.getData_devolucao()));
            stmt.setInt(5, id);
            stmt.executeUpdate();

        }
        emprestimo.setId(id);

        return emprestimo;
    }

    public void deletar(int id) throws SQLException{
        String query = """
                DELETE FROM emprestimo
                WHERE id = ?
                """;

        try(Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setInt(1,id);
            stmt.executeUpdate();
        }

    }



}
