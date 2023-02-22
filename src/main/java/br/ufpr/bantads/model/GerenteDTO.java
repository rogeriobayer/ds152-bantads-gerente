package br.ufpr.bantads.model;

import java.io.Serializable;

public class GerenteDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String nome;
	private String cpf;
	private String email;
	private int numClientes;

	public GerenteDTO() {
		super();
	}
	
	public GerenteDTO(Long id, String nome, String email, String cpf) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getNum_clientes() {
		return numClientes;
	}

	public void setNum_clientes(int num_clientes) {
		this.numClientes = num_clientes;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
