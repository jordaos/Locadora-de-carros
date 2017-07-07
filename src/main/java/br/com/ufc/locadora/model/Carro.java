package br.com.ufc.locadora.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Carro {
	@Id @GeneratedValue
	private Long id;
	
	@NotNull
	@Size(min=1, max=50)
	private String marca;
	
	@NotNull
	@Size(min=1, max=50)
	private String modelo;
	
	@Digits(integer=4, fraction=0)
	@NotNull
	private int ano;
	
	@Digits(fraction = 2, integer = 4)
	@NotNull
	private double preco_dia;
	
	@Size(max=1000)
	private String descricao;
	
	@Size(max=8, min=8)
	private String placa;
	
	
	public Carro(String marca, String placa, String modelo, int ano, double preco_dia, String descricao){
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
		this.preco_dia = preco_dia;
		this.descricao = descricao;
		this.placa = placa;
	}
	public Carro(){}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public double getPreco_dia() {
		return preco_dia;
	}
	public void setPreco_dia(double preco_dia) {
		this.preco_dia = preco_dia;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
}
