package br.com.kanbanmateus.kanban_api.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "demandas_tb")
public class Demanda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_demanda")
    private Integer id;

    @Column(name = "TITULO", length = 100)
    private String titulo;

    @Column(name = "TIPO", length = 50)
    private String tipo;

    @Column(name = "DESCRICAO", columnDefinition = "TEXT")
    private String descricao;

    @Column(name = "DATA_INICIO")
    private LocalDateTime dataInicio;

    @Column(name = "DATA_FIM_P")
    private LocalDateTime dataFimP;

    @Column(name = "DATA_FIM_R")
    private LocalDateTime dataFimR;

    @Column(name = "PRIORIDADE", length = 50)
    private String prioridade;

    @Column(name = "STATUS", length = 50)
    private String status;

    @Column(name = "SEGMENTO", length = 50)
    private String segmento;

    @Column(name = "SEGMENTO_DETALHE", length = 100)
    private String segmentoDetalhe;

    @Column(name = "DATA_CRIACAO")
    private LocalDateTime dataCriacao;

    @Column(name = "CRIADOR_DEMANDA", length = 100)
    private String criadorDemanda;

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDateTime getDataFimP() {
        return dataFimP;
    }

    public void setDataFimP(LocalDateTime dataFimP) {
        this.dataFimP = dataFimP;
    }

    public LocalDateTime getDataFimR() {
        return dataFimR;
    }

    public void setDataFimR(LocalDateTime dataFimR) {
        this.dataFimR = dataFimR;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSegmento() {
        return segmento;
    }

    public void setSegmento(String segmento) {
        this.segmento = segmento;
    }

    public String getSegmentoDetalhe() {
        return segmentoDetalhe;
    }

    public void setSegmentoDetalhe(String segmentoDetalhe) {
        this.segmentoDetalhe = segmentoDetalhe;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getCriadorDemanda() {
        return criadorDemanda;
    }

    public void setCriadorDemanda(String criadorDemanda) {
        this.criadorDemanda = criadorDemanda;
    }
}