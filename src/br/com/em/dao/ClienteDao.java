/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.em.dao;

import br.com.em.conexao.ModuloConexao;
import static br.com.em.main.JfTelaLogin.usuario;
import br.com.em.modelo.Cliente;
import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author pablo
 */
public class ClienteDao extends ModuloConexao implements InterfaceDao<Cliente> {

    @Override
    public void cadastrar(Cliente cliente) {
        int id_pessoa = 0;
        int n = 0;
        try {

            java.sql.PreparedStatement pstmt = null;
            conexao = this.conector();
            conexao.setAutoCommit(false);
            String query1 = "Insert into modelo_tb_pessoa values(default,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pstmt = this.conexao.prepareStatement(query1, pstmt.RETURN_GENERATED_KEYS);

            pstmt.setString(1, cliente.getP().getNome_pessoa());
            pstmt.setString(2, cliente.getP().getSobrenome_pessoa());
            pstmt.setString(3, cliente.getP().getCpf_pessoa());
            pstmt.setString(4, cliente.getP().getRg_pessoa());
            pstmt.setString(5, cliente.getP().getSexo_pessoa());
            pstmt.setString(6, cliente.getP().getDataNascimento_pessoa());
            pstmt.setString(7, cliente.getP().getEstadoCivil_pessoa());
            pstmt.setString(8, cliente.getP().getRua_pessoa());
            if (!cliente.getP().getNumero_pessoa().isEmpty()) {
                n = Integer.parseInt(cliente.getP().getNumero_pessoa());
                pstmt.setInt(9, n);
            } else {
                pstmt.setInt(9, 0);
            }

            pstmt.setString(10, cliente.getP().getComplemento_pessoa());
            pstmt.setString(11, cliente.getP().getBairro_pessoa());
            pstmt.setString(12, cliente.getP().getCep_pessoa());
            pstmt.setString(13, cliente.getP().getCidade_pessoa());
            pstmt.setString(14, cliente.getP().getEstado_pessoa());
            pstmt.setString(15, cliente.getP().getTelefone_pessoa());
            pstmt.setString(16, cliente.getP().getEmail_pessoa());

            pstmt.execute();

            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                id_pessoa = rs.getInt(1);
            }

            java.sql.PreparedStatement pstmt2 = null;
            String query2 = "Insert into modelo_tb_cliente values(default,?,?,?,?,?,?,?,?,?,?,?,?)";
            pstmt2 = this.conexao.prepareStatement(query2);

            pstmt2.setInt(1, id_pessoa);

            pstmt2.setString(2, cliente.getNumero_cliente());

            if (!cliente.getFilhos_cliente().isEmpty()) {
                n = Integer.parseInt(cliente.getFilhos_cliente());
                pstmt2.setInt(3, n);
            } else {
                pstmt2.setInt(3, 0);
            }

            pstmt2.setString(4, cliente.getConjugeNome_cliente());

            if (!cliente.getConjugeSalario_cliente().isEmpty()) {
                double x = Double.valueOf(cliente.getConjugeSalario_cliente());
                pstmt2.setDouble(5, x);
            } else {
                pstmt2.setDouble(5, 0.00);
            }

            //   pstmt2.setDouble(5, cliente.getConjugeSalario_cliente());
            pstmt2.setString(6, cliente.getProfisao_cliente());
            pstmt2.setString(7, cliente.getLocalTrabalho_cliente());

            if (!cliente.getRequerenteSalario_cliente().isEmpty()) {
                double x = Double.valueOf(cliente.getRequerenteSalario_cliente());
                pstmt2.setDouble(8, x);
            } else {
                pstmt2.setDouble(8, 0.00);
            }

            //  pstmt2.setDouble(8, cliente.getRequerenteSalario_cliente());
            pstmt2.setString(9, cliente.getRelacaoBens_cliente());
            Date data = new Date();
            DateFormat formatador = DateFormat.getDateInstance(DateFormat.DEFAULT);
            pstmt2.setString(10, formatador.format(data));
            pstmt2.setBoolean(11, cliente.isDefere_cliente());
            pstmt2.setBoolean(12, cliente.isInativo_cliente());

            pstmt2.execute();

            conexao.commit();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
            Logger.getLogger(ClienteDao.class.getName()).log(Level.INFO, "Cadastrou | Cliente: {0} | Usuario: {1}", new Object[]{id_pessoa, usuario});

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

    /**
     *
     * @param busca
     * @param auxBusca
     *
     * @return retorno um arraylist dos dados do cliente que se buscou
     */
    @Override
    public ArrayList<Cliente> listar(String busca, String auxBusca) {
        List lista = new ArrayList<>();

        ResultSet rs = null;

        if (auxBusca.equalsIgnoreCase("nome")) {

            try {
                java.sql.PreparedStatement pst = null;
                conexao = this.conector();
                if (busca.isEmpty()) {
                    //  String sql = "select * from modelo_tb_cliente";
                    String sql = ("SELECT p.*, c.* FROM modelo_tb_cliente c left join  modelo_tb_pessoa p on c.id_pessoa = p.id_pessoa ORDER BY p.nome_pessoa ASC; ");
                    pst = this.conexao.prepareStatement(sql);
                } else {

                    String sql = ("SELECT p.*, c.* FROM modelo_tb_cliente c left join  modelo_tb_pessoa p on c.id_pessoa = p.id_pessoa where p.nome_pessoa like ? ORDER BY p.nome_pessoa ASC;");

                    pst = this.conexao.prepareStatement(sql);
                    pst.setString(1, busca + "%");
                }
                rs = pst.executeQuery();

                while (rs.next()) {
                    Cliente c = new Cliente();
                    // c.getP().setId_pessoa(rs.getString(1));
                    c.getP().setNome_pessoa(rs.getString(2));
                    c.getP().setSobrenome_pessoa(rs.getString(3));
                    c.getP().setCpf_pessoa(rs.getString(4));
                    c.getP().setRg_pessoa(rs.getString(5));
                    c.getP().setSexo_pessoa(rs.getString(6));
                    c.getP().setDataNascimento_pessoa(rs.getString(7));
                    c.getP().setEstadoCivil_pessoa(rs.getString(8));
                    c.getP().setRua_pessoa(rs.getString(9));
                    c.getP().setNumero_pessoa(rs.getString(10));
                    c.getP().setComplemento_pessoa(rs.getString(11));
                    c.getP().setBairro_pessoa(rs.getString(12));
                    c.getP().setCep_pessoa(rs.getString(13));
                    c.getP().setCidade_pessoa(rs.getString(14));
                    c.getP().setEstado_pessoa(rs.getString(15));
                    c.getP().setTelefone_pessoa(rs.getString(16));
                    c.getP().setEmail_pessoa(rs.getString(17));
                    c.setId_cliente(rs.getString(18));
                    //   c.setId_pessoa(rs.getString(19));
                    c.setNumero_cliente(rs.getString(20));
                    c.setFilhos_cliente(rs.getString(21));
                    c.setConjugeNome_cliente(rs.getString(22));
                    c.setConjugeSalario_cliente(String.valueOf(rs.getDouble(23)));
                    c.setProfisao_cliente(rs.getString(24));
                    c.setLocalTrabalho_cliente(rs.getString(25));
                    c.setRequerenteSalario_cliente(String.valueOf(rs.getDouble(26)));
                    c.setRelacaoBens_cliente(rs.getString(27));
                    c.setDataRegistro_cliente(rs.getString(28));
                    c.setDefere_cliente(rs.getBoolean(29));
                    c.setInativo_cliente(rs.getBoolean(30));

                    lista.add(c);
                }
                this.close();
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (auxBusca.equalsIgnoreCase("sobrenome")) {

            try {
                java.sql.PreparedStatement pst = null;
                conexao = this.conector();
                if (busca.isEmpty()) {
                    //  String sql = "select * from modelo_tb_cliente";
                    String sql = ("SELECT p.*, c.* FROM modelo_tb_cliente c left join  modelo_tb_pessoa p on c.id_pessoa = p.id_pessoa ORDER BY p.nome_pessoa ASC; ");
                    pst = this.conexao.prepareStatement(sql);
                } else {

                    String sql = ("SELECT p.*, c.* FROM modelo_tb_cliente c left join  modelo_tb_pessoa p on c.id_pessoa = p.id_pessoa where p.sobrenome_pessoa like ? ORDER BY p.nome_pessoa ASC;");

                    pst = this.conexao.prepareStatement(sql);
                    pst.setString(1, busca + "%");
                }
                rs = pst.executeQuery();

                while (rs.next()) {
                    Cliente c = new Cliente();
                    // c.getP().setId_pessoa(rs.getString(1));
                    c.getP().setNome_pessoa(rs.getString(2));
                    c.getP().setSobrenome_pessoa(rs.getString(3));
                    c.getP().setCpf_pessoa(rs.getString(4));
                    c.getP().setRg_pessoa(rs.getString(5));
                    c.getP().setSexo_pessoa(rs.getString(6));
                    c.getP().setDataNascimento_pessoa(rs.getString(7));
                    c.getP().setEstadoCivil_pessoa(rs.getString(8));
                    c.getP().setRua_pessoa(rs.getString(9));
                    c.getP().setNumero_pessoa(rs.getString(10));
                    c.getP().setComplemento_pessoa(rs.getString(11));
                    c.getP().setBairro_pessoa(rs.getString(12));
                    c.getP().setCep_pessoa(rs.getString(13));
                    c.getP().setCidade_pessoa(rs.getString(14));
                    c.getP().setEstado_pessoa(rs.getString(15));
                    c.getP().setTelefone_pessoa(rs.getString(16));
                    c.getP().setEmail_pessoa(rs.getString(17));
                    c.setId_cliente(rs.getString(18));
                    //   c.setId_pessoa(rs.getString(19));
                    c.setNumero_cliente(rs.getString(20));
                    c.setFilhos_cliente(rs.getString(21));
                    c.setConjugeNome_cliente(rs.getString(22));
                    c.setConjugeSalario_cliente(String.valueOf(rs.getDouble(23)));
                    c.setProfisao_cliente(rs.getString(24));
                    c.setLocalTrabalho_cliente(rs.getString(25));
                    c.setRequerenteSalario_cliente(String.valueOf(rs.getDouble(26)));
                    c.setRelacaoBens_cliente(rs.getString(27));
                    c.setDataRegistro_cliente(rs.getString(28));
                    c.setDefere_cliente(rs.getBoolean(29));
                    c.setInativo_cliente(rs.getBoolean(30));

                    lista.add(c);
                }
                this.close();
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {

            try {
                java.sql.PreparedStatement pst = null;
                conexao = this.conector();
                if (busca.isEmpty()) {
                    //  String sql = "select * from modelo_tb_cliente";
                    String sql = ("SELECT p.*, c.* FROM modelo_tb_cliente c left join  modelo_tb_pessoa p on c.id_pessoa = p.id_pessoa ORDER BY p.nome_pessoa ASC; ");
                    pst = this.conexao.prepareStatement(sql);
                } else {

                    String sql = ("SELECT p.*, c.* FROM modelo_tb_cliente c left join  modelo_tb_pessoa p on c.id_pessoa = p.id_pessoa where c.numero_cliente like ? ORDER BY p.nome_pessoa ASC;");

                    pst = this.conexao.prepareStatement(sql);
                    pst.setString(1, busca + "%");
                }
                rs = pst.executeQuery();

                while (rs.next()) {
                    Cliente c = new Cliente();
                    // c.getP().setId_pessoa(rs.getString(1));
                    c.getP().setNome_pessoa(rs.getString(2));
                    c.getP().setSobrenome_pessoa(rs.getString(3));
                    c.getP().setCpf_pessoa(rs.getString(4));
                    c.getP().setRg_pessoa(rs.getString(5));
                    c.getP().setSexo_pessoa(rs.getString(6));
                    c.getP().setDataNascimento_pessoa(rs.getString(7));
                    c.getP().setEstadoCivil_pessoa(rs.getString(8));
                    c.getP().setRua_pessoa(rs.getString(9));
                    c.getP().setNumero_pessoa(rs.getString(10));
                    c.getP().setComplemento_pessoa(rs.getString(11));
                    c.getP().setBairro_pessoa(rs.getString(12));
                    c.getP().setCep_pessoa(rs.getString(13));
                    c.getP().setCidade_pessoa(rs.getString(14));
                    c.getP().setEstado_pessoa(rs.getString(15));
                    c.getP().setTelefone_pessoa(rs.getString(16));
                    c.getP().setEmail_pessoa(rs.getString(17));
                    c.setId_cliente(rs.getString(18));
                    //   c.setId_pessoa(rs.getString(19));
                    c.setNumero_cliente(rs.getString(20));
                    c.setFilhos_cliente(rs.getString(21));
                    c.setConjugeNome_cliente(rs.getString(22));
                    c.setConjugeSalario_cliente(String.valueOf(rs.getDouble(23)));
                    c.setProfisao_cliente(rs.getString(24));
                    c.setLocalTrabalho_cliente(rs.getString(25));
                    c.setRequerenteSalario_cliente(String.valueOf(rs.getDouble(26)));
                    c.setRelacaoBens_cliente(rs.getString(27));
                    c.setDataRegistro_cliente(rs.getString(28));
                    c.setDefere_cliente(rs.getBoolean(29));
                    c.setInativo_cliente(rs.getBoolean(30));

                    lista.add(c);
                }
                this.close();
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        return (ArrayList<Cliente>) lista;
    }

    // }
    @Override
    public void atualizar(Cliente cliente) {

        int id_pessoa = 0;
        int n = 0;
        try {

            java.sql.PreparedStatement pstmt = null;
            conexao = this.conector();
            conexao.setAutoCommit(false);

            ResultSet rs = null;
            String q = "select id_pessoa from modelo_tb_cliente where id_cliente =?";
            java.sql.PreparedStatement pst = this.conexao.prepareStatement(q);

            n = Integer.parseInt(cliente.getId_cliente());

            pst.setInt(1, n);
            rs = pst.executeQuery();
            while (rs.next()) {
                id_pessoa = rs.getInt(1);

            }

            String query1 = ("UPDATE modelo_tb_pessoa SET nome_pessoa=?, sobrenome_pessoa=?, cpf_pessoa=?, "
                    + "rg_pessoa=?, sexo_pessoa=?, dataNascimento_pessoa=?, "
                    + "estadoCivil_pessoa=?, rua_pessoa=?, numero_pessoa=?, "
                    + "complemento_pessoa=?, bairro_pessoa=?, cep_pessoa=?, "
                    + "cidade_pessoa=?, estado_pessoa=?, telefone_pessoa=?, "
                    + "email_pessoa=? WHERE id_pessoa=?;");

            pstmt = this.conexao.prepareStatement(query1);

            pstmt.setString(1, cliente.getP().getNome_pessoa());
            pstmt.setString(2, cliente.getP().getSobrenome_pessoa());
            pstmt.setString(3, cliente.getP().getCpf_pessoa());
            pstmt.setString(4, cliente.getP().getRg_pessoa());
            pstmt.setString(5, cliente.getP().getSexo_pessoa());
            pstmt.setString(6, cliente.getP().getDataNascimento_pessoa());
            pstmt.setString(7, cliente.getP().getEstadoCivil_pessoa());
            pstmt.setString(8, cliente.getP().getRua_pessoa());
            if (!cliente.getP().getNumero_pessoa().isEmpty()) {
                n = Integer.parseInt(cliente.getP().getNumero_pessoa());
                pstmt.setInt(9, n);
            } else {
                pstmt.setInt(9, 0);
            }
            // pstmt.setString(9, cliente.getP().getNumero_pessoa());
            pstmt.setString(10, cliente.getP().getComplemento_pessoa());
            pstmt.setString(11, cliente.getP().getBairro_pessoa());
            pstmt.setString(12, cliente.getP().getCep_pessoa());
            pstmt.setString(13, cliente.getP().getCidade_pessoa());
            pstmt.setString(14, cliente.getP().getEstado_pessoa());
            pstmt.setString(15, cliente.getP().getTelefone_pessoa());
            pstmt.setString(16, cliente.getP().getEmail_pessoa());
            pstmt.setInt(17, id_pessoa);

            pstmt.executeUpdate();

//            ResultSet rs = pstmt.getGeneratedKeys();
//            if (rs.next()) {
//                id_pessoa = rs.getInt(1);
//            }
            java.sql.PreparedStatement pstmt2 = null;

            String query2 = ("UPDATE modelo_tb_cliente SET numero_cliente=?, filhos_cliente=?, conjugeNome_cliente=?, conjugeSalario_cliente=?, profisao_cliente=?, "
                    + "localTrabalho_cliente=?, requerenteSalario_cliente=?, relacaoBens_cliente=?, "
                    + " defere_cliente=?, inativo_cliente=? WHERE  id_cliente=?;");
            pstmt2 = this.conexao.prepareStatement(query2);

            // pstmt2.setInt(1, id_pessoa);
            pstmt2.setString(1, cliente.getNumero_cliente());

            if (!cliente.getFilhos_cliente().isEmpty()) {
                n = Integer.parseInt(cliente.getFilhos_cliente());
                pstmt2.setInt(2, n);
            } else {
                pstmt2.setInt(2, 0);
            }
            pstmt2.setString(3, cliente.getConjugeNome_cliente());

            if (!cliente.getConjugeSalario_cliente().isEmpty()) {
                double x = Double.valueOf(cliente.getConjugeSalario_cliente());
                pstmt2.setDouble(4, x);
            } else {
                pstmt2.setDouble(4, 0.00);
            }

            //   pstmt2.setDouble(5, cliente.getConjugeSalario_cliente());
            pstmt2.setString(5, cliente.getProfisao_cliente());
            pstmt2.setString(6, cliente.getLocalTrabalho_cliente());

            if (!cliente.getRequerenteSalario_cliente().isEmpty()) {
                double y = Double.valueOf(cliente.getRequerenteSalario_cliente());
                pstmt2.setDouble(7, y);
            } else {
                pstmt2.setDouble(7, 0.00);
            }
            pstmt2.setString(8, cliente.getRelacaoBens_cliente());
//            Date data = new Date();
//            DateFormat formatador = DateFormat.getDateInstance(DateFormat.DEFAULT);
//
//            pstmt2.setString(12, formatador.format(data));

            pstmt2.setBoolean(9, cliente.isDefere_cliente());
            pstmt2.setBoolean(10, cliente.isInativo_cliente());
            n = Integer.parseInt(cliente.getId_cliente());
            pstmt2.setInt(11, n);

            pstmt2.executeUpdate();

            conexao.commit();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso");
            Logger.getLogger(ClienteDao.class.getName()).log(Level.INFO, "Atualizou | Cliente: {0} | Usuario: {1}", new Object[]{id_pessoa, usuario});

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
