package Model.Factory;

import java.util.Date;


import Model.Cliente;
import Model.Factory.Interfaces.IClienteFactory;

public class ClienteFactory implements IClienteFactory {
    public Cliente criarCliente( String nome, String email, String senha, String telefone, String cpf,
                                       String logradouro, String cep, String municipio, String numeroCasa,
                                       String estado, String cnhNumero, String cnhCategoria,
                                       Date cnhValidade, Date dataNascimento) {
    	
        return new Cliente(nome, email, senha, telefone, cpf,
                logradouro, cep, municipio, numeroCasa,
                estado, cnhNumero, cnhCategoria, cnhValidade, dataNascimento);
    }
}