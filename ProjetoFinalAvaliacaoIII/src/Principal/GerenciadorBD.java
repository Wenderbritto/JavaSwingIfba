package Principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GerenciadorBD {
    
    private Connection conexao = null;
    
    private final String servidor = "127.0.0.1:3306";
    private final String banco = "linguagemi";
    private final String login = "root";
    private final String senha = "1519";
    
    
    public Connection Conectar(){
        
        try{
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            String textoConexao = "jdbc:mysql://" +this.servidor + "/" + this.banco;
            
            conexao = DriverManager.getConnection(textoConexao, this.login, this.senha);
            
            System.out.println("Conectou");
        
        }
        catch (SQLException | ClassNotFoundException ex)
        {
            System.out.println("Erro");
        
        }
        
        return conexao;
    }
    
    public void Desconectar(){
        
        
        try
        {
            
            if(conexao != null && !conexao.isClosed()){
                
                conexao.close();
            }
        }
        catch(SQLException ex){
            
            System.out.println("Não conseguiu desconectar");
        
        
        }
    }
    
}
