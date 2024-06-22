package com.example.project.entities;


import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "estoque")
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome", nullable = false)
    private String nome;


    @Column(name = "quantidade", nullable = false)
    private int quantidade;


    @Column(name = "preco", nullable = false)
    private double preco;

    public Estoque() {
    }

    public Estoque(String nome, int quantidade, double preco) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }


}
