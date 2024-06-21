package com.example.project.controller;

import com.example.project.services.EstoqueServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
}
