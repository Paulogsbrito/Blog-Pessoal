package com.generation.blogpessoal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.blogpessoal.model.Postagem;
import com.generation.blogpessoal.repository.PostagemRepository;



@RestController // Receberá requisições compostas por: URL, método HTTP e o Objeto da requisição
@RequestMapping("/postagens") // mapeia as solicitações para os métodos da classe controladora | define tambem a URL
@CrossOrigin(origins = "*", allowedHeaders = "*") // indica que a Classe controladora permitirá o recebimento de requisições fora do dominio
public class PostagemController {
	
	@Autowired // Aqui é aplicada a inversão de controle  
	private PostagemRepository postagemRepository;
	
	
	@GetMapping
	public ResponseEntity<List<Postagem>> getAll(){
		return ResponseEntity.ok(postagemRepository.findAll());
	}
	

}
