package br.com.ufc.locadora.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.ufc.locadora.model.Cliente;
import br.com.ufc.locadora.service.ClienteService;

@Controller
@RequestMapping("/")
public class HomeController {
	@Autowired
	private ClienteService clienteService;
	
	//Lista carros
	@GetMapping("/")
	public String listarTodos(Model model){
		//model.addAttribute("carros", carro_repositorio.findAll());
		return "index";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }
	
	@RequestMapping(value = "/cadastrar", method = RequestMethod.GET)
    public String mostrarCadastro() {
        return "add_cliente";
    }
	
	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
    public String cadastrar(Cliente cliente) {
		clienteService.saveCliente(cliente);
		return "redirect:/cadastrar";
    }
	/*
	//Lista carros
	@GetMapping("/cadastrar")
	public String mostrarCadastro(){
		//model.addAttribute("carros", carro_repositorio.findAll());
		return "cadastro";
	}
	
	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") Cliente cliente, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "cadastro";
        }

        clienteService.saveCliente(cliente);

        return "redirect:/login";
    }*/
}
