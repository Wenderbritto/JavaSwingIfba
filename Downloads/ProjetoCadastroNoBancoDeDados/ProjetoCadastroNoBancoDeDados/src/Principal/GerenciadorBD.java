package Principal;

import java.sql.Connection;
import java.sql.DriverManager;

public class GerenciadorBD {

    private final String servidor = "127.0.0.1:3306";
    private final String banco = "bancoabc";
    private final String login = "";
    private final String senha = "";

    public Connection conectar() throws Exception {
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        String textoDeConexao = "jdbc:mysql://" + servidor + "/" + banco;
        
        return DriverManager.getConnection(textoDeConexao, login, senha);
    }

}

