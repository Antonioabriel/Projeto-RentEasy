package Model;

import java.util.Date;

public class Reserva {
    private Cliente cliente;
    private Carro carro;
    private Date dataReserva;

    public Reserva(Cliente cliente, Carro carro, Date dataReserva) {
        this.cliente = cliente;
        this.carro = carro;
        this.dataReserva = dataReserva;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Carro getCarro() {
        return carro;
    }

    public Date getDataReserva() {
        return dataReserva;
    }

    @Override
    public String toString() {
        return "Reserva de: " + cliente.getNome() +
               " | Carro: " + carro.getMarca() + " " + carro.getModelo() +
               " | Data: " + dataReserva;
    }
}

