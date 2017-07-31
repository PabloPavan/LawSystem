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
import br.com.em.vo.ProcessoVo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pablo
 */
public class ProcessoVoDao extends ModuloConexao implements InterfaceDao<ProcessoVo> {

    @Override
    public void cadastrar(ProcessoVo obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(ProcessoVo obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ProcessoVo> listar(String busca, String auxBusca) {

        List lista = new ArrayList<>();
//
        ResultSet rs = null;

        if (auxBusca.equalsIgnoreCase("nome")) {

            java.sql.PreparedStatement pst = null;
            try {
                conexao = this.conector();

                if (busca.isEmpty()) {

                    String sql = ("select pro.* ,cli.numero_cliente, pes.nome_pessoa, pes.sobrenome_pessoa, pes.rg_pessoa, pes.cpf_pessoa "
                            + "from modelo_tb_processo pro join modelo_tb_cliente cli on pro.id_cliente = cli.id_cliente "
                            + "join modelo_tb_pessoa pes on cli.id_pessoa = pes.id_pessoa order by nome_pessoa ; ");
                    pst = this.conexao.prepareStatement(sql);
                } else {

                    String sql = ("select pro.* ,cli.numero_cliente, pes.nome_pessoa, "
                            + "pes.sobrenome_pessoa, pes.rg_pessoa, pes.cpf_pessoa "
                            + "from modelo_tb_processo pro join modelo_tb_cliente cli on pro.id_cliente = cli.id_cliente"
                            + " join modelo_tb_pessoa pes on cli.id_pessoa = pes.id_pessoa where pes.nome_pessoa like ? order by nome_pessoa ");

                    pst = this.conexao.prepareStatement(sql);
                    pst.setString(1, busca + "%");
                }
                rs = pst.executeQuery();

                while (rs.next()) {
                    ProcessoVo pv = new ProcessoVo();
                    pv.setId_processo(rs.getString(1));
                    pv.setNomeparte_processo(rs.getString(2));
                    pv.setNumero_processo(rs.getString(3));
                    pv.setNumeroPasta_processo(rs.getString(4));
                    pv.setAndamento_processo(rs.getString(5));
                    pv.setAcao_processo(rs.getString(6));
                    pv.setId_cliente(rs.getString(7));
                    pv.setId_vara(rs.getString(8));
                    pv.setDataInicio_processo(rs.getString(9));
                    pv.setDataFim_processo(rs.getString(10));
                    pv.setDiaSemana_processo(rs.getString(11));
                    pv.setNarrativa_processo(rs.getString(12));
                    pv.setConsulta_processo(rs.getString(13));
                    pv.setObs_processo(rs.getString(14));
                    pv.setNumero_cliente(rs.getString(15));
                    pv.setNome_pessoa(rs.getString(16));
                    pv.setSobrenome_pessoa(rs.getString(17));
                    pv.setRg_pessoa(rs.getString(18));
                    pv.setCpf_pessoa(rs.getString(19));

                    lista.add(pv);
                }
                this.close();

            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ProcessoVoDao.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (auxBusca.equalsIgnoreCase("sobrenome")) {

            java.sql.PreparedStatement pst = null;
            try {
                conexao = this.conector();

                if (busca.isEmpty()) {

                    String sql = ("select pro.* ,cli.numero_cliente, pes.nome_pessoa, pes.sobrenome_pessoa, pes.rg_pessoa, pes.cpf_pessoa "
                            + "from modelo_tb_processo pro join modelo_tb_cliente cli on pro.id_cliente = cli.id_cliente "
                            + "join modelo_tb_pessoa pes on cli.id_pessoa = pes.id_pessoa order by nome_pessoa ; ");
                    pst = this.conexao.prepareStatement(sql);
                } else {

                    String sql = ("select pro.* ,cli.numero_cliente, pes.nome_pessoa, "
                            + "pes.sobrenome_pessoa, pes.rg_pessoa, pes.cpf_pessoa "
                            + "from modelo_tb_processo pro join modelo_tb_cliente cli on pro.id_cliente = cli.id_cliente"
                            + " join modelo_tb_pessoa pes on cli.id_pessoa = pes.id_pessoa where pes.sobrenome_pessoa like ? order by nome_pessoa ");

                    pst = this.conexao.prepareStatement(sql);
                    pst.setString(1, busca + "%");
                }
                rs = pst.executeQuery();

                while (rs.next()) {
                    ProcessoVo pv = new ProcessoVo();
                    pv.setId_processo(rs.getString(1));
                    pv.setNomeparte_processo(rs.getString(2));
                    pv.setNumero_processo(rs.getString(3));
                    pv.setNumeroPasta_processo(rs.getString(4));
                    pv.setAndamento_processo(rs.getString(5));
                    pv.setAcao_processo(rs.getString(6));
                    pv.setId_cliente(rs.getString(7));
                    pv.setId_vara(rs.getString(8));
                    pv.setDataInicio_processo(rs.getString(9));
                    pv.setDataFim_processo(rs.getString(10));
                    pv.setDiaSemana_processo(rs.getString(11));
                    pv.setNarrativa_processo(rs.getString(12));
                    pv.setConsulta_processo(rs.getString(13));
                    pv.setObs_processo(rs.getString(14));
                    pv.setNumero_cliente(rs.getString(15));
                    pv.setNome_pessoa(rs.getString(16));
                    pv.setSobrenome_pessoa(rs.getString(17));
                    pv.setRg_pessoa(rs.getString(18));
                    pv.setCpf_pessoa(rs.getString(19));

                    lista.add(pv);
                }
                this.close();

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ProcessoVoDao.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ProcessoVoDao.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {

            java.sql.PreparedStatement pst = null;
            try {
                conexao = this.conector();

                if (busca.isEmpty()) {

                    String sql = ("select pro.* ,cli.numero_cliente, pes.nome_pessoa, pes.sobrenome_pessoa, pes.rg_pessoa, pes.cpf_pessoa "
                            + "from modelo_tb_processo pro join modelo_tb_cliente cli on pro.id_cliente = cli.id_cliente "
                            + "join modelo_tb_pessoa pes on cli.id_pessoa = pes.id_pessoa order by nome_pessoa ASC ; ");
                    pst = this.conexao.prepareStatement(sql);
                } else {

                    String sql = ("select pro.* ,cli.numero_cliente, pes.nome_pessoa, "
                            + "pes.sobrenome_pessoa, pes.rg_pessoa, pes.cpf_pessoa "
                            + "from modelo_tb_processo pro join modelo_tb_cliente cli on pro.id_cliente = cli.id_cliente"
                            + " join modelo_tb_pessoa pes on cli.id_pessoa = pes.id_pessoa where pro.numero_processo like ? order by nome_pessoa ASC ");

                    pst = this.conexao.prepareStatement(sql);
                    pst.setString(1, busca + "%");
                }
                rs = pst.executeQuery();

                while (rs.next()) {
                    ProcessoVo pv = new ProcessoVo();
                    pv.setId_processo(rs.getString(1));
                    pv.setNomeparte_processo(rs.getString(2));
                    pv.setNumero_processo(rs.getString(3));
                    pv.setNumeroPasta_processo(rs.getString(4));
                    pv.setAndamento_processo(rs.getString(5));
                    pv.setAcao_processo(rs.getString(6));
                    pv.setId_cliente(rs.getString(7));
                    pv.setId_vara(rs.getString(8));
                    pv.setDataInicio_processo(rs.getString(9));
                    pv.setDataFim_processo(rs.getString(10));
                    pv.setDiaSemana_processo(rs.getString(11));
                    pv.setNarrativa_processo(rs.getString(12));
                    pv.setConsulta_processo(rs.getString(13));
                    pv.setObs_processo(rs.getString(14));
                    pv.setNumero_cliente(rs.getString(15));
                    pv.setNome_pessoa(rs.getString(16));
                    pv.setSobrenome_pessoa(rs.getString(17));
                    pv.setRg_pessoa(rs.getString(18));
                    pv.setCpf_pessoa(rs.getString(19));

                    lista.add(pv);
                }
                this.close();

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ProcessoVoDao.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ProcessoVoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return (ArrayList<ProcessoVo>) lista;

    }
}
