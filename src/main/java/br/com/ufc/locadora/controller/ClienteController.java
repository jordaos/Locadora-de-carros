package br.com.ufc.locadora.controller;

import javax.servlet.http.HttpSession;

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
	
	@Autowired
	HttpSession session;
	
	@GetMapping("/all")
	public String index(Model model){
		Cliente cliente = (Cliente) session.getAttribute("cliente");
		if(cliente == null){
			return "redirect:/login";
		}
		if(!cliente.isAdmin()){
			return "redirect:/403";
		}
		return "admin/visualizar_clientes";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String removeCliente(@PathVariable("id") long id) {
		Cliente cliente = (Cliente) session.getAttribute("cliente");
		if(cliente == null){
			return "redirect:/login";
		}
		service.removerCliente(id);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/editar", method = RequestMethod.GET)
    public String mostrarCadastro(Model model) {
		Cliente cliente = (Cliente) session.getAttribute("cliente");
		if(cliente == null){
			return "redirect:/login";
		}
		model.addAttribute("cliente", cliente);
        return "user/editar_perfil";
    }
	
	@RequestMapping(value = "/editar", method = RequestMethod.POST)
    public String cadastrar(Cliente nvCliente) {
		Cliente cliente = (Cliente) session.getAttribute("cliente");
		if(cliente == null){
			return "redirect:/login";
		}
		service.atualizarCliente(cliente, nvCliente);
		return "redirect:/";
    }
}
