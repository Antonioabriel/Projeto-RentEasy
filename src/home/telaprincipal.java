package home;

import java.util.Scanner;


public class telaprincipal {

	public static void main(String[] args) {
		SistemaService1 reserva = new SistemaService1();
		Scanner scanner = new Scanner(System.in);
        ClienteService clienteService = new ClienteService();
        CarroService carroService = new CarroService();
        String escolha;
        Cliente clienteLogado = null;
        String resposta = "S";
        ReservaService sistemaReservas = new ReservaService();
        telaAdministrador telaAdm = new telaAdministrador(carroService,sistemaReservas,clienteService);
        boolean iscleinte = false;
        
        Administrador adm = new Administrador("adm","adm");
        
  

        do {
            System.out.println("\n--------------------");
            System.out.println("   Cadastro ou Login");
            System.out.println("--------------------");
            System.out.print("Digite sua escolha (CADASTRO ou LOGIN): ");
            escolha = scanner.nextLine().trim().toUpperCase();

            switch (escolha) {
                case "CADASTRO":
                	clienteLogado = clienteService.cadastrarCliente(scanner);
                    escolha = "SAIR";
                    break;
                case "LOGIN":
                	escolha = "";
                	System.out.println("Digite sua escolha (Cliente ou Administrador ou VOLTAR): ");
                	escolha = scanner.nextLine().trim().toUpperCase();

                	switch (escolha) {
                	
						case "CLIENTE" : 
							clienteLogado = clienteService.loginClientes(scanner);
		                    escolha = "SAIR";
		                    iscleinte = true;
		                    break;	
		                
						case "ADMINISTRADOR":
							iscleinte = false;
							while (true) {
								
				    	        System.out.print("Digite o Nome (ou 'SAIR' para voltar): ");
				    	        String cpf = scanner.nextLine();
				    	        if (cpf.equalsIgnoreCase("SAIR")) {
				    	            System.out.println("🔙 Saindo do login...");
				    	            escolha = "VOLTAR";
				    	            break;
				    	        }
				    	        
				    	        System.out.print("Digite a senha: ");
				    	        String senha = scanner.nextLine();

				    	        
				    	            if (adm.getNome().equals(cpf) && adm.getSenha().equals(senha)) {
				    	                System.out.println("✅ Login bem-sucedido! Bem-vindo, " + adm.getNome() + "!");  
				    	                escolha = "SAIR";
				    	                break;
				    	            }else {
				    	            	System.out.println("❌ CPF ou senha inválidos. Tente novamente.\n");
				    	            	escolha = "VOLTAR";
									}
 
				    	    }
							break;
					}
                	break;
                case "VOLTAR":
                    System.out.println("Voltando...");
                    escolha = "voltar";
                    break;
                default:
                    System.out.println("❌ Opção inválida! Tente novamente.");
            }
            if (iscleinte) {
            	do {
    				reserva.processoReserva(scanner, clienteLogado, carroService,sistemaReservas);
    				System.out.print("---- Deseja realizar outra reserva? (S/N): ");
    				resposta = scanner.nextLine();	
            	} while (resposta.equalsIgnoreCase("S"));
            	escolha = "VOLTAR";
    		}else {
    			telaAdm.menuAdministrador(scanner);
    			escolha = "VOLTAR";
    		}
        } while (!escolha.equals("SAIR")); 
        
        
        
		
        
        
        
        

		
		

	}

}

