package com.example.project.services;
import com.example.project.entities.Estoque;
import com.example.project.repository.EstoqueRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EstoqueServices {
    private EstoqueRepository repository;

    @Autowired
    public EstoqueServices(EstoqueRepository repository) {
        this.repository = repository;
    }

    public List<Estoque> findAll(){
        return repository.findAll();
    }

    public Estoque getById(Long id){
        return repository.findById(id).get();
    }
    public Estoque updateEstoque (Estoque estoque){
        return repository.save(estoque);
    }
}
