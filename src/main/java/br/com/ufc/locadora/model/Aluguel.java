package br.com.ufc.locadora.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
	
	@Temporal(TemporalType.DATE)
    private Date data_inicio;
	
	@Temporal(TemporalType.DATE)
    private Date data_fim;
	
	@NotNull
	private boolean devolvido = false;
	
	public Aluguel(Carro carro, Cliente cliente, Date data_inicio, Date data_fim){
		this.carro = carro;
		this.cliente = cliente;
		this.data_inicio = data_inicio;
		this.data_fim = data_fim;
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
	public Date getData_inicio() {
		return data_inicio;
	}
	public void setData_inicio(Date data_inicio) {
		this.data_inicio = data_inicio;
	}
	public Date getData_fim() {
		return data_fim;
	}
	public void setData_fim(Date data_fim) {
		this.data_fim = data_fim;
	}
	public boolean isDevolvido() {
		return devolvido;
	}
	public void setDevolvido(boolean devolvido) {
		this.devolvido = devolvido;
	}
	
	
}
