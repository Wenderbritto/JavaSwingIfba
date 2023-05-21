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
        
        
        GerenciadorBD bd = new GerenciadorBD();
        
        Connection conexao = bd.Conectar();
        
        try{ 
            
            
            
            PreparedStatement comando = conexao.prepareStatement(
                    "SELECT id, login, senha FROM linguagemi.usuario;");
            
            ResultSet resultado = comando.executeQuery();
            
            
            //String sql = "SELECT id, login, senha FROM linguagemi;";
            
            //Statement comando = conexao.createStatement();
            
            //ResultSet resultado = comando.executeQuery(sql);
            
            
            
            DefaultTableModel tabelaUsuarios = (DefaultTableModel) tblUsuarios.getModel();
            
            
            
  
            while(resultado.next()){
            
            
            Object[] Usuario = new Object[]
            {
                resultado.getString("id"),
                resultado.getString("login"),
                resultado.getString("senha")
            };
            
            tabelaUsuarios.addRow(Usuario);
            
            
            }
        }
        catch (SQLException ex){
            
            JOptionPane.showMessageDialog(this, "Não conseguiu");
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
                "id", "login", "senha"
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
                .addContainerGap(27, Short.MAX_VALUE))
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
