package org.example.view;

import org.example.model.BookModel;
import org.example.service.BookService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuView {
    private Scanner scanner;
    private BookService bookService;
    private BookModel book;

    public MenuView(){
        scanner = new Scanner(System.in);
        bookService = new BookService();
        book = new BookModel();
    }
    public void iniciarMenu() {
        int opcao;
        do {

            imprimirMenu();
            opcao = selecionaOpcao();
            switch (opcao) {
                case 1:
                    bookService.exibirTodosOsLivros();
                    break;
                case 2:
                    System.out.print("Digite o título do livro: ");
                    String titulo = scanner.nextLine();
                    bookService.exibirLivroPorTitulo(titulo);
                    break;
                case 3:
                    System.out.println("Digite o nome do livro: ");
                    String nome = scanner.next();
                    System.out.println("Digite o nome do autor: ");
                    String autor = scanner.next();
                    System.out.println("Digite a data de lançamento: ");
                    String dataLancamento = scanner.next();
                    bookService.inserirDados(nome, autor, dataLancamento);
                    break;
                case 4:
                    System.out.println("Digite o titulo do livro: ");
                    String livro = scanner.next();
                    System.out.println("Digite o nome do novo autor: ");
                    String novoAutor = scanner.next();
                    bookService.alterarLivro(livro, novoAutor);
                    break;
                case 5:
                    System.out.println("Digite o titulo do livro que deseja deletar: ");
                    titulo = scanner.next();
                    bookService.deletarLivro(titulo);
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        } while (opcao != 0);
    }
    public void imprimirMenu(){
        System.out.println("Menu:");
        System.out.println("1. Exibir todos os livros");
        System.out.println("2. Exibir um livro específico");
        System.out.println("3. Inserir um novo livro");
        System.out.println("4. Alterar um livro");
        System.out.println("5. Deletar um livro");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }
    public int selecionaOpcao(){
        try{
            int opcao = scanner.nextInt();
            scanner.nextLine();
            return opcao;
        }catch (InputMismatchException e){
            System.out.println(e.getMessage());
            scanner.nextLine();
            return 1;
        }
    }
}
