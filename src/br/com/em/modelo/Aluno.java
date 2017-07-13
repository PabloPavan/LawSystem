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
public class Aluno {

    private Pessoa p = new Pessoa();
    private String id_aluno;
    private String rg_aluno;
    private String anoSemestre_aluno;
    private String id_grupo;
    private boolean inativo_aluno;

    public Pessoa getP() {
        return p;
    }

    public void setP(Pessoa p) {
        this.p = p;
    }

    public String getId_aluno() {
        return id_aluno;
    }

    public void setId_aluno(String id_aluno) {
        this.id_aluno = id_aluno;
    }

    public String getRg_aluno() {
        return rg_aluno;
    }

    public void setRg_aluno(String rg_aluno) {
        this.rg_aluno = rg_aluno;
    }

    public String getAnoSemestre_aluno() {
        return anoSemestre_aluno;
    }

    public void setAnoSemestre_aluno(String anoSemestre_aluno) {
        this.anoSemestre_aluno = anoSemestre_aluno;
    }

    public String getId_grupo() {
        return id_grupo;
    }

    public void setId_grupo(String id_grupo) {
        this.id_grupo = id_grupo;
    }

    public boolean isInativo_aluno() {
        return inativo_aluno;
    }

    public void setInativo_aluno(boolean inativo_aluno) {
        this.inativo_aluno = inativo_aluno;
    }
}
