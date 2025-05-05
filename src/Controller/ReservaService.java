package Controller;

import java.util.*;
import java.util.stream.Collectors;

import Model.Carro;
import Model.Cliente;
import Model.Reserva;

public class ReservaService {
    private List<Reserva> listaReservas = new ArrayList<>();
    
    

    public void adicionarReserva(Cliente cliente,Carro carroSelecionado) {
    	Reserva novaReserva = new Reserva(cliente, carroSelecionado, new Date());
		listaReservas.add(novaReserva);
	}

    public List<Reserva> buscarReservasDoCliente(Cliente cliente) {
        return listaReservas.stream()
                .filter(r -> r.getCliente().equals(cliente))
                .collect(Collectors.toList());
    }

   

	
}

