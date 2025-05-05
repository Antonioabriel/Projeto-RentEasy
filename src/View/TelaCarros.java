package View;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import Controller.CarroService;
import Controller.ReservaService;
import Model.Carro;
import Model.Cliente;
import Model.Reserva;

public class TelaCarros {
		
	    public void processoReserva(Scanner scanner, Cliente cliente, CarroService carroService,ReservaService sistemaReservas) {
	    	
	    	System.out.println(cliente);
	        while (true) {
	        	int contador = 0;
	        	ArrayList<Carro> ListaTemp = carroService.getListaCarros();
	            if (ListaTemp.isEmpty()) {
	                System.out.println("⚠ Nenhum carro disponível no momento.");
	                
	            } else {
	                System.out.println("\n--- Lista de Carros Disponíveis ---");
	                for (Carro carro : ListaTemp) {
	                	contador++;
	                    System.out.println(carro);
	                }
	            }
	        	
	            int numeroCarros = contador;
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
	                    
	                }
	            }

	            

	            System.out.println("\nVocê selecionou: " + carroSelecionado.getModelo());
	            System.out.print("Deseja realizar a reserva? (S/N): ");
	            String resposta = scanner.nextLine();

	            if (resposta.equalsIgnoreCase("S")) {
	                System.out.println("✅ Reserva realizada com sucesso para o carro ID " + carroSelecionado.getId());
	                
	               
					sistemaReservas.adicionarReserva(cliente, carroSelecionado);
					
					List<Reserva> reservas = sistemaReservas.buscarReservasDoCliente(cliente);
			        if (reservas.isEmpty()) {
			            System.out.println("📭 Você ainda não fez nenhuma reserva.");
			        } else {
			            System.out.println("📋 Suas reservas:");
			            for (Reserva r : reservas) {
			                System.out.println(r);
			            }
			        }
					
	               
	                break;
	            } else {
	                System.out.println("🔁 Voltando para a lista de carros...\n");
	            }
	        }
	    }
	}



