package com.generation.blogpessoal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.data.repository.query.Param;


import com.generation.blogpessoal.model.Postagem;

// extends herda as funcionalidades de uma outra Classe ou Interface
// <> = indica a tabela que iremos trabalhar com a JPA
public interface PostagemRepository extends JpaRepository<Postagem, Long> {
	
	public List <Postagem> findAllByTituloContainingIgnoreCase(@PathVariable("titulo") String titulo);

}


