package br.com.ufc.locadora.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.ufc.locadora.model.Carro;

public interface CarroRepository extends CrudRepository<Carro, Long>{
	
	Carro findById(Long id);
	
}