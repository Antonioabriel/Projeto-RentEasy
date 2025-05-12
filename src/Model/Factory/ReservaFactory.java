package Model.Factory;

import java.util.Date;
import Model.Carro;
import Model.Cliente;
import Model.Reserva;
import Model.Factory.Interfaces.IReservaFactory;

public class ReservaFactory implements IReservaFactory {
	@Override
    public Reserva criarReserva(Cliente cliente, Carro carro) {
        return new Reserva(cliente, carro, new Date());
    }
}