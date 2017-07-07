package br.com.ufc.locadora.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ufc.locadora.model.Cliente;
import br.com.ufc.locadora.repository.ClienteRepository;

@Service("userService")
public class ClienteService {
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente findClienteByEmail(String email) {
		return clienteRepository.findByEmail(email);
	}
	
	public void saveCliente(Cliente cliente) {
		clienteRepository.save(cliente);
	}
	
	public Iterable<Cliente> findAll(){
		return clienteRepository.findAll();
	}
	
	public void removerCliente(long id){
		Cliente cliente = clienteRepository.findById(id);
		clienteRepository.delete(cliente);
	}
}
