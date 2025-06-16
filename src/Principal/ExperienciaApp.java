package Principal;

import Modelos.Experiencia;
import Modelos.Participante;
import Modelos.Usuario;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ExperienciaApp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        final List<Usuario> usuarios = new ArrayList<>();
        final List<Experiencia> experiencias = new ArrayList<>();

        int opcao = -1, indexExperiencia = 1, indexParticipante = 1;
        while (opcao != 8) {
            ExibirMenu();

            opcao = Integer.parseInt(br.readLine());
            switch (opcao) {
                case 1:
                    System.out.print("Digite seu nome: ");
                    String nome = br.readLine();
                    System.out.print("Digite seu e-mail: ");
                    String email = br.readLine();

                    usuarios.add(new Usuario(nome, email));
                    System.out.println("\nCadastro realizado com sucesso! " +
                            "Agora você pode fazer login para acessar a plataforma.");
                break;
                case 2:
                    System.out.print("Digite seu nome: ");
                    String loginNome = br.readLine();
                    System.out.print("Digite seu e-mail: ");
                    String loginEmail = br.readLine();

                    for (Usuario u : usuarios) {
                        if (u.getNome().equals(loginNome) && u.getEmail().equals(loginEmail)) {
                            System.out.println("\nLogin bem-sucedido! Bem-vindo, " + loginNome);
                        } else {
                            System.out.println("\nErro: Usuário não encontrado. Verifique suas credenciais e tente novamente.");
                        }
                    }
                break;
                case 3:
                    System.out.print("Digite o nome da experiencia: ");
                    String nomeExperiencia = br.readLine();
                    System.out.print("Digite a descrição da experiencia: ");
                    String descricaoExperiencia = br.readLine();
                    System.out.print("Digite a data (YYYY-MM-DD): ");
                    LocalDate dataExperiencia = LocalDate.parse(br.readLine());
                    System.out.print("Digite o horário (HH:MM): ");
                    LocalTime horarioExperiencia = LocalTime.parse(br.readLine());
                    System.out.print("Digite o local (presencial/online): ");
                    String localExperiencia = br.readLine();
                    System.out.print("Digite o número máximo de participantes: ");
                    int totalParticipantes = Integer.parseInt(br.readLine());

                    if (experiencias.add(new Experiencia(indexExperiencia, nomeExperiencia, descricaoExperiencia, dataExperiencia, horarioExperiencia,
                            localExperiencia, totalParticipantes))) indexExperiencia++;
                    System.out.println("\nExperiencia criada com sucesso!");
                break;
                case 4:
                    System.out.println("Experiências disponíveis: ");
                    for (Experiencia e : experiencias) {
                        System.out.println(e.getCodigo() + ". " + e.getNome() + " - Data: " + e.getData() + " " + e.getHorario()
                                + " - Local: " + e.getLocal() + " - Vagas: " + e.getTotalParticipantes());
                    }
                break;
                case 5:
                    System.out.print("Digite o número da experiência para se inscrever: ");
                    int codigoExperiencia = Integer.parseInt(br.readLine());
                    System.out.print("Digite o seu nome: ");
                    String nomeInscrito = br.readLine();
                    System.out.print("Digite o seu e-mail: ");
                    String emailInscrito = br.readLine();

                    Experiencia experiencia = experiencias.get(codigoExperiencia - 1);
                    if (experiencia.addParticipante(new Participante(indexParticipante, nomeInscrito, emailInscrito))) {
                        indexParticipante++;
                    }
                    System.out.println("Você foi inscrito com sucesso na experiência \"" + experiencia.getNome() + "\".");
                break;
                case 6:
                    System.out.print("Digite o número da experiência para ver os participantes: ");
                    codigoExperiencia = Integer.parseInt(br.readLine());
                    experiencia = experiencias.get(codigoExperiencia - 1);

                    System.out.println("Participantes da experiência \"" + experiencia.getNome() + "\": ");
                    experiencia.getParticipantes().forEach(p -> System.out.println(p.getCodigo() + ". " + p.getNome()
                            + " - " + p.getEmail()));
                break;
                case 7:
                    System.out.print("Digite o número da experiência para cancelar inscrição: ");
                    codigoExperiencia = Integer.parseInt(br.readLine());
                    experiencia = experiencias.get(codigoExperiencia - 1);
                    System.out.print("Digite seu nome: ");
                    nomeInscrito = br.readLine();
                    experiencia.getParticipantes().removeIf(p -> p.getNome().equals(nomeInscrito));
                    System.out.println("Sua inscrição na experiência \"" + experiencia.getNome() + "\" foi cancelada com sucesso.");
                break;
            }

            System.out.print("Pressione Enter para continuar...");
            br.readLine();
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
