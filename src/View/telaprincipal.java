package View;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import Controller.AdministradorService;
import Controller.CarroService;
import Controller.ClienteService;
import Controller.ReservaService;
import Model.Administrador;
import Model.Cliente;
import Strategy.LoginAdministradorStrategy;
import Strategy.LoginClienteStrategy;
import Strategy.Interface.LoginStrategy;


public class telaprincipal {

	public static void main(String[] args) {
		TelaCarros reserva = new TelaCarros();
		Scanner scanner = new Scanner(System.in);
        ClienteService clienteService = new ClienteService();
        AdministradorService adm = new AdministradorService();
        CarroService carroService = new CarroService();
        ReservaService sistemaReservas = new ReservaService();
        telaAdministrador telaAdm = new telaAdministrador(carroService,sistemaReservas,clienteService);
        boolean isclinte = false;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        LoginStrategy loginStrategy;
        AdministradorService administradorService = new AdministradorService();
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
                    isclinte = true;
                    
            	} catch (Exception e) {
                    System.out.println(e.getMessage());
                }

                escolha = "SAIR";
                break;
                
                
                
                
                
            case "LOGIN":
            	escolha = "";
            	System.out.println("Digite sua escolha (Cliente ou Administrador ou VOLTAR): ");
            	escolha = scanner.nextLine().trim().toUpperCase();

            	switch (escolha) {
            	

                case "CLIENTE":
                    loginStrategy = new LoginClienteStrategy(clienteService);
                    isclinte = true;
                    break;

                case "ADMINISTRADOR":
                    loginStrategy = new LoginAdministradorStrategy(administradorService);
                    isclinte = false;
                    break;
                case "VOLTAR":
                    continue;

                default:
                    System.out.println("❌ Opção inválida.");
                    continue; 
            }

            System.out.print("Digite o CPF (ou 'SAIR' para voltar): ");
            String cpf = scanner.nextLine();
            if (cpf.equalsIgnoreCase("SAIR")) {
                System.out.println("🔙 Saindo do login...");
                escolha = "VOLTAR";
                continue; 
            }

            System.out.print("Senha: ");
            String senha = scanner.nextLine();

            if (loginStrategy.autenticar(cpf, senha)) {
                
                
				if (isclinte) {
                    clienteLogado = clienteService.buscarClientePorCPF(cpf);
                    System.out.println("✅ Login bem-sucedido!" + clienteLogado.getNome());
                }else {
                	System.out.println("✅ Login bem-sucedido! ADM");
				}
                
            } else {
                System.out.println("❌ Login falhou. Usuário ou senha inválidos.");
                continue; 
            }
            escolha = "SAIR";
            break;
            default:
                System.out.println("❌ Opção inválida! Tente novamente.");
                continue;
        }
    } while (!escolha.equals("SAIR")); 
    
    
    do {
        if (isclinte) {
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
