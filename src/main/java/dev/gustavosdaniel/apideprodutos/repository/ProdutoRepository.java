package dev.gustavosdaniel.apideprodutos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.gustavosdaniel.apideprodutos.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	List<Produto> findByName(String name); //PROCURE NA LISTA O NOME QUE FOI PESQUISADO
}
