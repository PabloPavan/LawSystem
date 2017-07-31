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
import br.com.em.modelo.DefesasPrevias;
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
public class DefesasPreviasDao extends ModuloConexao implements InterfaceDao<DefesasPrevias> {

    @Override
    public ArrayList<DefesasPrevias> listar(String busca, String auxBusca) {
        List lista = new ArrayList<>();
//
        ResultSet rs = null;

        java.sql.PreparedStatement pst = null;

        try {
            conexao = this.conector();

            if (!busca.isEmpty()) {

                String sql = ("select dp.*, "
                        + "p.numero_processo, "
                        + "c.numero_cliente, "
                        + "p.acao_processo, "
                        + "p.numeroPasta_processo, "
                        + "pes.nome_pessoa, "
                        + "pes.sobrenome_pessoa "
                        + "from modelo_tb_defesasPrevias dp "
                        + "join modelo_tb_processo p on dp.id_processo = p.id_processo "
                        + "join modelo_tb_cliente c on dp.id_cliente = c.id_cliente "
                        + "join modelo_tb_pessoa pes on pes.id_pessoa = c.id_pessoa "
                        + "where "
                        + "dp.data_defesasPrevias like ?");

                pst = this.conexao.prepareStatement(sql);
                pst.setString(1, "%-" + busca);
                rs = pst.executeQuery();

                while (rs.next()) {
                    DefesasPrevias dp = new DefesasPrevias();

                    dp.setId_defesaPrevia(rs.getString(1));
                    dp.setData_defesaPrevia(rs.getString(2));
                    dp.setId_cliente(rs.getString(3));
                    dp.setId_processo(rs.getString(4));
                    dp.setNumero_processo(rs.getString(5));
                    dp.setNumero_cliente(rs.getString(6));
                    dp.setAcao_processo(rs.getString(7));
                    dp.setNumeroPasta_processo(rs.getString(8));
                    dp.setNome_pessoa(rs.getString(9));
                    dp.setSobrenome_pessoa(rs.getString(10));

                    lista.add(dp);

                }
            }

            this.close();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AgendaVoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return (ArrayList<DefesasPrevias>) lista;
    }

    @Override
    public void cadastrar(DefesasPrevias dp) {
        try {

            java.sql.PreparedStatement pstmt = null;
            conexao = this.conector();
            conexao.setAutoCommit(false);
            String query1 = "INSERT INTO modelo_tb_defesasPrevias VALUES (default, ?, ?, ?);";
            pstmt = this.conexao.prepareStatement(query1);

            pstmt.setString(1, dp.getData_defesaPrevia());
            pstmt.setInt(2, Integer.valueOf(dp.getId_cliente()));
            pstmt.setInt(3, Integer.valueOf(dp.getId_processo()));

            pstmt.execute();

            conexao.commit();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
            Logger.getLogger(ClienteDao.class.getName()).log(Level.INFO, "Cadastrou | Defesas Previas : {0} | Usuario: {1}", new Object[]{"", usuario});

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
    public void atualizar(DefesasPrevias dp) {
        try {

            java.sql.PreparedStatement pstmt = null;
            conexao = this.conector();
            conexao.setAutoCommit(false);

            String query1 = ("UPDATE modelo_tb_defesasPrevias SET "
                    + "data_defesasPrevias=?, "
                    + "id_cliente=?, "
                    + "id_processo=? "
                    + "WHERE  "
                    + "id_defesasPrevias=?;");

            pstmt = this.conexao.prepareStatement(query1);

            pstmt.setString(1, dp.getData_defesaPrevia());
            pstmt.setInt(2, Integer.valueOf(dp.getId_cliente()));
            pstmt.setInt(3, Integer.valueOf(dp.getId_processo()));
            pstmt.setInt(4, Integer.valueOf(dp.getId_defesaPrevia()));

            pstmt.executeUpdate();

            conexao.commit();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso");
            Logger.getLogger(ClienteDao.class.getName()).log(Level.INFO, "Atualizou | |Defesa Previa: {0} | Usuario: {1}", new Object[]{dp.getId_defesaPrevia(), usuario});

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
