/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;


import java.sql.SQLException;
import javax.swing.JComboBox;
import tools.CaixaDeDialogo;
import controller.controllerFuncao;
import tools.Combos;
import model.modelFuncao;


/**
 *
 * @author Joel
 */
public class telaCadastraFuncao extends javax.swing.JFrame {
    
    Combos comboAreaVenda;
    /**
     * Creates new form telaCadastraFuncao
     */
    public telaCadastraFuncao() {
        initComponents();
        
        try {   
            comboAreaVenda = new Combos(cbAreaVenda);
            comboAreaVenda.preencheCombo("SELECT id_area, nome FROM area_venda ORDER BY nome");
            
                       
        }catch (SQLException ex) {
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro no init");
        }
    }
    private boolean validardados(){  
        String erro = "";
            if(txtFuncao.getText().trim().equals("")){
                erro += "Defina uma função\n";
            }
            
            if(erro != ""){
                CaixaDeDialogo.obterinstancia().exibirMensagem("" + erro);
                return false;
        }
        return true;
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtFuncao = new javax.swing.JTextField();
        btnCadastrarFuncao = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        cbAreaVenda = new javax.swing.JComboBox<>();
        chRealizaraVendas = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        jLabel1.setText("Cadastrar Função");

        jLabel2.setText("Função");

        jLabel3.setText("Area de Venda");

        txtFuncao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFuncaoActionPerformed(evt);
            }
        });

        btnCadastrarFuncao.setText("Cadastrar função");
        btnCadastrarFuncao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarFuncaoActionPerformed(evt);
            }
        });

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        cbAreaVenda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbAreaVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAreaVendaActionPerformed(evt);
            }
        });

        chRealizaraVendas.setText("Realizará vendas");
        chRealizaraVendas.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbAreaVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(chRealizaraVendas)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtFuncao, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 107, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCadastrarFuncao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnFechar)
                        .addGap(34, 34, 34))))
            .addGroup(layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(jLabel1)
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtFuncao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbAreaVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chRealizaraVendas)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrarFuncao)
                    .addComponent(btnFechar))
                .addContainerGap(91, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarFuncaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarFuncaoActionPerformed
        modelFuncao funcao = new modelFuncao();
        funcao.setFuncao(txtFuncao.getText());   
        if(validardados()){
            if(chRealizaraVendas.isSelected() == true){
                funcao.setFuncao_venda(true);
                Combos area = (Combos) cbAreaVenda.getSelectedItem();
                int id_area = Integer.parseInt(area.getCodigo());
                funcao.setArea_venda(id_area);
            }else{
                funcao.setFuncao_venda(false);  
            }
            CaixaDeDialogo.obterinstancia().exibirMensagem("Função cadastrada: \n" + txtFuncao.getText());
        }
        
        controller.controllerFuncao controller = new controllerFuncao();
        boolean cadastraFuncao = controller.CadastraFuncao(funcao);
                
        
    }//GEN-LAST:event_btnCadastrarFuncaoActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void cbAreaVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAreaVendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbAreaVendaActionPerformed

    private void txtFuncaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFuncaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFuncaoActionPerformed

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
            java.util.logging.Logger.getLogger(telaCadastraFuncao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaCadastraFuncao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaCadastraFuncao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaCadastraFuncao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaCadastraFuncao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrarFuncao;
    private javax.swing.JButton btnFechar;
    private javax.swing.JComboBox<String> cbAreaVenda;
    private javax.swing.JCheckBox chRealizaraVendas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtFuncao;
    // End of variables declaration//GEN-END:variables
}
