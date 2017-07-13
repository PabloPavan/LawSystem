/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.em.dao;

import br.com.em.pojo.Cliente;
import br.com.em.pojo.Processo;
import java.util.ArrayList;

/**
 *
 * @author pablo
 */
public interface InterfaceDao {
    
    public void cadastrar(Cliente cliente);
    
    public void atualizar(Cliente cliente);
    
    public ArrayList<Cliente> listarCliente(String nome, String t);
    
    public void cadastrar(Processo processo);
    
    public void atualizar(Processo processo);
    
    public ArrayList<Processo> listarProcesso(String nome, String t);
    
}
