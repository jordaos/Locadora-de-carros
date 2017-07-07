package br.com.ufc.locadora.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.ufc.locadora.model.Aluguel;

public interface AluguelRepository extends CrudRepository<Aluguel, Long>{
	
	Aluguel findById(Long id);
	
}