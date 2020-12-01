package loja.virtual.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.servlet.ModelAndView;

import loja.virtual.model.Produto;

@Controller
public class ProdutoController {
	
	@Autowired
	private List<Produto> lista;
	
	@Bean
	@ApplicationScope
	public List<Produto> listaProdutos(){
		return new ArrayList<>();
	}
	
	@GetMapping("/produto")
	public ModelAndView getProduto(){
		ModelAndView mv = new ModelAndView("produto");
		Produto p = new Produto();
		mv.addObject("LISTA_PRODUTO", lista);
		mv.addObject("PRODUTO_ATUAL", p);
		return mv;
	}
	@PostMapping("/produto")
	public ModelAndView postProduto(
			@ModelAttribute("CONTATO_ATUAL") @Valid Produto p, 
			BindingResult result, @RequestParam("cmd") String cmd){
		ModelAndView mv = new ModelAndView("produto");
		mv.addObject("LISTA_PRODUTO", lista);
		if(! result.hasErrors()) {
			if("adicionar".equals(cmd)) {
				lista.add(p);
				System.out.printf("Produto adicionado, agora "
						+ "há %d produtos na lista%n", lista.size());
				mv.addObject("PRODUTO_ATUAL", new Produto());
			}else if("pesquisar".equals(cmd)) {
				List<Produto> listaTemporaria = new ArrayList<>();
				for(Produto produto : lista) {
					if(produto.getNome().contains(p.getNome())) {
						listaTemporaria.add(produto);
					}
				}
				mv.addObject("LISTA_PRODUTO", listaTemporaria);
				mv.addObject("PRODUTO_ATUAL", p);
			}
		}		
		
		return mv;
	}
}
