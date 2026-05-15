package br.com.kanbanmateus.kanban_api.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "sub_demandas_tb")
public class SubDemanda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sub_demanda")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_demanda", nullable = false)
    private Demanda demanda;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_responsavel", nullable = false)
    private Responsavel responsavel;

    @Column(name = "TAREFA", length = 100)
    private String tarefa;

    @Column(name = "DATA_INICIO")
    private LocalDateTime dataInicio;

    @Column(name = "DATA_FIM_P")
    private LocalDateTime dataFimP;

    @Column(name = "DATA_FIM_R")
    private LocalDateTime dataFimR;

    @Column(name = "OBSERVACAO", columnDefinition = "TEXT")
    private String observacao;

    @Column(name = "STATUS", length = 50)
    private String status;

}
