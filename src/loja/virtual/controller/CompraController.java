package loja.virtual.controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.servlet.ModelAndView;

import loja.virtual.model.Compra;

public class CompraController {
	@Autowired
	private List<Compra> lista;
	
	@Bean
	@ApplicationScope
	public List<Compra> listaCompras(){
		return new ArrayList<>();
	}
	
	@GetMapping("/")
	public ModelAndView getCompra() {
		ModelAndView mv = new ModelAndView("compra");
		Compra c = new Compra();
		mv.addObject("LISTA_COMPRA",lista);
		mv.addObject("COMPRAS_ATUAL",c);
		return mv;
	}
	
	@PostMapping("/compra")
	public ModelAndView postCompra(@Valid Compra c,BindingResult result,
			@RequestParam("cmd") String cmd) {
		
		ModelAndView mv = new ModelAndView("compra");
		mv.addObject("LISTA_COMPRA",lista);
		if(!result.hasErrors()) {
			List<Compra> listaTemporaria = new LinkedList<>();
		}
		return mv;
	}
	
	
}
