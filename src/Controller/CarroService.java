package Controller;

import java.util.ArrayList;

import java.util.Scanner;

import Controller.Interfaces.ICarroService;
import Model.Carro;
import Model.Factory.CarroFactory;
import Model.Factory.Interfaces.ICarroFactory;

public class CarroService implements ICarroService {
    private ArrayList<Carro> listaCarros = new ArrayList<>();
    public Carro c = new Carro("Utilitário1111", "Fiat", "Strada", 2, 180);
    private ICarroFactory carroFactory = new CarroFactory();
    
    public CarroService() {
        listaCarros.add(new Carro("Compacto", "Fiat", "Argo", 5, 120));
        listaCarros.add(new Carro("SUV", "Jeep", "Renegade", 5, 220));
        listaCarros.add(new Carro("Luxo", "BMW", "320i", 5, 450));
        listaCarros.add(new Carro("Utilitário", "Fiat", "Strada", 2, 180));
    }
   
    @Override
    public void cadastrarCarro(Scanner scanner,String idCategoria,String marca,String modelo,int capacidadePassageiros,int valorDiario) {

    		Carro carro = carroFactory.criarCarro(idCategoria, marca, modelo, capacidadePassageiros, valorDiario);
            listaCarros.add(carro);
	
    }

    @Override
    public ArrayList<Carro> getListaCarros() {
        return listaCarros;
    }
    
}

