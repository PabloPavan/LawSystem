
package br.com.em.conexao;

import java.sql.*;

/**
 *
 * @author pablo
 */
public class ModuloConexao {

    protected java.sql.Connection conexao = null;
    private final String driver = "com.mysql.jdbc.Driver";
    private final String url = "jdbc:mysql://";
    private final String user = "";
    private final String password = "";

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
