package Controller.Interfaces;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import Model.Cliente;

public interface IClienteService {
    Cliente cadastrarCliente(Scanner scanner, String nome, String email, String senha, String telefone, String cpf,
                             String logradouro, String cep, String municipio, String numeroCasa,
                             String estado, String cnhNumero, String cnhCategoria, Date cnhValidade, Date dataNascimento);
    
    Cliente loginClientes(String cpf, String senha);

    Cliente getClientes(String nome);
    
}