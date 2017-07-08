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
	
	public void atualizarCliente(Cliente velho, Cliente novo) {
		velho.setEmail(novo.getEmail());
		velho.setEndereco(novo.getEmail());
		velho.setNome(novo.getNome());
		velho.setSenha(novo.getSenha());
		clienteRepository.save(velho);
	}
	
	public Iterable<Cliente> findAll(){
		return clienteRepository.findAll();
	}
	
	public void removerCliente(long id){
		Cliente cliente = clienteRepository.findById(id);
		clienteRepository.delete(cliente);
	}
	
	public Cliente autenticar(String email, String senha){
		return clienteRepository.findByEmailAndSenha(email, senha);
	}
}
