package hotel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<Quarto> quartos;
    private List<Reserva> reservas;

    public Hotel() {
        quartos = new ArrayList<>();
        reservas = new ArrayList<>();
    }

    public void cadastrarQuarto(int numero, String tipo, double precoDiario) {
        quartos.add(new Quarto(numero, tipo, precoDiario));
        System.out.println("Quarto cadastrado com sucesso.");
    }

    public void listarQuartos() {
        for (Quarto quarto : quartos) {
            System.out.println(quarto);
        }
    }

    public Quarto buscarQuarto(int numero) {
        for (Quarto quarto : quartos) {
            if (quarto.getNumero() == numero) {
                return quarto;
            }
        }
        return null;
    }

    public void cadastrarReserva(String nomeHospede, LocalDate checkIn, LocalDate checkOut, int numeroQuarto) {
        Quarto quarto = buscarQuarto(numeroQuarto);
        if (quarto != null && quarto.isDisponivel()) {
            reservas.add(new Reserva(nomeHospede, checkIn, checkOut, quarto));
            System.out.println("Reserva cadastrada com sucesso.");
        } else {
            System.out.println("Quarto não disponível ou inexistente.");
        }
    }

    public void realizarCheckOut(int numeroQuarto) {
        Quarto quarto = buscarQuarto(numeroQuarto);
        if (quarto != null && !quarto.isDisponivel()) {
            quarto.setDisponivel(true);
            System.out.println("Check-out realizado com sucesso.");
        } else {
            System.out.println("Quarto já está disponível.");
        }
    }

    public void gerarRelatorioOcupacao() {
        System.out.println("Relatório de Ocupação de Quartos:");
        for (Reserva reserva : reservas) {
            System.out.println(reserva);
        }
    }

    public void gerarHistoricoReservas(String nomeHospede) {
        System.out.println("Histórico de Reservas de " + nomeHospede + ":");
        for (Reserva reserva : reservas) {
            if (reserva.getNomeHospede().equalsIgnoreCase(nomeHospede)) {
                System.out.println(reserva);
            }
        }
    }
}
