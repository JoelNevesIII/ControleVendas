/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import database.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Joel
 */
public class telaAreaVenda extends javax.swing.JFrame {

    /**
     * Creates new form telaAreaVenda
     */
    public telaAreaVenda() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        carregaTabela();
    }
    private void carregaTabela(){
        DefaultTableModel modelo = (DefaultTableModel) jtAreaVenda.getModel();
        modelo.setNumRows(0);
        
        jtAreaVenda.getColumnModel().getColumn(0).setPreferredWidth(80);
        jtAreaVenda.getColumnModel().getColumn(1).setPreferredWidth(20);       
        try{
            Connection con = Conexao.getConnection();
            ResultSet rs = null;
            PreparedStatement stmt = null;
            
            stmt = con.prepareStatement("select id_area,nome from area_venda");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                modelo.addRow(new Object[]{
                    rs.getInt(1),
                    rs.getString(2),
                });
            }
            Conexao.closeConnection(con);
        }catch(Exception e){
            
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JButton();
        btnCadastraAreaVenda = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtAreaVenda = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel1.setText("Area Vendas");
        jLabel1.setToolTipText("");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 10, -1, -1));

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });
        getContentPane().add(btnVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 480, -1, -1));

        btnCadastraAreaVenda.setText("Cadastrar area de venda");
        btnCadastraAreaVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastraAreaVendaActionPerformed(evt);
            }
        });
        getContentPane().add(btnCadastraAreaVenda, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 480, -1, -1));

        jtAreaVenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Area de Venda"
            }
        ));
        jScrollPane1.setViewportView(jtAreaVenda);
        if (jtAreaVenda.getColumnModel().getColumnCount() > 0) {
            jtAreaVenda.getColumnModel().getColumn(0).setMinWidth(60);
            jtAreaVenda.getColumnModel().getColumn(0).setMaxWidth(60);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 40, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastraAreaVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastraAreaVendaActionPerformed
        telaCadastraAreaVenda telaCadastraAreaVenda = new telaCadastraAreaVenda();
        telaCadastraAreaVenda.setVisible(true);
    }//GEN-LAST:event_btnCadastraAreaVendaActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        telaPrincipal telaPrincipal = new telaPrincipal();
        telaPrincipal.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(telaAreaVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaAreaVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaAreaVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaAreaVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaAreaVenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastraAreaVenda;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtAreaVenda;
    // End of variables declaration//GEN-END:variables
}
