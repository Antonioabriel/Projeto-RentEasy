package Model.Factory.Interfaces;

import Model.Cliente;
import java.util.Date;

public interface IClienteFactory {
    Cliente criarCliente(String nome, String email, String senha, String telefone, String cpf,
                         String logradouro, String cep, String municipio, String numeroCasa,
                         String estado, String cnhNumero, String cnhCategoria,
                         Date cnhValidade, Date dataNascimento);
}