package com.generation.blogpessoal.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity // Define que a Classe Postagem vai se tornar uma tabela 
@Table(name = "tb_postagens") // aqui vai o nome da tabela que siga a nomenclatura da Classe 
public class Postagem {
	
	@Id // Define a chave primara no Banco de Dados (Primary Key) 
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 1° - Define no Banco de Dados o campo que deve ser preenchido  || 2° - Define a forma como é preenchido (auto encrementado)  
	private Long id; // bigint = no MySQL 
		
	// id bigint PRIMARY KEY AUTO_INCREMENT
	
	// NOT BLANC - NÃO É PERMITIDO VALOR "VAZIO" 
	@NotBlank(message = "O atributo título é obrigatório!")
	// CASO O USUARIO TENTE PROSSEGUIR SEM O TITULO A MSG ABAIXO SERA EXIBIDA 
	@Size(min = 5, max = 100, message = "O atributo título deve ter no minimo 5 e no máximo 100 caracteres.")
	private String titulo; 
	
	// titulo VARCHAR(100) NOT NULL | ["T"] = SE O USUARIO COLOCAR UM TITULO COM UMA LETRA SÓ A MSG TAMBEM SERÁ EXIBIDA
	
	@NotBlank(message = "O atributo texto é obrigatório!")
	@Size(min = 10, max = 1000, message = "O atributo texto deve ter no minimo 10 e no máximo 1000 caracteres.")
	private String texto;
	
	// titulo VARCHAR(1000) NOT NULL | ["texto..."]
	
	@UpdateTimestamp // Banco de Dados que preenche o campo e o atualiza, no caso da data
	private LocalDateTime data;
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Tema tema;

	
// metodos construtores 
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}
	
	

}
