package com.example.project;

import com.example.project.entities.Estoque;
import com.example.project.repository.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}


	@Autowired
	private EstoqueRepository estoqueRepository;
	@Override
	public void run(String... args) throws Exception {
		/*Estoque produto1 = new Estoque("teste1",1,1);
		Estoque produto2 = new Estoque("teste2",2,2);
		Estoque produto3 = new Estoque("teste3",3,3);
		estoqueRepository.save(produto1);
		estoqueRepository.save(produto2);
		estoqueRepository.save(produto3);*/


	}
}
