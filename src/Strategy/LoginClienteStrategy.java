package Strategy;


import Controller.ClienteService;
import Model.Cliente;
import Strategy.Interface.LoginStrategy;

public class LoginClienteStrategy implements LoginStrategy {
    private ClienteService clienteService;

    public LoginClienteStrategy(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @Override
    public boolean autenticar(String cpf, String senha) {
        Cliente cliente = clienteService.loginClientes(cpf, senha);
        return cliente != null;
    }
}