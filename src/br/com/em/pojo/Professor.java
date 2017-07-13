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
public class Professor {
    
    private Pessoa p = new Pessoa();
    private String id_professor;
    private String campus_professor;
    private boolean inativo_professor;

    public Pessoa getP() {
        return p;
    }

    public void setP(Pessoa p) {
        this.p = p;
    }

    public String getId_professor() {
        return id_professor;
    }

    public void setId_professor(String id_professor) {
        this.id_professor = id_professor;
    }

    public String getCampus_professor() {
        return campus_professor;
    }

    public void setCampus_professor(String campus_professor) {
        this.campus_professor = campus_professor;
    }

    public boolean isInativo_professor() {
        return inativo_professor;
    }

    public void setInativo_professor(boolean inativo_professor) {
        this.inativo_professor = inativo_professor;
    }
    
}
