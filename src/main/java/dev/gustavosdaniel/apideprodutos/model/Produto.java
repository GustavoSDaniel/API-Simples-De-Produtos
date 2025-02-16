package dev.gustavosdaniel.apideprodutos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "produtos_tb")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String descrition;
	private Double price;
	
	public Produto() {
		
	}
	
	public Produto(Long id, String name, String descrition, Double price) {
		super();
		this.id = id;
		this.name = name;
		this.descrition = descrition;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescrition() {
		return descrition;
	}

	public void setDescrition(String descrition) {
		this.descrition = descrition;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", name=" + name + ", descrition=" + descrition + ", price=" + price + "]"; //REPRESENTAÇÃP DO OBJETO EM STRING
	}
	
	
	
	
	
}
