package Controller.Interfaces;

import java.util.ArrayList;
import java.util.Scanner;

import Model.Carro;

public interface ICarroService {
	
	    ArrayList<Carro> getListaCarros();
		void cadastrarCarro(Scanner scanner, String idCategoria, String marca, String modelo, int capacidadePassageiros,
				int valorDiario);
    
}
