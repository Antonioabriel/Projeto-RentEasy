package home;

import java.util.Date;
import java.util.Scanner;

public class SistemaService1 {
		
	    public void processoReserva(Scanner scanner, Cliente cliente, CarroService carroService,ReservaService sistemaReservas) {
	    	
	    	System.out.println(cliente);
	        while (true) {
	            int numeroCarros = carroService.listarCarros();
	            int idEscolhido = 0;
	            do {
	            	try {
	            		
	            		System.out.print("\nDigite o ID do carro que deseja escolher: ");
				        idEscolhido = scanner.nextInt();
				        scanner.nextLine();
				        if (idEscolhido <= 0 || idEscolhido > numeroCarros) {				            
				            System.out.println("❌ Numero não existe.\n");
						}
						 
					} catch (Exception e) {
						scanner.nextLine();
						System.out.println("❌ Numero inválido. Tente novamente.\n");
						
					}
	            	
				}while (idEscolhido == 0 || idEscolhido > numeroCarros);
				
	            

	            Carro carroSelecionado = null;
	            for (Carro carro : carroService.getListaCarros()) {
	                if (carro.getId() == idEscolhido) {
	                    carroSelecionado = carro;
	                    break;
	                }
	            }

	            if (carroSelecionado == null) {
	                System.out.println("❌ Numero inválido. Tente novamente.\n");
	                continue;
	            }

	            System.out.println("\nVocê selecionou: " + carroSelecionado.getModelo());
	            System.out.print("Deseja realizar a reserva? (S/N): ");
	            String resposta = scanner.nextLine();

	            if (resposta.equalsIgnoreCase("S")) {
	                System.out.println("✅ Reserva realizada com sucesso para o carro ID " + carroSelecionado.getId());
	                Reserva novaReserva = new Reserva(cliente, carroSelecionado, new Date());
	               
					sistemaReservas.adicionarReserva(novaReserva);
					sistemaReservas.mostrarReservasDoCliente(cliente);
	               
	                break;
	            } else {
	                System.out.println("🔁 Voltando para a lista de carros...\n");
	            }
	        }
	    }
	}



