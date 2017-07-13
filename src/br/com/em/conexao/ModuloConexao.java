package br.com.em.conexao;

import java.sql.*;

/**
 *
 * @author pablo
 */
public class ModuloConexao {

    protected java.sql.Connection conexao = null;
    private final String driver = "com.mysql.jdbc.Driver";
    private final String url = "jdbc:mysql://www.projetos.unijui.edu.br:3306/emodelo";
    private final String user = "emodelo";
    private final String password = "B@nc0&moDel0!";

    //metodo responsavel por estabelacer a conexao com o banco
    /**
     *
     * @return @throws ClassNotFoundException
     * @throws SQLException
     */
    public Connection conector() throws ClassNotFoundException, SQLException {
        java.sql.Connection conexao = null;
        // chama o driver do conector

        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);

        }
        return conexao;
    }

    public void close() throws SQLException {

        if (conexao != null) {
            if (!conexao.isClosed()) {
                conexao.close();
            }
        }

    }

}
