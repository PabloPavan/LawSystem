/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.em.vo;

/**
 *
 * @author pablo esta classe é utilizada para criar um objeto de retorno dos
 * dados necessários para o funcionamento da tela de processo
 */
public class ProcessoVo {

    //dados do processo
    private String id_processo;
    private String nomeparte_processo;
    private String numero_processo;
    private String numeroPasta_processo;
    private String andamento_processo;
    private String acao_processo;
    private String id_cliente;
    private String id_vara;
    private String dataInicio_processo;
    private String dataFim_processo;
    private String diaSemana_processo;
    private String narrativa_processo;
    private String consulta_processo;
    private String obs_processo;

    //dados do cliente
    private String numero_cliente;
    
    //dados de pessoas
    private String nome_pessoa;
    private String sobrenome_pessoa;
    private String rg_pessoa;
    private String cpf_pessoa;

    public String getId_processo() {
        return id_processo;
    }

    public void setId_processo(String id_processo) {
        this.id_processo = id_processo;
    }

    public String getNomeparte_processo() {
        return nomeparte_processo;
    }

    public void setNomeparte_processo(String nomeparte_processo) {
        this.nomeparte_processo = nomeparte_processo;
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

    public String getNumero_cliente() {
        return numero_cliente;
    }

    public void setNumero_cliente(String numero_cliente) {
        this.numero_cliente = numero_cliente;
    }

    public String getNome_pessoa() {
        return nome_pessoa;
    }

    public void setNome_pessoa(String nome_pessoa) {
        this.nome_pessoa = nome_pessoa;
    }

    public String getSobrenome_pessoa() {
        return sobrenome_pessoa;
    }

    public void setSobrenome_pessoa(String sobrenome_pessoa) {
        this.sobrenome_pessoa = sobrenome_pessoa;
    }

    public String getRg_pessoa() {
        return rg_pessoa;
    }

    public void setRg_pessoa(String rg_pessoa) {
        this.rg_pessoa = rg_pessoa;
    }

    public String getCpf_pessoa() {
        return cpf_pessoa;
    }

    public void setCpf_pessoa(String cpf_pessoa) {
        this.cpf_pessoa = cpf_pessoa;
    }
}
