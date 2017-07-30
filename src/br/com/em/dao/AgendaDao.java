/*
 * Copyright (C) 2017 pablo
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package br.com.em.dao;

import br.com.em.conexao.ModuloConexao;
import static br.com.em.main.JfTelaLogin.usuario;
import br.com.em.modelo.Agenda;
import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author pablo
 */
public class AgendaDao extends ModuloConexao implements InterfaceDao<Agenda> {

    @Override
    public void cadastrar(Agenda agenda) {
        try {

            java.sql.PreparedStatement pstmt = null;
            conexao = this.conector();
            conexao.setAutoCommit(false);
            String query1 = "INSERT INTO modelo_tb_agenda(data_agenda, hora_agenda, atividade_agenda, id_processo) VALUES (?, ?, ?, ?);";
            pstmt = this.conexao.prepareStatement(query1);

            //     pstmt.setString(1, processo.getNome_processo());
            pstmt.setString(1, agenda.getData_agenda());
            pstmt.setString(2, agenda.getHora_agenda());
            pstmt.setString(3, agenda.getAtividade_agenda());
            pstmt.setInt(4, Integer.valueOf(agenda.getId_processo()));

            pstmt.execute();

            conexao.commit();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
            Logger.getLogger(ClienteDao.class.getName()).log(Level.INFO, "Cadastrou | Agenda: {0} | Usuario: {1}", new Object[]{"", usuario});

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
    public void atualizar(Agenda agenda) {

         try {

            java.sql.PreparedStatement pstmt = null;
            conexao = this.conector();
            conexao.setAutoCommit(false);

            String query1 = ("UPDATE modelo_tb_agenda "
                    + "SET data_agenda=?, "
                    + "hora_agenda=?, "
                    + "atividade_agenda=?, "
                    + "id_processo=? "
                    + "WHERE "
                    + "id_agenda=?;");

            pstmt = this.conexao.prepareStatement(query1);

            pstmt.setString(1, agenda.getData_agenda());
            pstmt.setString(2, agenda.getHora_agenda());
            pstmt.setString(3, agenda.getAtividade_agenda());
            pstmt.setInt(4, Integer.valueOf(agenda.getId_processo()));
            pstmt.setInt(5, Integer.valueOf(agenda.getId_agenda()));

            pstmt.executeUpdate();

            conexao.commit();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso");
            Logger.getLogger(ClienteDao.class.getName()).log(Level.INFO, "Atualizou | Agenda: {0} | Usuario: {1}", new Object[]{agenda.getId_agenda(), usuario});

        } catch (SQLException | HeadlessException | NumberFormatException ex) {
            try {
                conexao.rollback();
                JOptionPane.showMessageDialog(null, "Não atualizado");
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
    public ArrayList<Agenda> listar(String busca, String auxBusca) {
     List lista = new ArrayList<>();
//
        ResultSet rs = null;

        java.sql.PreparedStatement pst = null;

        try {
            conexao = this.conector();

            if (busca.isEmpty()) {

                String sql = ("SELECT `id_agenda`, `data_agenda`, `hora_agenda`, `atividade_agenda`, `id_processo` "
                        + "FROM `emodelo`.`modelo_tb_agenda` order by data_agenda ASC; ");
                pst = this.conexao.prepareStatement(sql);
                
                }else{
                String sql = ("SELECT `id_agenda`, `data_agenda`, `hora_agenda`, `atividade_agenda`, `id_processo` "
                        + "FROM `emodelo`.`modelo_tb_agenda` where data_agenda like ? order by hora_agenda ASC; ");
                pst = this.conexao.prepareStatement(sql);
                pst.setString(1, "%" + busca + "%");
                }

                rs = pst.executeQuery();

                while (rs.next()) {
                    Agenda agenda = new Agenda();
                    agenda.setId_agenda(rs.getString(1));
                    agenda.setData_agenda(rs.getString(2));
                    agenda.setHora_agenda(rs.getString(3));                 
                    agenda.setAtividade_agenda(rs.getString(4));
                    agenda.setId_processo(rs.getString(5));
                  
                    lista.add(agenda);

                }
            

            this.close();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AgendaVoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return (ArrayList<Agenda>) lista;
    }

}
