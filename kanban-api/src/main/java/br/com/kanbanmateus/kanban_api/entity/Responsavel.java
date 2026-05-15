package br.com.kanbanmateus.kanban_api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "responsaveis_tb")
public class Responsavel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_responsavel")
    private Integer id;

    @Column(name = "NOME_COMPLETO", length = 100)
    private String nomeCompleto;

    @Column(name = "EMAIL", length = 100)
    private String email;

    @Column(name = "LOGIN", length = 50)
    private String login;

    @Column(name = "ATUACAO", length = 50)
    private String atuacao;

}