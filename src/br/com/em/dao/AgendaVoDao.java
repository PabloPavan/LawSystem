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
import br.com.em.modelo.Agenda;
import br.com.em.vo.AgendaVo;
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
public class AgendaVoDao extends ModuloConexao implements InterfaceDao<AgendaVo> {

    @Override
    public void cadastrar(AgendaVo obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(AgendaVo obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<AgendaVo> listar(String busca, String auxBusca) {
        List lista = new ArrayList<>();
//
        ResultSet rs = null;

        java.sql.PreparedStatement pst = null;

        try {
            conexao = this.conector();

            if (!busca.isEmpty()) {

                String sql = ("select a.hora_agenda, "
                        + "a.atividade_agenda, "
                        + "p.numero_processo, "
                        + "c.numero_cliente , "
                        + "p.acao_processo "
                        + "from modelo_tb_agenda a "
                        + "join modelo_tb_processo p on a.id_processo = p.id_processo "
                        + "join modelo_tb_cliente c on p.id_cliente = c.id_cliente "
                        + "where data_agenda like ? order by hora_agenda ASC;");

                pst = this.conexao.prepareStatement(sql);
                pst.setString(1, "%" + busca + "%");
                rs = pst.executeQuery();

                while (rs.next()) {
                    AgendaVo agenda = new AgendaVo();
                    agenda.setHora_agenda(rs.getString(1));
                    agenda.setAtividade_agenda(rs.getString(2));
                    agenda.setNumero_processo(rs.getString(3));
                    agenda.setNumero_cliente(rs.getString(4));
                    agenda.setAcao_processo(rs.getString(5));

                    lista.add(agenda);

                }
            }

            this.close();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AgendaVoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return (ArrayList<AgendaVo>) lista;
    }

}
