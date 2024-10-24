package hotel;

import java.time.LocalDate;

public class Reserva {
    private String nomeHospede;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private Quarto quarto;

    public Reserva(String nomeHospede, LocalDate checkIn, LocalDate checkOut, Quarto quarto) {
        this.nomeHospede = nomeHospede;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.quarto = quarto;
        this.quarto.setDisponivel(false);  // Quando reserva é criada, o quarto é marcado como ocupado
    }

    public String getNomeHospede() {
        return nomeHospede;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    @Override
    public String toString() {
        return "Reserva de " + nomeHospede + " - Quarto " + quarto.getNumero() + " (" + quarto.getTipo() + ") - Check-in: " + checkIn + ", Check-out: " + checkOut;
    }
}
