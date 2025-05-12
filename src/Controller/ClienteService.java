package Controller;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import Controller.Interfaces.IClienteService;
import Model.Cliente;
import Model.Factory.ClienteFactory;
import Model.Factory.Interfaces.IClienteFactory;

public class ClienteService implements IClienteService{
    private ArrayList<Cliente> listaClientes = new ArrayList<>();
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private IClienteFactory clienteFactory = new ClienteFactory();

    
   
    @Override
    public Cliente cadastrarCliente(Scanner scanner,String nome,String email,String senha,String telefone,String cpf,
    		String logradouro,String cep,String municipio,String numeroCasa,
    		String estado,String cnhNumero,String cnhCategoria,Date cnhValidade,Date dataNascimento) {
        

            Cliente cliente = clienteFactory.criarCliente(nome, email, senha, telefone, cpf,
                    logradouro, cep, municipio, numeroCasa,
                    estado, cnhNumero, cnhCategoria, cnhValidade, dataNascimento);

            listaClientes.add(cliente);
            return cliente;

        
    }
    @Override
    public Cliente loginClientes(String cpf,String senha) {
    	try {

    		 Date dataNascimento = sdf.parse("1995-06-15");
    		 Date cnhValidade = sdf.parse("2028-04-20");

    		    
    		  Cliente cliente3 = new Cliente("Mathues", "email", "senha", "telefone", "cpf3",
    		            "logradouro", "cep", "municipio", "numeroCasa", "estado", "cnhNumero",
    		            "cnhCategoria", cnhValidade, dataNascimento);
    		  Cliente cliente4 = new Cliente("Antonio", "email", "senha", "telefone", "cpf2",
    		            "logradouro", "cep", "municipio", "numeroCasa", "estado", "cnhNumero",
    		            "cnhCategoria", cnhValidade, dataNascimento);
    	  

    	    Cliente cliente2 = new Cliente("Gabriel", "email", "senha", "telefone", "cpf1",
    	            "logradouro", "cep", "municipio", "numeroCasa", "estado", "cnhNumero",
    	            "cnhCategoria", cnhValidade, dataNascimento);
    	    listaClientes.add(cliente2);
    	    listaClientes.add(cliente3);
    	    listaClientes.add(cliente4);

    	} catch (Exception e) {
    	    
    	}
    	
    	
    	        for (Cliente cliente : listaClientes) {
    	            if (cliente.getCpf().equals(cpf) && cliente.getSenha().equals(senha)) {
    	                
    	                return cliente;
    	            }
    	        }

		return null;
    }
    
    public Cliente buscarClientePorCPF(String cpf) {
        return listaClientes.stream()
            .filter(cliente -> cliente.getCpf().equals(cpf))
            .findFirst()
            .orElse(null);
    }
    
    @Override
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
