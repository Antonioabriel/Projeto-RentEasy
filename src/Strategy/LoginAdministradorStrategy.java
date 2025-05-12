package Strategy;

import Controller.AdministradorService;
import Strategy.Interface.LoginStrategy;

public class LoginAdministradorStrategy implements LoginStrategy {
    private AdministradorService administradorService;

    public LoginAdministradorStrategy(AdministradorService administradorService) {
        this.administradorService = administradorService;
    }

    @Override
    public boolean autenticar(String nome, String senha) {
        return administradorService.loginAdm(nome, senha);
    }
}