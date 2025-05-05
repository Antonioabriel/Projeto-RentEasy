package Controller;

import java.util.ArrayList;

import java.util.Scanner;

import Model.Carro;

public class CarroService {
    private ArrayList<Carro> listaCarros = new ArrayList<>();
    public Carro c = new Carro("Utilitário1111", "Fiat", "Strada", 2, 180);
    
    public CarroService() {
        listaCarros.add(new Carro("Compacto", "Fiat", "Argo", 5, 120));
        listaCarros.add(new Carro("SUV", "Jeep", "Renegade", 5, 220));
        listaCarros.add(new Carro("Luxo", "BMW", "320i", 5, 450));
        listaCarros.add(new Carro("Utilitário", "Fiat", "Strada", 2, 180));
    }
   
    public void cadastrarCarro(Scanner scanner,String idCategoria,String marca,String modelo,int capacidadePassageiros,int valorDiario) {

            Carro carro = new Carro(idCategoria,marca,modelo,capacidadePassageiros,valorDiario);
            listaCarros.add(carro);
	
    }

    
    public ArrayList<Carro> getListaCarros() {
        return listaCarros;
    }
    
}

