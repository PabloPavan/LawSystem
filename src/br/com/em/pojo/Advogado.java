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
public class Advogado {
    private Pessoa p = new Pessoa();
    private String id_advogado;
    private String oab_advogado;

    public Pessoa getP() {
        return p;
    }

    public void setP(Pessoa p) {
        this.p = p;
    }

    public String getId_advogado() {
        return id_advogado;
    }

    public void setId_advogado(String id_advogado) {
        this.id_advogado = id_advogado;
    }

    public String getOab_advogado() {
        return oab_advogado;
    }

    public void setOab_advogado(String oab_advogado) {
        this.oab_advogado = oab_advogado;
    }
    
}
