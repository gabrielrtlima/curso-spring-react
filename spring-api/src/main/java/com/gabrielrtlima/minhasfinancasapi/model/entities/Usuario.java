package com.gabrielrtlima.minhasfinancasapi.model.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table (name = "usuario")
@Data
public class Usuario {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "senha")
    private String senha;


}