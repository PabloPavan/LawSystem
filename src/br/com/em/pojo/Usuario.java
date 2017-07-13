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
public class Usuario {

    private String id_usuario;
    private String login_usuario;
    private String senha_usuario;
    private boolean inativo_usuario;

    public Usuario() {
    }

    public Usuario(String id_usuario, String login_usuario, String senha_usuario, boolean inativo_usuario) {
        this.id_usuario = id_usuario;
        this.login_usuario = login_usuario;
        this.senha_usuario = senha_usuario;
        this.inativo_usuario = inativo_usuario;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getLogin_usuario() {
        return login_usuario;
    }

    public void setLogin_usuario(String login_usuario) {
        this.login_usuario = login_usuario;
    }

    public String getSenha_usuario() {
        return senha_usuario;
    }

    public void setSenha_usuario(String senha_usuario) {
        this.senha_usuario = senha_usuario;
    }

    public boolean isInativo_usuario() {
        return inativo_usuario;
    }

    public void setInativo_usuario(boolean inativo_usuario) {
        this.inativo_usuario = inativo_usuario;
    }

}
