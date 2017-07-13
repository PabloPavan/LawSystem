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
public class Agenda {

    private String id_agenda;
    private String data_agenda;
    private String hora_agenda;
    private String atividade_agenda;
    private String id_processo;
    private String id_grupo;

    public Agenda() {
    }

    public Agenda(String id_agenda, String data_agenda, String hora_agenda, String atividade_agenda, String id_processo, String id_grupo) {
        this.id_agenda = id_agenda;
        this.data_agenda = data_agenda;
        this.hora_agenda = hora_agenda;
        this.atividade_agenda = atividade_agenda;
        this.id_processo = id_processo;
        this.id_grupo = id_grupo;
    }

    public String getId_grupo() {
        return id_grupo;
    }

    public void setId_grupo(String id_grupo) {
        this.id_grupo = id_grupo;
    }

    public String getId_agenda() {
        return id_agenda;
    }

    public void setId_agenda(String id_agenda) {
        this.id_agenda = id_agenda;
    }

    public String getData_agenda() {
        return data_agenda;
    }

    public void setData_agenda(String data_agenda) {
        this.data_agenda = data_agenda;
    }

    public String getHora_agenda() {
        return hora_agenda;
    }

    public void setHora_agenda(String hora_agenda) {
        this.hora_agenda = hora_agenda;
    }

    public String getAtividade_agenda() {
        return atividade_agenda;
    }

    public void setAtividade_agenda(String atividade_agenda) {
        this.atividade_agenda = atividade_agenda;
    }

    public String getId_processo() {
        return id_processo;
    }

    public void setId_processo(String id_processo) {
        this.id_processo = id_processo;
    }

}
