package home;

import java.util.ArrayList;

import java.util.Scanner;

public class CarroService {
    private ArrayList<Carro> listaCarros = new ArrayList<>();

    public CarroService() {
        listaCarros.add(new Carro("Compacto", "Fiat", "Argo", 5, 120));
        listaCarros.add(new Carro("SUV", "Jeep", "Renegade", 5, 220));
        listaCarros.add(new Carro("Luxo", "BMW", "320i", 5, 450));
        listaCarros.add(new Carro("Utilitário", "Fiat", "Strada", 2, 180));
    }
   
    public void cadastrarCarro(Scanner scanner) {
        try {
            System.out.print("Categoria: ");
            String idCategoria = scanner.nextLine();

            System.out.print("Marca: ");
            String marca = scanner.nextLine();

            System.out.print("Modelo: ");
            String modelo = scanner.nextLine();

            System.out.print("Telefone: ");
            int capacidadePassageiros = scanner.nextInt();

            System.out.print("Valor Diario: ");
            int valorDiario = scanner.nextInt();

            

            Carro carro = new Carro(idCategoria,marca,modelo,capacidadePassageiros,valorDiario);

            listaCarros.add(carro);
            System.out.println("✅ Carro cadastrado com sucesso!");
           

        } catch (Exception e) {
            System.out.println("Algo deu errado");
        }
		
    }

    public int listarCarros() {
    	int contador = 0;
        if (listaCarros.isEmpty()) {
            System.out.println("⚠ Nenhum carro disponível no momento.");
            return contador;
        } else {
            System.out.println("\n--- Lista de Carros Disponíveis ---");
            for (Carro carro : listaCarros) {
            	contador++;
                System.out.println(carro);
            }
            return contador;
        }
    }
    public ArrayList<Carro> getListaCarros() {
        return listaCarros;
    }
    
}

