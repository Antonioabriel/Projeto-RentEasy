package home;

import java.util.ArrayList;
import java.util.Date;

public class Cliente {
	private String nome;
    private String email;
    private String senha;
    private String telefone;
    private String cpf;
    private String logradouro;
    private String cep;
    private String municipio;
    private String numeroCasa;
    private String estado;
    private String cnhNumero;
    private String cnhCategoria;
    private Date cnhValidade;
    private Date dataNascimento;
   
    
    public Cliente(String nome, String email, String senha, String telefone, String cpf,
                   String logradouro, String cep, String municipio, String numeroCasa,
                   String estado, String cnhNumero, String cnhCategoria,
                   Date cnhValidade, Date dataNascimento) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.cpf = cpf;
        this.logradouro = logradouro;
        this.cep = cep;
        this.municipio = municipio;
        this.numeroCasa = numeroCasa;
        this.estado = estado;
        this.cnhNumero = cnhNumero;
        this.cnhCategoria = cnhCategoria;
        this.cnhValidade = cnhValidade;
        this.dataNascimento = dataNascimento;
    }
    
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", cpf='" + cpf + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", cep='" + cep + '\'' +
                ", municipio='" + municipio + '\'' +
                ", numeroCasa='" + numeroCasa + '\'' +
                ", estado='" + estado + '\'' +
                ", cnhNumero='" + cnhNumero + '\'' +
                ", cnhCategoria='" + cnhCategoria + '\'' +
                ", cnhValidade=" + cnhValidade +
                ", dataNascimento=" + dataNascimento +
                '}';
    }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getNumeroCasa() {
		return numeroCasa;
	}

	public void setNumeroCasa(String numeroCasa) {
		this.numeroCasa = numeroCasa;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCnhNumero() {
		return cnhNumero;
	}

	public void setCnhNumero(String cnhNumero) {
		this.cnhNumero = cnhNumero;
	}

	public String getCnhCategoria() {
		return cnhCategoria;
	}

	public void setCnhCategoria(String cnhCategoria) {
		this.cnhCategoria = cnhCategoria;
	}

	public Date getCnhValidade() {
		return cnhValidade;
	}

	public void setCnhValidade(Date cnhValidade) {
		this.cnhValidade = cnhValidade;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	

}
