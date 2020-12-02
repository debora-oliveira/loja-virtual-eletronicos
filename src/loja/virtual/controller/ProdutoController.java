package loja.virtual.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
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

import loja.virtual.db.ProdutoDAO;
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
			List<Produto> listaTemporaria = new LinkedList<>();
			if("adicionar".equals(cmd)) {
				insereProduto(p);
				lista.add(p);
				listaTemporaria = pesquisaTodosProdutos();
				System.out.printf("Produto adicionado, agora "
						+ "há %d produtos na lista%n", lista.size());
				mv.addObject("PRODUTO_ATUAL", new Produto());
			}else if("pesquisar".equals(cmd)) {
				if (p.getNome() == "") {
					listaTemporaria = pesquisaTodosProdutos();					
				} else {
					listaTemporaria = pesquisaProduto(p.getNome());		
				}
				
			}
			mv.addObject("LISTA_PRODUTO", listaTemporaria);
			mv.addObject("PRODUTO_ATUAL", p);
		}		
		
		return mv;
	}
	
	public void insereProduto(Produto produto) {
		ProdutoDAO produtoCAD;
		try {
			produtoCAD = new ProdutoDAO();
			produtoCAD.InsereProduto(produto);
			System.out.println("Cadastro de produto realizado!");
		} catch (ClassNotFoundException e) {
			System.out.println("Classe não encontrada!");
			System.out.println(e);
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Erro de SQL!");
			System.out.println(e);
			e.printStackTrace();
		}
	}
	
	public List<Produto> pesquisaTodosProdutos(){
		ProdutoDAO produtosPesquisados;
		try {
			produtosPesquisados = new ProdutoDAO();
			lista = produtosPesquisados.PesquisaTodosProdutos();
			
		} catch (ClassNotFoundException e) {
			System.out.println("Classe não encontrada!");
			System.out.println(e);
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Erro de SQL na tela!");
			System.out.println(e);
			e.printStackTrace();
		}
		System.out.println("Pesquisa de produtos feita com sucesso!");
		return lista;
	}
	
	public List<Produto> pesquisaProduto(String nome){
		ProdutoDAO produtosPesquisados;
		try {
			produtosPesquisados = new ProdutoDAO();
			lista = produtosPesquisados.PesquisaProduto(nome);
			
		} catch (ClassNotFoundException e) {
			System.out.println("Classe não encontrada!");
			System.out.println(e);
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Erro de SQL na tela!");
			System.out.println(e);
			e.printStackTrace();
		}
		System.out.println("Pesquisa de produtos feita com sucesso!");
		return lista;
	}
}
