/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.controllerNota;
import model.modelNota;

/**
 *
 * @author Joel
 */
public class telaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form telaPrincipal
     */
    public telaPrincipal() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
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
        btnAreaVenda = new javax.swing.JButton();
        btnFuncao = new javax.swing.JButton();
        btnRealizarVenda = new javax.swing.JButton();
        btnCliente = new javax.swing.JButton();
        btnProduto = new javax.swing.JButton();
        btnUsuario = new javax.swing.JButton();
        btnRelatorios = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);
        setSize(new java.awt.Dimension(1650, 1080));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Cambria", 1, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Controle de Vendas");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, -1, -1));

        btnAreaVenda.setFont(new java.awt.Font("Nirmala UI", 0, 24)); // NOI18N
        btnAreaVenda.setText("Areas de venda");
        btnAreaVenda.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAreaVenda.setVerifyInputWhenFocusTarget(false);
        btnAreaVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAreaVendaActionPerformed(evt);
            }
        });
        getContentPane().add(btnAreaVenda, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, 240, 60));

        btnFuncao.setFont(new java.awt.Font("Nirmala UI", 0, 24)); // NOI18N
        btnFuncao.setText("Funções");
        btnFuncao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFuncaoActionPerformed(evt);
            }
        });
        getContentPane().add(btnFuncao, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 420, 240, 60));

        btnRealizarVenda.setFont(new java.awt.Font("Nirmala UI", 1, 36)); // NOI18N
        btnRealizarVenda.setText("Realizar Venda");
        btnRealizarVenda.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRealizarVenda.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        btnRealizarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRealizarVendaActionPerformed(evt);
            }
        });
        getContentPane().add(btnRealizarVenda, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 110, 670, 70));

        btnCliente.setFont(new java.awt.Font("Nirmala UI", 0, 24)); // NOI18N
        btnCliente.setText("Cliente");
        btnCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClienteActionPerformed(evt);
            }
        });
        getContentPane().add(btnCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 240, 240, 60));

        btnProduto.setFont(new java.awt.Font("Nirmala UI", 0, 24)); // NOI18N
        btnProduto.setText("Produtos");
        btnProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProdutoActionPerformed(evt);
            }
        });
        getContentPane().add(btnProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 420, 240, 60));

        btnUsuario.setFont(new java.awt.Font("Nirmala UI", 0, 24)); // NOI18N
        btnUsuario.setText("Usuario");
        btnUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(btnUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 330, 240, 60));

        btnRelatorios.setFont(new java.awt.Font("Nirmala UI", 0, 24)); // NOI18N
        btnRelatorios.setText("Relatórios");
        btnRelatorios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRelatoriosActionPerformed(evt);
            }
        });
        getContentPane().add(btnRelatorios, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, 240, 60));

        setBounds(0, 0, 1301, 637);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAreaVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAreaVendaActionPerformed
        telaAreaVenda telaVenda = new telaAreaVenda();
        telaVenda.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnAreaVendaActionPerformed

    private void btnFuncaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFuncaoActionPerformed
        telaFuncoe telaFuncoe = new telaFuncoe();
        telaFuncoe.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnFuncaoActionPerformed

    private void btnUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuarioActionPerformed
        telaUsuario telaUsuario = new telaUsuario();
        telaUsuario.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnUsuarioActionPerformed

    private void btnProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProdutoActionPerformed
        telaProduto tela = new telaProduto();
        tela.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnProdutoActionPerformed

    private void btnClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClienteActionPerformed
        telaCliente telaCliente = new telaCliente();
        telaCliente.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnClienteActionPerformed

    private void btnRealizarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRealizarVendaActionPerformed
        model.modelNota nota = new modelNota();
        controller.controllerNota controller = new controllerNota();
        boolean cadastraNota = controller.CadastraNota(nota);
        telaRealizarVenda telaRealizarVenda = new telaRealizarVenda();
        telaRealizarVenda.setVisible(true);
    }//GEN-LAST:event_btnRealizarVendaActionPerformed

    private void btnRelatoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatoriosActionPerformed
        telaRelatorios telaRelatorios = new telaRelatorios();
        telaRelatorios.setVisible(true);
    }//GEN-LAST:event_btnRelatoriosActionPerformed

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
            java.util.logging.Logger.getLogger(telaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAreaVenda;
    private javax.swing.JButton btnCliente;
    private javax.swing.JButton btnFuncao;
    private javax.swing.JButton btnProduto;
    private javax.swing.JButton btnRealizarVenda;
    private javax.swing.JButton btnRelatorios;
    private javax.swing.JButton btnUsuario;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
