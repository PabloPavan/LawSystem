/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.em.pojo;

/**
 *
 * @author pablo
 */
public class Anexo {

    private String id_anexo;
    private String nome_anexo;
    private String caminho_anexo;
    private String id_relatorio;

    public Anexo() {
    }

    public Anexo(String id_anexo, String nome_anexo, String caminho_anexo, String id_relatorio) {
        this.id_anexo = id_anexo;
        this.nome_anexo = nome_anexo;
        this.caminho_anexo = caminho_anexo;
        this.id_relatorio = id_relatorio;
    }

    public String getId_anexo() {
        return id_anexo;
    }

    public void setId_anexo(String id_anexo) {
        this.id_anexo = id_anexo;
    }

    public String getNome_anexo() {
        return nome_anexo;
    }

    public void setNome_anexo(String nome_anexo) {
        this.nome_anexo = nome_anexo;
    }

    public String getCaminho_anexo() {
        return caminho_anexo;
    }

    public void setCaminho_anexo(String caminho_anexo) {
        this.caminho_anexo = caminho_anexo;
    }

    public String getId_relatorio() {
        return id_relatorio;
    }

    public void setId_relatorio(String id_relatorio) {
        this.id_relatorio = id_relatorio;
    }
}
