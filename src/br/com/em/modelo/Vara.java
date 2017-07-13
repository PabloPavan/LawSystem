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
public class Vara {

    private String id_vara;
    private String nome_vara;
    private String juiz_vara;
    private String rua_vara;
    private String numero_vara;
    private String complemento_vara;
    private String bairro_vara;
    private String cep_vara;
    private String cidade_vara;
    private String estado_vara;
    private String telefone_vara;
    private String email_vara;

    public Vara() {
    }

    public Vara(String id_vara, String nome_vara, String juiz_vara, String rua_vara, String numero_vara, String complemento_vara, String bairro_vara, String cep_vara, String cidade_vara, String estado_vara, String telefone_vara, String email_vara) {
        this.id_vara = id_vara;
        this.nome_vara = nome_vara;
        this.juiz_vara = juiz_vara;
        this.rua_vara = rua_vara;
        this.numero_vara = numero_vara;
        this.complemento_vara = complemento_vara;
        this.bairro_vara = bairro_vara;
        this.cep_vara = cep_vara;
        this.cidade_vara = cidade_vara;
        this.estado_vara = estado_vara;
        this.telefone_vara = telefone_vara;
        this.email_vara = email_vara;
    }

    public String getId_vara() {
        return id_vara;
    }

    public void setId_vara(String id_vara) {
        this.id_vara = id_vara;
    }

    public String getNome_vara() {
        return nome_vara;
    }

    public void setNome_vara(String nome_vara) {
        this.nome_vara = nome_vara;
    }

    public String getJuiz_vara() {
        return juiz_vara;
    }

    public void setJuiz_vara(String juiz_vara) {
        this.juiz_vara = juiz_vara;
    }

    public String getRua_vara() {
        return rua_vara;
    }

    public void setRua_vara(String rua_vara) {
        this.rua_vara = rua_vara;
    }

    public String getNumero_vara() {
        return numero_vara;
    }

    public void setNumero_vara(String numero_vara) {
        this.numero_vara = numero_vara;
    }

    public String getComplemento_vara() {
        return complemento_vara;
    }

    public void setComplemento_vara(String complemento_vara) {
        this.complemento_vara = complemento_vara;
    }

    public String getBairro_vara() {
        return bairro_vara;
    }

    public void setBairro_vara(String bairro_vara) {
        this.bairro_vara = bairro_vara;
    }

    public String getCep_vara() {
        return cep_vara;
    }

    public void setCep_vara(String cep_vara) {
        this.cep_vara = cep_vara;
    }

    public String getCidade_vara() {
        return cidade_vara;
    }

    public void setCidade_vara(String cidade_vara) {
        this.cidade_vara = cidade_vara;
    }

    public String getEstado_vara() {
        return estado_vara;
    }

    public void setEstado_vara(String estado_vara) {
        this.estado_vara = estado_vara;
    }

    public String getTelefone_vara() {
        return telefone_vara;
    }

    public void setTelefone_vara(String telefone_vara) {
        this.telefone_vara = telefone_vara;
    }

    public String getEmail_vara() {
        return email_vara;
    }

    public void setEmail_vara(String email_vara) {
        this.email_vara = email_vara;
    }
}
