package com.example.project.controller;

import com.example.project.entities.Estoque;
import com.example.project.services.EstoqueServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EstoqueController {
    private final EstoqueServices estoqueServices;

    public EstoqueController(EstoqueServices estoqueServices) {
        super();
        this.estoqueServices = estoqueServices;
    }

    @GetMapping("/estoque")
    public String listEstoque(Model model){
        model.addAttribute("estoque",estoqueServices.findAll());
        return "estoque";
    }

    @GetMapping("/estoque/new")
    public String createProdutoForm(Model model){
        Estoque estoque = new Estoque();
        model.addAttribute("estoque", estoque);
        return "create_produto";
    }


    @PostMapping("/estoque")
    public String saveProduto(@ModelAttribute("estoque")Estoque estoque){
        estoqueServices.saveProduto(estoque);
        return "redirect:/estoque";
    }
}
