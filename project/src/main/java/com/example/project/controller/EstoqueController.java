package com.example.project.controller;

import com.example.project.entities.Estoque;
import com.example.project.services.EstoqueServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/estoque/edit/{id}")
    public String editProdutoForm(@PathVariable long id,Model model){
        model.addAttribute("estoque",estoqueServices.getById(id));
        return "edit_estoque";
    }

    @PostMapping("/estoque/{id}")
    public String updateEstoque(@PathVariable Long id, @ModelAttribute("estoque")Estoque estoque, Model model){

        //pegar o produto no banco de dados pelo id
        Estoque produtoExistente = estoqueServices.getById(id);
        produtoExistente.setId(estoque.getId());
        produtoExistente.setNome(estoque.getNome());
        produtoExistente.setPreco(estoque.getPreco());
        produtoExistente.setQuantidade(estoque.getQuantidade());

        estoqueServices.updateEstoque(produtoExistente);
        return "redirect:/estoque";
    }

    @PostMapping("/estoque/adicionar/{id}")
    public String adicionaUm(@PathVariable Long id, @ModelAttribute("estoque")Estoque estoque, Model model){

        //pegar o produto no banco de dados pelo id
        Estoque produtoExistente = estoqueServices.getById(id);

        produtoExistente.setQuantidade(produtoExistente.getQuantidade()+1);

        estoqueServices.updateEstoque(produtoExistente);
        return "redirect:/estoque";
    }

    @PostMapping("/estoque/remove/{id}")
    public String removeUm(@PathVariable Long id, @ModelAttribute("estoque")Estoque estoque, Model model){

        //pegar o produto no banco de dados pelo id
        Estoque produtoExistente = estoqueServices.getById(id);

        produtoExistente.setQuantidade(produtoExistente.getQuantidade()-1);
        if (produtoExistente.getQuantidade()<0){
            produtoExistente.setQuantidade(0);
        }

        estoqueServices.updateEstoque(produtoExistente);
        return "redirect:/estoque";
    }

}
