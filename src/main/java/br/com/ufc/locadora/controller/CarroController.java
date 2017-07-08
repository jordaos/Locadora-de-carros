package br.com.ufc.locadora.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.ufc.locadora.model.Carro;
import br.com.ufc.locadora.service.CarroService;

@Controller
@RequestMapping("/carros")
public class CarroController {
	@Autowired
	private CarroService service;
	
	//Lista de carros (Se o adm estiver logado)
	@GetMapping("/")
	public String listarTodos(Model model){
		model.addAttribute("carros", service.findAll());
		return "listaCarros";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String removeCarro(@PathVariable("id") long id) {
		service.removerCarro(id);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/cadastrar", method = RequestMethod.GET)
    public String mostrarCadastro() {
        return "add_carro";
    }
	
	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
    public String cadastrar(Carro carro) {
		service.saveCarro(carro);
		return "redirect:/cadastrar";
    }
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public void update(Carro carro){
        service.update(carro);
    }
}