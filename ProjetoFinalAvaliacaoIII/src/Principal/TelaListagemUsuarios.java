package Principal;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Statement;

public class TelaListagemUsuarios extends javax.swing.JFrame {


    public TelaListagemUsuarios() {
        initComponents();
        
        this.setLocationRelativeTo(null);
        
        CarregarTabela();
    }
    
    
    private void CarregarTabela(){
        
        //Cria um objeto "bd" para fazer conexão com o Banco de Dados.
        GerenciadorBD bd = new GerenciadorBD();
        
        //Executa a conexão com o Banco de Dados.
        Connection conexao = bd.Conectar();
        
        try{ 
            
            //Comando SQL que vai ser associado ao "comando".
            PreparedStatement comando = conexao.prepareStatement(
                    "SELECT id, login, senha FROM linguagemi.usuario;");
            
            //Executa uma consulta no Banco de Dados.
            ResultSet resultado = comando.executeQuery();
            
            //Modelo de tabela padrão.
            DefaultTableModel tabelaUsuarios = (DefaultTableModel) tblUsuarios.getModel();
           
            //"Existe uma próxima linha?", "resultado = onde está a consultado feita".
            while(resultado.next()){
            
            //"Object= aceita todos os tipos de dados."
            Object[] Usuario = new Object[]
            {
                resultado.getString("id"),//Na primeira linha da tabela pegue o id e guarde no indice 0.
                resultado.getString("login"),//Na primeira linha da tabela pegue o login e guarde no indice 1.
                resultado.getString("senha")//Na primeira linha da tabela pegue a senha e guarde no indice 2.
            //Percorre a tabela linha por linha, guarda o resultado e só termina quando o While for falso "Não existir próxima linha".
            };
            
            //Vai pegar o resultado que está em "Usuario" e adicionar na tabelaUsuarios do java.
            tabelaUsuarios.addRow(Usuario);
            
       
            }
        }
        catch (SQLException ex){
            
            JOptionPane.showMessageDialog(this, "Não conseguiu!");
        }
        finally 
        {
            
            bd.Desconectar();
        
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela de Listagem de Usuários");
        setPreferredSize(new java.awt.Dimension(393, 300));

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTitulo.setText("Tela de Listagem de Usuários");

        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Login", "Senha"
            }
        ));
        jScrollPane1.setViewportView(tblUsuarios);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(lblTitulo)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lblTitulo)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaListagemUsuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tblUsuarios;
    // End of variables declaration//GEN-END:variables
}
