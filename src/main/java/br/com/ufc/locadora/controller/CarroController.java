package br.com.ufc.locadora.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.ufc.locadora.model.Carro;
import br.com.ufc.locadora.model.Cliente;
import br.com.ufc.locadora.service.CarroService;

@Controller
@RequestMapping("/carros")
public class CarroController {
	@Autowired
	private CarroService service;
	
	@Autowired
	HttpSession session;
	
	//Lista de carros (Se o adm estiver logado)
	@GetMapping("/all")
	public String listarTodos(Model model){
		Cliente cliente = (Cliente) session.getAttribute("cliente");
		if(cliente == null){
			return "redirect:/login";
		}
		if(!cliente.isAdmin()){
			return "redirect:/403";
		}
		model.addAttribute("cliente", cliente);
		model.addAttribute("carros", service.findAll());
		return "admin/visualizar_carros";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String removeCarro(@PathVariable("id") long id) {
		Cliente cliente = (Cliente) session.getAttribute("cliente");
		if(cliente == null){
			return "redirect:/login";
		}
		if(!cliente.isAdmin()){
			return "redirect:/403";
		}
		service.removerCarro(id);
		return "redirect:/carros/all";
	}
	
	@RequestMapping(value = "/cadastrar", method = RequestMethod.GET)
    public String mostrarCadastro(Model model) {
		Cliente cliente = (Cliente) session.getAttribute("cliente");
		if(cliente == null){
			return "redirect:/login";
		}
		if(!cliente.isAdmin()){
			return "redirect:/403";
		}
		model.addAttribute("cliente", cliente);
        return "admin/cadastrar_carro";
    }
	
	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
    public String cadastrar(Carro carro, Model model) {
		Cliente cliente = (Cliente) session.getAttribute("cliente");
		if(cliente == null){
			return "redirect:/login";
		}
		if(!cliente.isAdmin()){
			return "redirect:/403";
		}
		model.addAttribute("cliente", cliente);
		service.saveCarro(carro);
		return "redirect:/carros/cadastrar";
    }
	
	@RequestMapping(value = "/editar/{id}", method = RequestMethod.GET)
    public String mostrarEditar(@PathVariable("id") long id, Model model) {
		Cliente cliente = (Cliente) session.getAttribute("cliente");
		if(cliente == null){
			return "redirect:/login";
		}
		if(!cliente.isAdmin()){
			return "redirect:/403";
		}
		model.addAttribute("cliente", cliente);
		model.addAttribute("carro", service.findCarroById(id));
        return "admin/editar_carro";
    }
	
	@RequestMapping(value = "/editar/{id}", method = RequestMethod.POST)
	public String update(Carro carro){
		Cliente cliente = (Cliente) session.getAttribute("cliente");
		if(cliente == null){
			return "redirect:/login";
		}
		if(!cliente.isAdmin()){
			return "redirect:/403";
		}
        service.saveCarro(carro);
        return "redirect:/carros/all";
    }
}