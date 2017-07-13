/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.em.modelo;

/**
 *
 * @author pablo
 */
public class Processo {

    private String id_processo;
    private String nome_processo;
    private String numero_processo;
    private String numeroPasta_processo;
    private String andamento_processo;
    private String acao_processo;
    private String id_cliente;
    private String id_advogado;
    private String id_vara;
    private String dataInicio_processo;
    private String dataFim_processo;
    private String diaSemana_processo;
    private String narrativa_processo;
    private String consulta_processo;
    private String obs_processo;

    public Processo(String id_processo, String nome_processo, String numero_processo, String numeroPasta_processo, String andamento_processo, String acao_processo, String id_cliente, String id_advogado, String id_vara, String dataInicio_processo, String dataFim_processo, String diaSemana_processo, String narrativa_processo, String consulta_processo, String obs_processo) {
        this.id_processo = id_processo;
        this.nome_processo = nome_processo;
        this.numero_processo = numero_processo;
        this.numeroPasta_processo = numeroPasta_processo;
        this.andamento_processo = andamento_processo;
        this.acao_processo = acao_processo;
        this.id_cliente = id_cliente;
        this.id_advogado = id_advogado;
        this.id_vara = id_vara;
        this.dataInicio_processo = dataInicio_processo;
        this.dataFim_processo = dataFim_processo;
        this.diaSemana_processo = diaSemana_processo;
        this.narrativa_processo = narrativa_processo;
        this.consulta_processo = consulta_processo;
        this.obs_processo = obs_processo;
    }

    public String getNome_processo() {
        return nome_processo;
    }

    public void setNome_processo(String nome_processo) {
        this.nome_processo = nome_processo;
    }

    public String getDiaSemana_processo() {
        return diaSemana_processo;
    }

    public void setDiaSemana_processo(String diaSemana_processo) {
        this.diaSemana_processo = diaSemana_processo;
    }

    public String getNarrativa_processo() {
        return narrativa_processo;
    }

    public void setNarrativa_processo(String narrativa_processo) {
        this.narrativa_processo = narrativa_processo;
    }

    public String getConsulta_processo() {
        return consulta_processo;
    }

    public void setConsulta_processo(String consulta_processo) {
        this.consulta_processo = consulta_processo;
    }

    public String getObs_processo() {
        return obs_processo;
    }

    public void setObs_processo(String obs_processo) {
        this.obs_processo = obs_processo;
    }

    public Processo() {
    }

    public String getId_processo() {
        return id_processo;
    }

    public void setId_processo(String id_processo) {
        this.id_processo = id_processo;
    }

    public String getNumero_processo() {
        return numero_processo;
    }

    public void setNumero_processo(String numero_processo) {
        this.numero_processo = numero_processo;
    }

    public String getNumeroPasta_processo() {
        return numeroPasta_processo;
    }

    public void setNumeroPasta_processo(String numeroPasta_processo) {
        this.numeroPasta_processo = numeroPasta_processo;
    }

    public String getAndamento_processo() {
        return andamento_processo;
    }

    public void setAndamento_processo(String andamento_processo) {
        this.andamento_processo = andamento_processo;
    }

    public String getAcao_processo() {
        return acao_processo;
    }

    public void setAcao_processo(String acao_processo) {
        this.acao_processo = acao_processo;
    }

    public String getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getId_advogado() {
        return id_advogado;
    }

    public void setId_advogado(String id_advogado) {
        this.id_advogado = id_advogado;
    }

    public String getId_vara() {
        return id_vara;
    }

    public void setId_vara(String id_vara) {
        this.id_vara = id_vara;
    }

    public String getDataInicio_processo() {
        return dataInicio_processo;
    }

    public void setDataInicio_processo(String dataInicio_processo) {
        this.dataInicio_processo = dataInicio_processo;
    }

    public String getDataFim_processo() {
        return dataFim_processo;
    }

    public void setDataFim_processo(String dataFim_processo) {
        this.dataFim_processo = dataFim_processo;
    }
}
