package Controller;

import java.util.*;
import java.util.stream.Collectors;

import Controller.Interfaces.IReservaService;
import Model.Carro;
import Model.Cliente;
import Model.Reserva;
import Model.Factory.ReservaFactory;
import Model.Factory.Interfaces.IReservaFactory;

public class ReservaService implements IReservaService{
    private List<Reserva> listaReservas = new ArrayList<>();
    private IReservaFactory reservaFactory = new ReservaFactory();
    @Override
    public void adicionarReserva(Cliente cliente,Carro carroSelecionado) {
    	Reserva novaReserva = reservaFactory.criarReserva(cliente, carroSelecionado);
		listaReservas.add(novaReserva);
	}
    
    @Override
    public List<Reserva> buscarReservasDoCliente(Cliente cliente) {
        return listaReservas.stream()
                .filter(r -> r.getCliente().equals(cliente))
                .collect(Collectors.toList());
    }

 }

