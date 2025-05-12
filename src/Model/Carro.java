package Model;

public class Carro {
	 private static int contador = 0;
	 private int id;
    private String idCategoria; // Ex: compacto, SUV, luxo...
    private String marca;
    private String modelo;
    private int capacidadePassageiros;
    private int valorDiario;

    public Carro(String idCategoria, String marca, String modelo, int capacidadePassageiros, int valorDiario) {
    	this.id = contador++;
        this.idCategoria = idCategoria;
        this.marca = marca;
        this.modelo = modelo;
        this.capacidadePassageiros = capacidadePassageiros;
        this.valorDiario = valorDiario;
    }

    public String getIdCategoria() {
        return idCategoria;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getCapacidadePassageiros() {
        return capacidadePassageiros;
    }

    public double getValorDiario() {
        return valorDiario;
    }

    public static int getContador() {
		return contador;
	}

	public static void setContador(int contador) {
		Carro.contador = contador;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setIdCategoria(String idCategoria) {
		this.idCategoria = idCategoria;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public void setCapacidadePassageiros(int capacidadePassageiros) {
		this.capacidadePassageiros = capacidadePassageiros;
	}

	public void setValorDiario(int valorDiario) {
		this.valorDiario = valorDiario;
	}

	@Override
    public String toString() {
        return "Numero " + id +
                " Categoria " + idCategoria + '\'' +
                " Marca " + marca + '\'' +
                " Modelo " + modelo + '\'' +
                " Capacidade " + capacidadePassageiros +
                " Valor Diário R$ " + valorDiario;
    }
}
