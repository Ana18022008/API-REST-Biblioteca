package com.example.biblioteca.dao;

import com.example.biblioteca.model.Livro;
import com.example.biblioteca.util.Conexao;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository
public class LivroDAO {

    public Livro salvar(Livro livro) throws SQLException{
        String query = """
                INSERT INTO livro
                (titulo, autor, ano_publicacao)
                VALUES
                (?,?,?)
                """;

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){

            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutor());
            stmt.setInt(3, livro.getAno_publicacao());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();

            if(rs.next()){
                livro.setId(rs.getInt(1));
            }
            return livro;
        }

    }

    public List<Livro> listarTodos () throws SQLException{
        List<Livro> livros = new ArrayList<>();

        String query = """
                SELECT id, titulo, autor, ano_publicacao
                FROM livro;
                """;

        try(Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(query)){

            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                int id = rs.getInt("id");
                String titulo = rs.getString("titulo");
                String autor = rs.getString("autor");
                int ano_publicacao = rs.getInt("ano_publicacao");

                livros.add(new Livro(id, titulo, autor, ano_publicacao));
            }
            return livros;

        }

    }

    public Livro buscarPorId(int id) throws SQLException{
        String query = """
                SELECT id, titulo, autor, ano_publicacao
                FROM livro
                WHERE id = ?
                """;

        try(Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                String titulo = rs.getString("titulo");
                String autor = rs.getString("autor");
                int ano_publicacao = rs.getInt("ano_publicacao");

                return new Livro(id, titulo, autor, ano_publicacao);
            }

        }

        return null;
    }

    public Livro atualizar(Livro livro, int id) throws SQLException{
        String query = """
                UPDATE livro
                SET titulo = ?,
                autor = ?,
                ano_publicacao = ?
                where id = ?
                """;

        try(Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutor());
            stmt.setInt(3, livro.getAno_publicacao());
            stmt.setInt(4, id);

            livro.setId(id);
            stmt.executeUpdate();

            return livro;
        }


    }

    public void deletar(int id) throws SQLException{
        String query = """
                DELETE FROM livro
                where id = ?
                """;

        try(Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
