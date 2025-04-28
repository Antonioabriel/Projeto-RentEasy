package home;

import java.util.Scanner;

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
                    carroService.cadastrarCarro(scanner);
                    carroService.listarCarros();
                    break;
                case "2":
                    sistemaReservas.mostrarReservasDoCliente(cli);
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
