/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.em.relatorio;

import br.com.em.conexao.ModuloConexao;
import java.io.File;
import java.sql.SQLException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author pablo
 */
public class RelatorioCliente extends ModuloConexao {

    public RelatorioCliente(Map parametros) {
        try {
            conexao = this.conector();
            JasperPrint impressao = JasperFillManager.fillReport("C:\\Users\\pablo\\cliente.jasper", parametros, conexao);
            JasperViewer viewer = new JasperViewer(impressao, false);
            viewer.show();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RelatorioCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RelatorioCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(RelatorioCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
