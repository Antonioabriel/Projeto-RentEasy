package View;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import Controller.CarroService;
import Controller.ClienteService;
import Controller.ReservaService;
import Model.Administrador;
import Model.Cliente;


public class telaprincipal {

	public static void main(String[] args) {
		TelaCarros reserva = new TelaCarros();
		Scanner scanner = new Scanner(System.in);
        ClienteService clienteService = new ClienteService();
        CarroService carroService = new CarroService();
        ReservaService sistemaReservas = new ReservaService();
        telaAdministrador telaAdm = new telaAdministrador(carroService,sistemaReservas,clienteService);
        boolean iscleinte = false;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Administrador adm = new Administrador("adm","adm");
        String escolha;
        Cliente clienteLogado = null;
        String resposta = "S";
        
  
while (true) {
	do {
        System.out.println("\n--------------------");
        System.out.println("   Cadastro ou Login");
        System.out.println("--------------------");
        System.out.print("Digite sua escolha (CADASTRO ou LOGIN): ");
        escolha = scanner.nextLine().trim().toUpperCase();

        switch (escolha) {
            case "CADASTRO":
            	try {
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    System.out.print("Senha: ");
                    String senha = scanner.nextLine();

                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();

                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();

                    System.out.print("Logradouro: ");
                    String logradouro = scanner.nextLine();

                    System.out.print("CEP: ");
                    String cep = scanner.nextLine();

                    System.out.print("Município: ");
                    String municipio = scanner.nextLine();

                    System.out.print("Número da casa: ");
                    String numeroCasa = scanner.nextLine();

                    System.out.print("Estado (UF): ");
                    String estado = scanner.nextLine();

                    System.out.print("Número da CNH: ");
                    String cnhNumero = scanner.nextLine();

                    System.out.print("Categoria da CNH: ");
                    String cnhCategoria = scanner.nextLine();

                    Date cnhValidade = null;
                    while (cnhValidade == null) {
                        System.out.print("Validade da CNH (yyyy-MM-dd): ");
                        try {
                            cnhValidade = sdf.parse(scanner.nextLine());
                        } catch (ParseException e) {
                            System.out.println("❌ Data inválida. Tente novamente.");
                        }
                    }

                    Date dataNascimento = null;
                    while (dataNascimento == null) {
                        System.out.print("Data de nascimento (yyyy-MM-dd): ");
                        try {
                            dataNascimento = sdf.parse(scanner.nextLine());
                        } catch (ParseException e) {
                            System.out.println("❌ Data inválida. Tente novamente.");
                        }
                    }
                    clienteLogado = clienteService.cadastrarCliente(scanner,nome, email, senha, telefone, cpf,
                            logradouro, cep, municipio, numeroCasa,
                            estado, cnhNumero, cnhCategoria, cnhValidade, dataNascimento);
                    iscleinte = true;
                    
            	} catch (Exception e) {
                    System.out.println("Algo deu errado");
                }

                escolha = "SAIR";
                break;
                
                
                
                
                
            case "LOGIN":
            	escolha = "";
            	System.out.println("Digite sua escolha (Cliente ou Administrador ou VOLTAR): ");
            	escolha = scanner.nextLine().trim().toUpperCase();

            	switch (escolha) {
            	
					case "CLIENTE" : 
						 while (true) {
				    	        System.out.print("Digite o CPF (ou 'SAIR' para voltar): ");
				    	        String cpf = scanner.nextLine();
				    	        if (cpf.equalsIgnoreCase("SAIR")) {
				    	            System.out.println("🔙 Saindo do login...");
				    	            break;
				    	        }

				    	        System.out.print("Digite a senha: ");
				    	        String senha = scanner.nextLine();

				    	        clienteLogado = clienteService.loginClientes(scanner,cpf,senha);
				    	        if(clienteLogado == null) {
				    	        	System.out.println("❌ CPF ou senha inválidos. Tente novamente.\n");
				    	        	
				    	        }else {
				    	        	System.out.println("✅ Login bem-sucedido! Bem-vindo, " + clienteLogado.getNome() + "!");
				    	        	iscleinte = true;
				    	        	break;
				    	        	
								}
				    	        
				    	    }
						
	                    escolha = "SAIR";
	                    
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
        
    } while (!escolha.equals("SAIR")); 
    
    
    do {
        if (iscleinte) {
        	do {
				reserva.processoReserva(scanner, clienteLogado, carroService,sistemaReservas);
				System.out.print("---- Deseja realizar outra reserva? (S/N): ");
				resposta = scanner.nextLine();	
        	} while (resposta.equalsIgnoreCase("S"));
        	escolha = "SAIR";
		}else {
			telaAdm.menuAdministrador(scanner);
			escolha = "SAIR";
		}
    } while (!escolha.equals("SAIR")); 
    
}
        
        
		
        
        
        
        

		
		

	}

}

