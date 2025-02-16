package dev.gustavosdaniel.apideprodutos.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.gustavosdaniel.apideprodutos.model.Produto;
import dev.gustavosdaniel.apideprodutos.repository.ProdutoRepository;

@RestController // RECEBE REQUISIÇÕES
@RequestMapping("/produtos") // INDICA AS URL QUE VAI RECEBER AS REQUISIÇÕES
public class ProdutosController {
	
	
	private ProdutoRepository produtoRepository; // INJETANDO O REPOSITORIO PARA FAZER A CONECÇÃO
	
	
	public ProdutosController(ProdutoRepository produtoRepository) { // CRIANDO UM CONSTRUTOR PARA PODER TER ACESSO AO REPOSITORIO
		super();
		this.produtoRepository = produtoRepository;
	}


	@PostMapping //CADASTRAR DADOS(ADICIONAR DADOS)
	public Produto salvar(@RequestBody Produto produto) { //O REQUESTBODY SERVE PARA RECEBER AS INFORMAÇÕES DO ARGUMENTO NESSE CASO O PRODUTO
		System.out.println("Produto recebido" + produto);
		Long id = produto.getId(); //  ACESSEI O ID DO PRODUTO
		produto.setId(id); // INSERI ELE
		produtoRepository.save(produto); //USANDO O REPOSITORIO PARA QUE POSSA SER SALVO NO BANCO DE DADOS
		return produto;
	}
	
	@GetMapping("/{id}")
	public Produto pesquisarPorId(@PathVariable("id") Long id) { // INDICA QUE ALEM DOS PRODUTO TEM QUE PESQUISA O ID NESSE CASO
		return produtoRepository.findById(id).orElse(null);
	}
	
	@DeleteMapping("/{id}")
	public void deletandoPorId(@PathVariable("id") Long id) {
		
		produtoRepository.deleteById(id);
		
	}
	
	@PutMapping("/{id}") // PUT SERVE PARA ATUALIZAR
	public void atualizarProduto(@PathVariable("id") Long id, @RequestBody Produto produto ) { // PARA ATUALIZAR EU TENHO QUE PASSAR TANTO O ID COMO O CONTEUDO DO PRODUTO QUE QUERO ATUALIZAR
		
		produto.setId(id); // EU TENHO QUE CHAMAR O ID PQ ELE NÃO VEM NO CORPO DO SITENS JA QUE O ID GERA AUTOMATICO E TBM IDENTIFICA QUAL O PRODUTO EU QUERO ATUALIZAR
		produtoRepository.save(produto);
	}
	
	@GetMapping
	public List<Produto> buscarPorProdutos(@RequestParam("name") String name) { //NO CASO O @REQUESTPARAM É UM PARAMETRO PARA BUSCAR POR NOME
		return produtoRepository.findByName(name);
	}
	
}
