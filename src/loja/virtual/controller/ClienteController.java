package loja.virtual.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.servlet.ModelAndView;

import loja.virtual.model.Cliente;

@Controller
public class ClienteController {
	@Autowired
	private List<Cliente> lista;
	
	@Bean
	@ApplicationScope
	public List<Cliente> listaClientes(){
		return new ArrayList<>();
	}
	
	@GetMapping("/cliente")
	public ModelAndView getCliente() {
		ModelAndView mv = new ModelAndView("cliente");
		Cliente c = new Cliente();
		mv.addObject("LISTA_CLIENTE", lista);
		mv.addObject("CLIENTE_ATUAL", c);
		return mv;
	}
	
	@PostMapping("/cliente")
	public ModelAndView postCliente(
			@ModelAttribute("CLIENTE_ATUAL") @Valid Cliente c, 
			BindingResult result, @RequestParam("cmd") String cmd){
		ModelAndView mv = new ModelAndView("cliente");
		mv.addObject("LISTA_CLIENTE", lista);
		if(! result.hasErrors()) {
			if("adicionar".equals(cmd)) {
				lista.add(c);
				System.out.printf("Cliente adicionado, agora "
						+ "há %d clientes na lista%n", lista.size());
				mv.addObject("CLIENTE_ATUAL", new Cliente());
			}else if("pesquisar".equals(cmd)) {
				List<Cliente> listaTemporaria = new ArrayList<>();
				for(Cliente cliente : lista) {
					if(cliente.getCpf().contains(c.getCpf())) {
						listaTemporaria.add(cliente);
					}
				}
				mv.addObject("LISTA_CLIENTE", listaTemporaria);
				mv.addObject("CLIENTE_ATUAL", c);
			}
		}		
		return mv;
	}
	
}
