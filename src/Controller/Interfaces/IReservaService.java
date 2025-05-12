package Controller.Interfaces;

import java.util.List;
import Model.Cliente;
import Model.Carro;
import Model.Reserva;

public interface IReservaService {
    void adicionarReserva(Cliente cliente, Carro carroSelecionado);
    List<Reserva> buscarReservasDoCliente(Cliente cliente);
}