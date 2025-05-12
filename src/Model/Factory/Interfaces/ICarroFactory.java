package Model.Factory.Interfaces;

import Model.Carro;

public interface ICarroFactory {
    Carro criarCarro(String idCategoria, String marca, String modelo, int capacidadePassageiros, int valorDiario);
}