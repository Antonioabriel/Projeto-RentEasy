package Model.Factory.Interfaces;

import Model.Reserva;
import Model.Cliente;
import Model.Carro;
import java.util.Date;

public interface IReservaFactory {
    Reserva criarReserva(Cliente cliente, Carro carro);
}