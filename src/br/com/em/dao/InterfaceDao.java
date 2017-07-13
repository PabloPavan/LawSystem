/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.em.dao;

import java.util.ArrayList;

/**
 *
 * @author pablo
 * @param <T> Passe o Objeto referente ao DAO Implmentes
 */
public interface InterfaceDao<T> {

    public void cadastrar(T obj);

    public void atualizar(T obj);

    public ArrayList<T> listar(String busca, String auxBusca);

}
