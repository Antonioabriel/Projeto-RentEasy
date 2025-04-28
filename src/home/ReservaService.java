package home;

import java.util.*;
import java.util.stream.Collectors;

public class ReservaService {
    private List<Reserva> listaReservas = new ArrayList<>();

    public void adicionarReserva(Reserva r) {
		listaReservas.add(r);
	}

    public List<Reserva> buscarReservasDoCliente(Cliente cliente) {
        return listaReservas.stream()
                .filter(r -> r.getCliente().equals(cliente))
                .collect(Collectors.toList());
    }

    public void mostrarReservasDoCliente(Cliente cliente) {
        List<Reserva> reservas = buscarReservasDoCliente(cliente);
        if (reservas.isEmpty()) {
            System.out.println("📭 Você ainda não fez nenhuma reserva.");
        } else {
            System.out.println("📋 Suas reservas:");
            for (Reserva r : reservas) {
                System.out.println(r);
            }
        }
    }

	
}

