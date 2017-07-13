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
public class ProcessoDao implements InterfaceDao{

    @Override
    public void cadastrar(Processo processo) {
      
    }

    @Override
    public void atualizar(Processo processo) {
      
    }

    @Override
    public ArrayList<Processo> listarProcesso(String nome, String t) {
        return null;
    
    }

    
    
    
    
    
    
    
    
    
    
   
    
    @Override
    public void cadastrar(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Cliente> listarCliente(String nome, String t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


   
    
}
