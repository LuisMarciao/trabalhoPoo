package br.com.meuprojeto;



import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        HotelPet hotel = new HotelPet();
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        while (true) {
            System.out.println("\n===== Hotel Pet Menu =====");
            System.out.println("1. Cadastrar pet");
            System.out.println("2. Agendar serviço");
            System.out.println("3. Gerar fatura");
            System.out.println("4  Relatório mensal");
            System.out.println("5. Listar pets hospedados por espécie");
            System.out.println("6. Listar pets hospedados por plano");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    System.out.print("Nome do pet: ");
                    String nomePet = scanner.nextLine();
                    System.out.print("Espécie: ");
                    String especie = scanner.nextLine();
                    System.out.print("Raça: ");
                    String raca = scanner.nextLine();
                    System.out.print("Idade: ");
                    int idade = Integer.parseInt(scanner.nextLine());
                    System.out.print("Peso: ");
                    double peso = Double.parseDouble(scanner.nextLine());
                    System.out.print("Nome do tutor: ");
                    String nomeTutor = scanner.nextLine();
                    System.out.print("Contato do tutor: ");
                    String contato = scanner.nextLine();
                    System.out.println("Plano (1-Standard, 2-Premium, 3-VIP): ");
                    int planoOp = Integer.parseInt(scanner.nextLine());

                    PlanoHospedagem plano;
                    if (planoOp == 1) plano = new PlanoStandard();
                    else if (planoOp == 2) plano = new PlanoPremium();
                    else plano = new PlanoVIP();

                    Pet novoPet = new Pet(nomePet, especie, raca, idade, peso,
                            new Tutor(nomeTutor, contato), plano, LocalDateTime.now());
                    hotel.cadastrarPet(novoPet);
                    System.out.println("Pet cadastrado com sucesso!");
                    break;

                case 2:
                    System.out.print("Nome do pet para agendar serviço: ");
                    String nomeBusca = scanner.nextLine();
                    final Pet petEncontrado = hotel.pets.stream()
                            .filter(p -> p.getNome().equalsIgnoreCase(nomeBusca))
                            .findFirst().orElse(null);

                    if (petEncontrado == null) {
                        System.out.println("Pet não encontrado.");
                        break;
                    }

                    System.out.println("Serviço (1-Banho, 2-Tosa, 3-Passeio): ");
                    int servOp = Integer.parseInt(scanner.nextLine());
                    Servico servico;
                    if (servOp == 1) servico = new Banho();
                    else if (servOp == 2) servico = new Tosa();
                    else servico = new Passeio();

                    System.out.print("Data e hora (yyyy-MM-dd HH:mm): ");
                    LocalDateTime inicio = LocalDateTime.parse(scanner.nextLine(), formatter);

                    hotel.agendarServico(petEncontrado, servico, inicio);
                    break;

                case 3:
                    System.out.print("Nome do pet para gerar fatura: ");
                    String nomeFatura = scanner.nextLine();
                    Pet petFatura = hotel.pets.stream()
                            .filter(p -> p.getNome().equalsIgnoreCase(nomeFatura))
                            .findFirst().orElse(null);

                    if (petFatura == null) {
                        System.out.println("Pet não encontrado.");
                        break;
                    }

                    System.out.print("Data e hora de saída (yyyy-MM-dd HH:mm): ");
                    LocalDateTime saida = LocalDateTime.parse(scanner.nextLine(), formatter);
                    hotel.gerarFatura(petFatura, saida);
                    break;
                case 4:
                    System.out.print("Informe o ano do relatório: ");
                    int ano = Integer.parseInt(scanner.nextLine());
                    System.out.print("Informe o mês do relatório (1-12): ");
                    int mes = Integer.parseInt(scanner.nextLine());

                    RelatorioHotelPet relatorio = new RelatorioHotelPet(hotel.getPets());
                    relatorio.relatorioMensal(ano, java.time.Month.of(mes));
                    break;
                
                case 5:
                    RelatorioHotelPet relatorioEspecie = new RelatorioHotelPet(hotel.getPets());
                    relatorioEspecie.listarHospedadosPorEspecie();
                    break;
                case 6:
                    RelatorioHotelPet relatorioPlano = new RelatorioHotelPet(hotel.getPets());
                    relatorioPlano.listarHospedadosPorPlano();
                    break;


                case 7:
                    System.out.println("Saindo...");
                    return;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
    }

