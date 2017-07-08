package br.com.ufc.locadora.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.ufc.locadora.model.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long>{
	
	Cliente findById(Long id);
	
	Cliente findByEmail(String email);
	
	Cliente findByEmailAndSenha(String email, String senha);
}