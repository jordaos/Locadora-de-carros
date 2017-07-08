package br.com.ufc.locadora.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.ufc.locadora.model.Cliente;
import br.com.ufc.locadora.service.AluguelService;
import br.com.ufc.locadora.service.CarroService;
import br.com.ufc.locadora.service.ClienteService;

@Controller
@RequestMapping("/")
public class HomeController {
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private CarroService carroService;
	@Autowired
	private AluguelService aluguelService;
	
	//Lista carros
	@GetMapping("/")
	public String listarTodos(HttpSession session, Model model){
		Cliente cliente = (Cliente) session.getAttribute("cliente");
		if(cliente != null){
			model.addAttribute("cliente", cliente);
			if(cliente.isAdmin()){
				return "admin/index";
			}
			model.addAttribute("alugueis", aluguelService.getByCliente(cliente));
			return "user/visualizar_aluguel";
		}
		model.addAttribute("carros", carroService.findAll());
		return "index";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public String mostrarLogin(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login( HttpSession session, @RequestParam(value = "email") String email, @RequestParam(value = "senha") String senha) {
		Cliente cliente = clienteService.autenticar(email, senha);
		if(cliente != null){
			session.setAttribute("cliente", cliente);
			return "redirect:/";
		}
		return "login";
    }
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout( HttpSession session) {
		session.invalidate();
		return "redirect:/";
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
}
