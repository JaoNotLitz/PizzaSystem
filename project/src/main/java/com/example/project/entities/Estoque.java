package com.example.project.entities;


import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;


@Getter
@Entity
@Table(name="estoque")
public class Estoque {
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Setter
    @Column(name="nome",nullable = false)
    private String nome;

    @Setter
    @Column(name="quantidade",nullable = false)
    private int quantidade;



    @Setter
    @Column(name="preco",nullable = false)
    private double preco;

    public Estoque() {
    }

    public Estoque(String nome, int quantidade, double preco) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }



}
