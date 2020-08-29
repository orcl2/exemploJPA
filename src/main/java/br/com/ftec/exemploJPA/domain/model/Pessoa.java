package br.com.ftec.exemploJPA.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


//Pela anotação @Entity informamos o nome correspondente da nossa tabela
@Entity(name = "PESSOA")
public class Pessoa {

	//Teremos no atributo Id nossa chave primária da tabela, 
	//que será auto incrementada ao usar a anotação @GeneratedValue
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	
	public Long getId() { return id; } 
	public void setId(Long id) { this.id = id;}
	public String getNome() { return nome; } 
	public void setNome(String nome) { this.nome = nome; }
	
	
	
}
