package br.com.ufc.locadora.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

@Entity
public class Aluguel {
	@Id @GeneratedValue
	private Long id;
	
	@NotNull
	@JoinColumn(name = "id_carro", referencedColumnName = "id")
    @ManyToOne
	private Carro carro;
	
	@NotNull
	@JoinColumn(name = "id_cliente", referencedColumnName = "id")
    @ManyToOne
	private Cliente cliente;
	
	@Digits(integer=2, fraction=0)
	@NotNull
	private int tempo;//em dias
	
	public Aluguel(Carro carro, Cliente cliente, int tempo){
		this.carro = carro;
		this.cliente = cliente;
		this.tempo = tempo;
	}
	public Aluguel(){}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Carro getCarro() {
		return carro;
	}
	public void setCarro(Carro carro) {
		this.carro = carro;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public int getTempo() {
		return tempo;
	}
	public void setTempo(int tempo) {
		this.tempo = tempo;
	}
}
