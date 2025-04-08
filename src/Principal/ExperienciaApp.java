package Principal;

import Modelos.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExperienciaApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final List<Usuario> usuarios = new ArrayList<>();

        int opcao = -1;
        while (opcao != 8) {
            ExibirMenu();

            opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    System.out.print("Digite seu nome: ");
                    String nome = sc.nextLine();
                    sc.nextLine();
                    System.out.print("Digite seu e-mail: ");
                    String email = sc.nextLine();

                    usuarios.add(new Usuario(nome, email));
                    System.out.println("\nCadastro realizado com sucesso! " +
                            "Agora você pode fazer login para acessar a plataforma.");
                break;
                case 2:
                    System.out.print("Digite seu nome: ");
                    String loginNome = sc.nextLine();
                    sc.nextLine();
                    System.out.print("Digite seu e-mail: ");
                    String loginEmail = sc.nextLine();

                    for (Usuario u : usuarios) {
                        if (u.getNome().equals(loginNome) && u.getEmail().equals(loginEmail)) {
                            System.out.println("\nLogin bem-sucedido! Bem-vindo, " + loginNome);
                        } else {
                            System.out.println("\nErro: Usuário não encontrado. Verifique suas credenciais e tente novamente.");
                        }
                    }
                break;
            }

            System.out.print("Pressione Enter para continuar...");
            sc.nextLine();
        }
    }

    private static void ExibirMenu() {
        System.out.println("\nBem-vindo à Plataform de Experiencias Compartilhadas\n");
        System.out.println("""
            Escolha uma opção:
            1. Cadastro de usuário
            2. Login
            3. Criar uma nova experiencia
            4. Listar experiencias
            5. Inscrever-se em uma experiencia
            6. Listar participantes de uma experiencia
            7. Cancelar inscrição
            8. Sair
        """);
        System.out.print("Digite a opção desejada: ");
    }
}
