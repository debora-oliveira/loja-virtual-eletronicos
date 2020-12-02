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

import loja.virtual.model.Endereco;


@Controller
public class EnderecoController {
	
	@Autowired
	private List<Endereco> lista;
	
	@Bean
	@ApplicationScope
	public List<Endereco> listaEnderecos(){
		return new ArrayList<>();
	}
	
	@GetMapping("/endereco")
	public ModelAndView getEndereco(){
		ModelAndView mv = new ModelAndView("endereco");
		Endereco p = new Endereco();
		mv.addObject("LISTA_ENDERECO", lista);
		mv.addObject("ENDERECO_ATUAL", p);
		return mv;
	}
	@PostMapping("/endereco")
	public ModelAndView postEndereco(
			@ModelAttribute("ENDERECO_ATUAL") @Valid Endereco e, 
			BindingResult result, @RequestParam("cmd") String cmd){
		ModelAndView mv = new ModelAndView("endereco");
		mv.addObject("LISTA_ENDERECO", lista);
		if(! result.hasErrors()) {
			if("adicionar".equals(cmd)) {
				lista.add(e);
				System.out.printf("Endereco adicionado, agora "
						+ "há %d enderecos na lista%n", lista.size());
				mv.addObject("ENDERECO_ATUAL", new Endereco());
			}else if("pesquisar".equals(cmd)) {
				List<Endereco> listaTemporaria = new ArrayList<>();
				for(Endereco endereco : lista) {
					if(endereco.getCep().contains(e.getCep())) {
						listaTemporaria.add(endereco);
					}
				}
				mv.addObject("LISTA_ENDERECO", listaTemporaria);
				mv.addObject("ENDERECO_ATUAL", e);
			}
		}		
		return mv;
	}
}
