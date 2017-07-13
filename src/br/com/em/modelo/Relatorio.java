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
public class Relatorio {

    private String id_relatorio;
    private String data_relatorio;
    private String atividade_relatorio;
    private String id_grupo;
    private String id_processo;
    private String id_professor;

    public Relatorio() {
    }

    public Relatorio(String id_relatorio, String data_relatorio, String atividade_relatorio, String id_grupo, String id_processo, String id_professor) {
        this.id_relatorio = id_relatorio;
        this.data_relatorio = data_relatorio;
        this.atividade_relatorio = atividade_relatorio;
        this.id_grupo = id_grupo;
        this.id_processo = id_processo;
        this.id_professor = id_professor;
    }

    public String getId_professor() {
        return id_professor;
    }

    public void setId_professor(String id_professor) {
        this.id_professor = id_professor;
    }

    public String getId_relatorio() {
        return id_relatorio;
    }

    public void setId_relatorio(String id_relatorio) {
        this.id_relatorio = id_relatorio;
    }

    public String getData_relatorio() {
        return data_relatorio;
    }

    public void setData_relatorio(String data_relatorio) {
        this.data_relatorio = data_relatorio;
    }

    public String getAtividade_relatorio() {
        return atividade_relatorio;
    }

    public void setAtividade_relatorio(String atividade_relatorio) {
        this.atividade_relatorio = atividade_relatorio;
    }

    public String getId_grupo() {
        return id_grupo;
    }

    public void setId_grupo(String id_grupo) {
        this.id_grupo = id_grupo;
    }

    public String getId_processo() {
        return id_processo;
    }

    public void setId_processo(String id_processo) {
        this.id_processo = id_processo;
    }

}
