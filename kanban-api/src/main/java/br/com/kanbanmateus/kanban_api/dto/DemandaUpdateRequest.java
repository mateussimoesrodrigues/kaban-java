package br.com.kanbanmateus.kanban_api.dto;

import java.time.LocalDate;

public class DemandaUpdateRequest {

    private String titulo;
    private String tipo;
    private String descricao;
    private LocalDate dataInicio;
    private LocalDate dataFimP;
    private LocalDate dataFimR;
    private String prioridade;
    private String status;
    private String segmento;
    private String segmentoDetalhe;
    private LocalDate dataCriacao;
    private String criadorDemanda;
    private Integer idResponsavel;

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

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFimP() {
        return dataFimP;
    }

    public void setDataFimP(LocalDate dataFimP) {
        this.dataFimP = dataFimP;
    }

    public LocalDate getDataFimR() {
        return dataFimR;
    }

    public void setDataFimR(LocalDate dataFimR) {
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

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getCriadorDemanda() {
        return criadorDemanda;
    }

    public void setCriadorDemanda(String criadorDemanda) {
        this.criadorDemanda = criadorDemanda;
    }

    public Integer getIdResponsavel() {
        return idResponsavel;
    }

    public void setIdResponsavel(Integer idResponsavel) {
        this.idResponsavel = idResponsavel;
    }
}