/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.em.dao;

import br.com.em.conexao.ModuloConexao;
import static br.com.em.main.JfTelaLogin.usuario;
import br.com.em.modelo.Cliente;
import br.com.em.modelo.Vara;
import java.awt.HeadlessException;
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
public class VaraDao extends ModuloConexao implements InterfaceDao<Vara> {

    @Override

    public void cadastrar(Vara vara) {

    }

    @Override
    public void atualizar(Vara vara) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Vara> listar(String busca, String auxBusca) {

        List lista = new ArrayList<>();

        ResultSet rs = null;

        try {
            java.sql.PreparedStatement pst = null;
            conexao = this.conector();

            //  String sql = "select * from modelo_tb_cliente";
            String sql = ("select id_vara, nome_vara from modelo_tb_vara  ORDER BY id_vara ASC;");
            pst = this.conexao.prepareStatement(sql);

            rs = pst.executeQuery();

            while (rs.next()) {
                Vara v = new Vara();
                v.setId_vara(String.valueOf(rs.getInt(1)));
                v.setNome_vara(rs.getString(2));
                lista.add(v);
            }
            this.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return (ArrayList<Vara>) lista;

    }
}
