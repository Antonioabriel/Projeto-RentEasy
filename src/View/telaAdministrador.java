package View;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Controller.CarroService;
import Controller.ClienteService;
import Controller.ReservaService;
import Model.Carro;
import Model.Cliente;
import Model.Reserva;

public class telaAdministrador {
    private CarroService carroService;
    private ReservaService sistemaReservas;
    private ClienteService cliente;
    Cliente cli;

    public telaAdministrador(CarroService carroService, ReservaService sistemaReservas,ClienteService cliente) {
        this.carroService = carroService;
        this.sistemaReservas = sistemaReservas;
        this.cliente = cliente;
        
    }

    public void menuAdministrador(Scanner scanner) {
        boolean continuar = true;

        while (continuar) {
        	
            System.out.println("\n🔐 Painel do Administrador:");
            System.out.println("1. Cadastrar novo carro");
            System.out.println("2. Listar todas reservas");
            System.out.println("3. Buscar cliente");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            
            String escolha = scanner.nextLine();
           

            switch (escolha) {
                case "1":
                	while (true) {
                		try {
	                        System.out.print("Categoria: ");
	                        String idCategoria = scanner.nextLine();
	
	                        System.out.print("Marca: ");
	                        String marca = scanner.nextLine();
	
	                        System.out.print("Modelo: ");
	                        String modelo = scanner.nextLine();
	
	                        System.out.print("Telefone: ");
	                        int capacidadePassageiros = scanner.nextInt();
	
	                        System.out.print("Valor Diario: ");
	                        int valorDiario = scanner.nextInt();
	
	                        
	                        carroService.cadastrarCarro(scanner,idCategoria,marca,modelo,capacidadePassageiros,valorDiario);
	
	                        System.out.println("✅ Carro cadastrado com sucesso!");
	                        break;
	                        
	                    } catch (Exception e) {
	                        System.out.println("Algo deu errado");
	                        continue;
	                    }
                		
					}
	                    
	                    
	                	ArrayList<Carro> ListaTemp = carroService.getListaCarros();
	    	            
	    	                System.out.println("\n--- Lista de Carros Disponíveis ---");
	    	                for (Carro carro : ListaTemp) {
	    	                
	    	                    System.out.println(carro);
	    	                }
	    	            
    	            
	                    break;
                case "2":
                	
                	List<Reserva> reservas = sistemaReservas.buscarReservasDoCliente(cli);
			        if (reservas.isEmpty()) {
			            System.out.println("📭 Você ainda não fez nenhuma reserva.");
			        } else {
			            System.out.println("📋 Suas reservas:");
			            for (Reserva r : reservas) {
			                System.out.println(r);
			            }
			        }
                    
                    break;
                case "3":
                	System.out.println("nome");
                	String nome = scanner.next();
                	cli = cliente.getClientes(nome);
                    
                    break;
                case "4":
                    continuar = false;
                    System.out.println("🔒 Saindo do painel do administrador...");
                    break;
                default:
                    System.out.println("❌ Opção inválida. Tente novamente.");

            }
            scanner.nextLine();

        }
    }
}
