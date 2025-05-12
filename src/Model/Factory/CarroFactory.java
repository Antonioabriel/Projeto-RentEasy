package Model.Factory;

import Model.Carro;
import Model.Factory.Interfaces.ICarroFactory;

public class CarroFactory implements ICarroFactory{
    @Override
    public Carro criarCarro(String idCategoria, String marca, String modelo, int capacidadePassageiros, int valorDiario) {
        return new Carro(idCategoria, marca, modelo, capacidadePassageiros, valorDiario);
    }
}
