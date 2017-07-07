package br.com.ufc.locadora.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.ufc.locadora.model.Cliente;
import br.com.ufc.locadora.service.ClienteService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	@Autowired
	private ClienteService service;
	
	//Lista de clientes (Se o adm estiver logado)
	@GetMapping("/")
	public String listarTodos(Model model){
		model.addAttribute("clientes", service.findAll());
		return "listaClientes";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String removeCliente(@PathVariable("id") long id) {
		service.removerCliente(id);
		return "redirect:/";
	}
}
