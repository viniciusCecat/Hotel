package hotel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        int opcao;

        do {
            System.out.println("\nSistema de Gerenciamento de Hotel");
            System.out.println("1. Cadastrar Quarto");
            System.out.println("2. Listar Quartos");
            System.out.println("3. Cadastrar Reserva");
            System.out.println("4. Realizar Check-out");
            System.out.println("5. Gerar Relatório de Ocupação");
            System.out.println("6. Gerar Histórico de Reservas");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();  // Consumir o newline após o número

            switch (opcao) {
                case 1:
                    System.out.print("Número do quarto: ");
                    int numero = scanner.nextInt();
                    scanner.nextLine(); // Consumir o newline
                    System.out.print("Tipo de quarto (solteiro, casal, suite): ");
                    String tipo = scanner.nextLine();
                    System.out.print("Preço diário: ");
                    double preco = scanner.nextDouble();
                    hotel.cadastrarQuarto(numero, tipo, preco);
                    break;

                case 2:
                    hotel.listarQuartos();
                    break;

                case 3:
                    System.out.print("Nome do hóspede: ");
                    String nomeHospede = scanner.nextLine();

                    LocalDate checkIn = lerData(scanner, formatter, "Data de check-in (dd/MM/yyyy): ");
                    LocalDate checkOut = lerData(scanner, formatter, "Data de check-out (dd/MM/yyyy): ");

                    System.out.print("Número do quarto: ");
                    int numeroQuarto = scanner.nextInt();
                    hotel.cadastrarReserva(nomeHospede, checkIn, checkOut, numeroQuarto);
                    break;

                case 4:
                    System.out.print("Número do quarto: ");
                    int quartoParaCheckOut = scanner.nextInt();
                    hotel.realizarCheckOut(quartoParaCheckOut);
                    break;

                case 5:
                    hotel.gerarRelatorioOcupacao();
                    break;

                case 6:
                    System.out.print("Nome do hóspede: ");
                    String nomeParaHistorico = scanner.nextLine();
                    hotel.gerarHistoricoReservas(nomeParaHistorico);
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    // Método para ler uma data no formato brasileiro com tratamento de erros
    private static LocalDate lerData(Scanner scanner, DateTimeFormatter formatter, String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                String dataInput = scanner.nextLine();
                return LocalDate.parse(dataInput, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Data inválida. Use o formato dd/MM/yyyy.");
            }
        }
    }
}