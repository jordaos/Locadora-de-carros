package br.com.ufc.locadora.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ufc.locadora.model.Aluguel;
import br.com.ufc.locadora.model.Cliente;
import br.com.ufc.locadora.repository.AluguelRepository;

@Service("aluguelService")
public class AluguelService {
	
	@Autowired
	private AluguelRepository aluguelRepository;
	
	public Aluguel findAluguelById(long id) {
		return aluguelRepository.findById(id);
	}
	
	public void saveAluguel(Aluguel aluguel) {
		aluguelRepository.save(aluguel);
	}
	
	public Iterable<Aluguel> findAll(){
		return aluguelRepository.findAll();
	}
	
	public void finalizarLocacao(long id){
		Aluguel aluguel = aluguelRepository.findById(id);
		aluguelRepository.delete(aluguel);
	}
	
	public Iterable<Aluguel> getByCliente(Cliente cliente){
		return aluguelRepository.findByCliente(cliente);
	}
}