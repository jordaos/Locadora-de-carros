package br.com.ufc.locadora.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ufc.locadora.model.Carro;
import br.com.ufc.locadora.repository.CarroRepository;

@Service("carService")
public class CarroService {
	@Autowired
	private CarroRepository carroRepository;
	
	public Carro findCarroById(long id) {
		return carroRepository.findById(id);
	}
	
	public void saveCarro(Carro carro) {
		carroRepository.save(carro);
	}
	
	public Iterable<Carro> findAll(){
		return carroRepository.findAll();
	}
	
	public void removerCarro(long id){
		Carro carro = carroRepository.findById(id);
		carroRepository.delete(carro);
	}

	public void update(Carro carro) {
		carroRepository.save(carro);
		
	}
}