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
import br.com.em.modelo.PeticoesIniciais;
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
public class PeticoesIniciaisDao extends ModuloConexao implements InterfaceDao<PeticoesIniciais> {

    @Override
    public void cadastrar(PeticoesIniciais pi) {

        try {

            java.sql.PreparedStatement pstmt = null;
            conexao = this.conector();
            conexao.setAutoCommit(false);
            String query1 = "INSERT INTO modelo_tb_peticoesIniciais VALUES (default, ?, ?, ?);";
            pstmt = this.conexao.prepareStatement(query1);

            pstmt.setString(1, pi.getData_peticoesIniciais());
            pstmt.setInt(2, Integer.valueOf(pi.getId_cliente()));
            pstmt.setInt(3, Integer.valueOf(pi.getId_processo()));

            pstmt.execute();

            conexao.commit();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
            Logger.getLogger(ClienteDao.class.getName()).log(Level.INFO, "Cadastrou | Petiçoes Iniciais : {0} | Usuario: {1}", new Object[]{"", usuario});

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
    public void atualizar(PeticoesIniciais pi) {
        try {

            java.sql.PreparedStatement pstmt = null;
            conexao = this.conector();
            conexao.setAutoCommit(false);

            String query1 = ("UPDATE modelo_tb_peticoesIniciais SET "
                    + "data_peticoesIniciais=?, "
                    + "id_cliente=?, "
                    + "id_processo=? "
                    + "WHERE  "
                    + "id_peticoesIniciais=?;");

            pstmt = this.conexao.prepareStatement(query1);

            pstmt.setString(1, pi.getData_peticoesIniciais());
            pstmt.setInt(2, Integer.valueOf(pi.getId_cliente()));
            pstmt.setInt(3, Integer.valueOf(pi.getId_processo()));
            pstmt.setInt(4, Integer.valueOf(pi.getId_peticoesIniciais()));

            pstmt.executeUpdate();

            conexao.commit();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso");
            Logger.getLogger(ClienteDao.class.getName()).log(Level.INFO, "Atualizou | Petições Iniciais: {0} | Usuario: {1}", new Object[]{pi.getId_peticoesIniciais(), usuario});

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
    public ArrayList<PeticoesIniciais> listar(String busca, String auxBusca) {
        List lista = new ArrayList<>();
//
        ResultSet rs = null;

        java.sql.PreparedStatement pst = null;

        try {
            conexao = this.conector();

            if (!busca.isEmpty()) {

                String sql = ("select pt.*, "
                        + "p.numero_processo, "
                        + "c.numero_cliente, "
                        + "p.acao_processo, "
                        + "p.numeroPasta_processo, "
                        + "pes.nome_pessoa, "
                        + "pes.sobrenome_pessoa "
                        + "from modelo_tb_peticoesIniciais pt "
                        + "join modelo_tb_processo p on pt.id_processo = p.id_processo "
                        + "join modelo_tb_cliente c on pt.id_cliente = c.id_cliente "
                        + "join modelo_tb_pessoa pes on pes.id_pessoa = c.id_pessoa "
                        + "where "
                        + "pt.data_peticoesIniciais like ?");

                pst = this.conexao.prepareStatement(sql);
                pst.setString(1, "%-" + busca);
                rs = pst.executeQuery();

                while (rs.next()) {
                    PeticoesIniciais pi = new PeticoesIniciais();

                    pi.setId_peticoesIniciais(rs.getString(1));
                    pi.setData_peticoesIniciais(rs.getString(2));
                    pi.setId_cliente(rs.getString(3));
                    pi.setId_processo(rs.getString(4));
                    pi.setNumero_processo(rs.getString(5));
                    pi.setNumero_cliente(rs.getString(6));
                    pi.setAcao_processo(rs.getString(7));
                    pi.setNumeroPasta_processo(rs.getString(8));
                    pi.setNome_pessoa(rs.getString(9));
                    pi.setSobrenome_pessoa(rs.getString(10));

                    lista.add(pi);

                }
            }

            this.close();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AgendaVoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return (ArrayList<PeticoesIniciais>) lista;
    }

}
