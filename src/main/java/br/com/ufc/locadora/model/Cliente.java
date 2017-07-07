package br.com.ufc.locadora.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Cliente {
	@Id @GeneratedValue
	private Long id;
	
	@NotNull
	@Size(min=1, max=50)
	private String nome;
	
	@NotNull
	@Size(min=1, max=50)
	private String email;
	
	@NotNull
	@Size(min=1, max=50)
	private String senha;
	
	private boolean isAdmin = false;
	
	@NotNull
	@Size(min=1, max=90)
	private String endereco;
	
	public Cliente(String nome, String email, String senha, String endereco){
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.endereco = endereco;
	}
	public Cliente(){}
	
	
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
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
}
