/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.em.dao;

import br.com.em.conexao.ModuloConexao;
import static br.com.em.main.JfTelaLogin.usuario;
import br.com.em.modelo.Processo;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author pablo
 */
public class ProcessoDao extends ModuloConexao implements InterfaceDao<Processo> {

    @Override

    public void cadastrar(Processo processo) {

        try {

            java.sql.PreparedStatement pstmt = null;
            conexao = this.conector();
            conexao.setAutoCommit(false);
            String query1 = "Insert into modelo_tb_processo values(default,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pstmt = this.conexao.prepareStatement(query1);

            pstmt.setString(1, processo.getNome_processo());
            pstmt.setString(2, processo.getNumero_processo());
            pstmt.setString(3, processo.getNumeroPasta_processo());
            pstmt.setString(4, processo.getAndamento_processo());
            pstmt.setString(5, processo.getAcao_processo());
            pstmt.setInt(6, Integer.parseInt(processo.getId_cliente()));
            pstmt.setInt(7, Integer.parseInt(processo.getId_processo()));
            pstmt.setString(8, processo.getDataInicio_processo());
            pstmt.setString(9, processo.getDataFim_processo());
            pstmt.setString(10, processo.getDiaSemana_processo());
            pstmt.setString(11, processo.getNarrativa_processo());
            pstmt.setString(12, processo.getConsulta_processo());
            pstmt.setString(13, processo.getObs_processo());

            pstmt.execute();

            conexao.commit();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
            Logger.getLogger(ClienteDao.class.getName()).log(Level.INFO, "Cadastrou | Processo: {0} | Usuario: {1}", new Object[]{"", usuario});

        } catch (SQLException | HeadlessException | NumberFormatException ex) {
            try {
                conexao.rollback();
                JOptionPane.showMessageDialog(null, "Não cadastrado");
            } catch (SQLException ex1) {
                Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex1);
                
            }
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
         
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            conexao.setAutoCommit(true);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            this.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void atualizar(Processo obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Processo> listar(String busca, String auxBusca) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}


