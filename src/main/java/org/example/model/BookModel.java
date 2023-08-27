package org.example.model;

public class BookModel {
    private String nome;
    private String autor;
    private String dataLancamento;
    private Long CodigoLivro;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(String dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public Long getCodigoLivro() {
        return CodigoLivro;
    }

    public void setCodigoLivro(Long codigoLivro) {
        CodigoLivro = codigoLivro;
    }
}
