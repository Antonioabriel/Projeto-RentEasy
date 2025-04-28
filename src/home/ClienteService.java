package home;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ClienteService{
    private ArrayList<Cliente> listaClientes = new ArrayList<>();
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    
    
   

    public Cliente cadastrarCliente(Scanner scanner) {
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

            Cliente cliente = new Cliente(nome, email, senha, telefone, cpf,
                    logradouro, cep, municipio, numeroCasa,
                    estado, cnhNumero, cnhCategoria, cnhValidade, dataNascimento);

            listaClientes.add(cliente);
            System.out.println("✅ Cliente cadastrado com sucesso!");
            return cliente;

        } catch (Exception e) {
            System.out.println("Algo deu errado");
        }
		return null;
    }

    public Cliente loginClientes(Scanner scanner) {
    	try {

    		 Date dataNascimento = sdf.parse("1995-06-15");
    		 Date cnhValidade = sdf.parse("2028-04-20");

    		    
    		  Cliente cliente3 = new Cliente("nome44444444", "email", "senha", "telefone", "cpf",
    		            "logradouro", "cep", "municipio", "numeroCasa", "estado", "cnhNumero",
    		            "cnhCategoria", cnhValidade, dataNascimento);
    		  Cliente cliente4 = new Cliente("nome2", "email", "senha", "telefone", "cpf",
    		            "logradouro", "cep", "municipio", "numeroCasa", "estado", "cnhNumero",
    		            "cnhCategoria", cnhValidade, dataNascimento);
    	  

    	    Cliente cliente2 = new Cliente("nome", "email", "senha", "telefone", "cpf",
    	            "logradouro", "cep", "municipio", "numeroCasa", "estado", "cnhNumero",
    	            "cnhCategoria", cnhValidade, dataNascimento);
    	    listaClientes.add(cliente2);

    	} catch (Exception e) {
    	    System.out.println("Erro ao converter datas: " + e.getMessage());
    	}
    	
    	
    	 while (true) {
    	        System.out.print("Digite o CPF (ou 'SAIR' para voltar): ");
    	        String cpf = scanner.nextLine();
    	        if (cpf.equalsIgnoreCase("SAIR")) {
    	            System.out.println("🔙 Saindo do login...");
    	            break;
    	        }

    	        System.out.print("Digite a senha: ");
    	        String senha = scanner.nextLine();

    	        for (Cliente cliente : listaClientes) {
    	            if (cliente.getCpf().equals(cpf) && cliente.getSenha().equals(senha)) {
    	                System.out.println("✅ Login bem-sucedido! Bem-vindo, " + cliente.getNome() + "!");
    	                return cliente;
    	            }
    	        }

    	        System.out.println("❌ CPF ou senha inválidos. Tente novamente.\n");
    	    }
		return null;
    }
    public Cliente getClientes(String nome) {
    		for (Cliente cliente : listaClientes) {
	            if (cliente.getNome().equals(nome)) {
	                System.out.println( cliente.getNome() + "!");
	                return cliente;
	            }
	        }
        return null;
    }

	@Override
	public String toString() {
		return "ClienteService [listaClientes=" + listaClientes + "]";
	}
    
}
