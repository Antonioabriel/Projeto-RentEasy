package Controller;

import Model.Administrador;

public class AdministradorService {
	private Administrador adm = new Administrador("adm","adm");
	
	public Boolean loginAdm(String cpf,String senha) {
		if (adm.getNome().equals(cpf) && adm.getSenha().equals(senha)) {
			return true;
		} else {
			return false;
		}
		 
	 }
}
