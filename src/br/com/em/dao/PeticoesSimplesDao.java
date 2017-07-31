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
import br.com.em.modelo.PeticoesSimples;
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
public class PeticoesSimplesDao extends ModuloConexao implements InterfaceDao<PeticoesSimples> {

    @Override
    public ArrayList<PeticoesSimples> listar(String busca, String auxBusca) {
        List lista = new ArrayList<>();
//
        ResultSet rs = null;

        java.sql.PreparedStatement pst = null;

        try {
            conexao = this.conector();

            if (!busca.isEmpty()) {

                String sql = ("select ps.*, "
                        + "p.numero_processo, "
                        + "c.numero_cliente, "
                        + "p.acao_processo, "
                        + "p.numeroPasta_processo, "
                        + "pes.nome_pessoa, "
                        + "pes.sobrenome_pessoa "
                        + "from modelo_tb_peticoesSimples ps "
                        + "join modelo_tb_processo p on ps.id_processo = p.id_processo "
                        + "join modelo_tb_cliente c on ps.id_cliente = c.id_cliente "
                        + "join modelo_tb_pessoa pes on pes.id_pessoa = c.id_pessoa "
                        + "where "
                        + "ps.data_peticoesSimples like ?");

                pst = this.conexao.prepareStatement(sql);
                pst.setString(1, "%-" + busca);
                rs = pst.executeQuery();

                while (rs.next()) {
                    PeticoesSimples ps = new PeticoesSimples();

                    ps.setId_peticoesSimples(rs.getString(1));
                    ps.setData_peticoesSimples(rs.getString(2));
                    ps.setId_cliente(rs.getString(3));
                    ps.setId_processo(rs.getString(4));
                    ps.setNumero_processo(rs.getString(5));
                    ps.setNumero_cliente(rs.getString(6));
                    ps.setAcao_processo(rs.getString(7));
                    ps.setNumeroPasta_processo(rs.getString(8));
                    ps.setNome_pessoa(rs.getString(9));
                    ps.setSobrenome_pessoa(rs.getString(10));

                    lista.add(ps);

                }
            }

            this.close();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AgendaVoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return (ArrayList<PeticoesSimples>) lista;
    }

    @Override
    public void cadastrar(PeticoesSimples ps) {
        try {

            java.sql.PreparedStatement pstmt = null;
            conexao = this.conector();
            conexao.setAutoCommit(false);
            String query1 = "INSERT INTO modelo_tb_peticoesSimples VALUES (default, ?, ?, ?);";
            pstmt = this.conexao.prepareStatement(query1);

            pstmt.setString(1, ps.getData_peticoesSimples());
            pstmt.setInt(2, Integer.valueOf(ps.getId_cliente()));
            pstmt.setInt(3, Integer.valueOf(ps.getId_processo()));

            pstmt.execute();

            conexao.commit();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
            Logger.getLogger(ClienteDao.class.getName()).log(Level.INFO, "Cadastrou | Petiçoes Simples : {0} | Usuario: {1}", new Object[]{"", usuario});

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
    public void atualizar(PeticoesSimples ps) {
        try {

            java.sql.PreparedStatement pstmt = null;
            conexao = this.conector();
            conexao.setAutoCommit(false);

            String query1 = ("UPDATE modelo_tb_peticoesSimples SET "
                    + "data_peticoesSimples=?, "
                    + "id_cliente=?, "
                    + "id_processo=? "
                    + "WHERE  "
                    + "id_peticoesSimples=?;");

            pstmt = this.conexao.prepareStatement(query1);

            pstmt.setString(1, ps.getData_peticoesSimples());
            pstmt.setInt(2, Integer.valueOf(ps.getId_cliente()));
            pstmt.setInt(3, Integer.valueOf(ps.getId_processo()));
            pstmt.setInt(4, Integer.valueOf(ps.getId_peticoesSimples()));

            pstmt.executeUpdate();

            conexao.commit();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso");
            Logger.getLogger(ClienteDao.class.getName()).log(Level.INFO, "Atualizou | Petições Simples: {0} | Usuario: {1}", new Object[]{ps.getId_peticoesSimples(), usuario});

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

}
