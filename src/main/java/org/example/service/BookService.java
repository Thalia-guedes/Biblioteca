package org.example.service;

import java.sql.*;

import static org.example.conection.Conection.fazerConexao;

public class BookService {
    private Statement statement;

    public BookService(){
        try {
            statement = fazerConexao().createStatement();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void inserirDados(String nome, String autor, String dataLancamento){
        String sql = "INSERT INTO book (nome, autor, dataLancamento) VALUES (?, ?, ?)";
        try {
            PreparedStatement preparedStatement = fazerConexao().prepareStatement(sql);
            preparedStatement.setString(1, nome);
            preparedStatement.setString(2, autor);
            preparedStatement.setDate(3, Date.valueOf(dataLancamento));

            preparedStatement.executeUpdate();
            System.out.println("Livro adicionado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deletarLivro(String titulo) {
        String sql = "DELETE FROM livros WHERE titulo = ?";
        try {
            PreparedStatement preparedStatement = fazerConexao().prepareStatement(sql);
            preparedStatement.setString(1, titulo);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Livro removido com sucesso: " + titulo);
            } else {
                System.out.println("Nenhum livro encontrado com o título: " + titulo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void alterarLivro(String titulo, String novoAutor) {
        String sql = "UPDATE livros SET autor = ? WHERE titulo = ?";
        try {
            PreparedStatement preparedStatement = fazerConexao().prepareStatement(sql);
            preparedStatement.setString(1, novoAutor);
            preparedStatement.setString(2, titulo);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Livro alterado com sucesso: " + titulo);
            } else {
                System.out.println("Nenhum livro encontrado com o título: " + titulo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void exibirLivroPorTitulo(String titulo) {
        String sql = "SELECT * FROM livros WHERE titulo = ?";
        try {
            PreparedStatement preparedStatement = fazerConexao().prepareStatement(sql);
            preparedStatement.setString(1, titulo);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String autor = resultSet.getString("autor");
                String genero = resultSet.getString("genero");
                int anoPublicacao = resultSet.getInt("ano_publicacao");
                System.out.println("Título: " + titulo + ", Autor: " + autor +
                        ", Gênero: " + genero + ", Ano de Publicação: " + anoPublicacao);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void exibirTodosOsLivros() {
        String sql = "SELECT * FROM livros";
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String titulo = resultSet.getString("titulo");
                String autor = resultSet.getString("autor");
                String genero = resultSet.getString("genero");
                int anoPublicacao = resultSet.getInt("ano_publicacao");
                System.out.println("Título: " + titulo + ", Autor: " + autor +
                        ", Gênero: " + genero + ", Ano de Publicação: " + anoPublicacao);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
