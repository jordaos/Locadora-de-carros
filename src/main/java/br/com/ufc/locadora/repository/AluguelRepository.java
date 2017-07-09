package br.com.ufc.locadora.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.ufc.locadora.model.Aluguel;
import br.com.ufc.locadora.model.Cliente;

public interface AluguelRepository extends CrudRepository<Aluguel, Long>{
	
	Aluguel findById(Long id);
	
	Iterable<Aluguel> findByCliente(Cliente cliente);
}