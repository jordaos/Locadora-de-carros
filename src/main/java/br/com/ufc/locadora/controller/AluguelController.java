package br.com.ufc.locadora.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.ufc.locadora.model.Aluguel;
import br.com.ufc.locadora.model.Cliente;
import br.com.ufc.locadora.service.AluguelService;
import br.com.ufc.locadora.service.CarroService;

@Controller
@WebServlet
public class AluguelController {

	@Autowired
	private AluguelService aluguelService;
	
	@Autowired
	private CarroService carroService;
	
	@Autowired
	HttpSession session;
	
	@RequestMapping(value = "/alugar", method = RequestMethod.GET)
    public String mostrarCadastro(Model model) {
		Cliente cliente = (Cliente) session.getAttribute("cliente");
		if(cliente == null){
			return "redirect:/login";
		}
		model.addAttribute("cliente", cliente);
		model.addAttribute("carros", carroService.findAll());
        return "user/alugar";
    }
	
	@RequestMapping(value = "/alugar", method = RequestMethod.POST)
    public String cadastrar(Aluguel aluguel) {
		Cliente cliente = (Cliente) session.getAttribute("cliente");
		aluguel.setCliente(cliente);
		aluguelService.saveAluguel(aluguel);
		return "redirect:/";
    }
	
	
	/*@RequestMapping(value = "/verAluguel/{id}", method = RequestMethod.POST)
    public String getAluguelPorId(long id) {
		aluguelService.findAluguelById(id);
		return "redirect:/verAluguelId";
    }
	
	@RequestMapping(value = "/verAluguel/{id}/finalizarAluguel", method = RequestMethod.POST)
    public String finalizarAluguelPorId(long id) {
		Aluguel aluguel = aluguelService.findAluguelById(id);
		
		//lógica dos juros aqui 
		
		return "redirect:/finalizarAluguelId";
    }*/
	
	@RequestMapping(value = "aluguel/devolver/{id}", method = RequestMethod.GET)
	public String devolverCarro(@PathVariable("id") long id) {
		Cliente cliente = (Cliente) session.getAttribute("cliente");
		if(cliente == null){
			return "redirect:/login";
		}
		if(!cliente.isAdmin()){
			return "redirect:/403";
		}
		aluguelService.devolver(id);
		return "redirect:/aluguel/all";
	}
	
	@RequestMapping(value = "/aluguel/all", method = RequestMethod.GET)
	public String mostrarAlugueis(Model model) {
		Cliente cliente = (Cliente) session.getAttribute("cliente");
		if(cliente == null){
			return "redirect:/login";
		}
		if(!cliente.isAdmin()){
			return "redirect:/403";
		}
		model.addAttribute("cliente", cliente);
		model.addAttribute("alugueis", aluguelService.findAll());
		return "admin/visualizar_alugueis";
	}


}