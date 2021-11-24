/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.controllerCliente;
import java.sql.SQLException;
import model.modelBairro;
import model.modelCidade;
import model.modelEstado;
import tools.CaixaDeDialogo;
import tools.Combos;

/**
 *
 * @author Joel
 */
public class telaCadastraEndereco extends javax.swing.JFrame {
        Combos comboestados;
        Combos comboCidade;
    public telaCadastraEndereco() {
        initComponents();
        
        try {   
            
            preencheEstado();
            preencheCidades(); 
        }catch (Exception ex) {
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro no init");
        }
    }
    private boolean validardados(int identificacao){  
        String erro = "";
        if(identificacao == 1){
            if(txtUF.getText().trim().equals("")){
                erro += "Defina uma UF \n";
            }
            if(txtEstado.getText().trim().equals("")){
                erro += "Defina o estado \n";
            }
        }
        if(identificacao == 2){
            if(txtCidade.getText().trim().equals("")){
                erro+= "Deifina a cidade \n";
            }
            if(cbEstado.getSelectedIndex() <= 0){
                erro += "Defina um estado \n";
            }
        }
        if(identificacao == 3){
            if(txtBairro.getText().trim().equals("")){
                erro+= "Deifina o Bairro \n";
            }
            if(cbCidade.getSelectedIndex() <= 0){
                erro += "Defina uma cidade \n";
            }
        }
        if(erro != ""){
            CaixaDeDialogo.obterinstancia().exibirMensagem("" + erro);
            return false;
        }
        return true;
    }
    private void preencheCidades(){
        try {         
            comboCidade = new Combos(cbCidade);
            comboCidade.preencheCombo("SELECT id_cidade, nome FROM cidade ORDER BY nome"); 
        }catch (SQLException ex) {
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro no init");
        }
        
    }
    
    private void preencheEstado(){
          try {         
        comboestados = new Combos(cbEstado);
        comboestados.preencheCombo("SELECT id_estado, nome_estado FROM estado ORDER BY nome_estado");
        }catch (SQLException ex) {
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro no init");
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
        jLabel2 = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtUF = new javax.swing.JTextField();
        btnCadastraEstado = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCidade = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cbEstado = new javax.swing.JComboBox<>();
        btnCadastraCidade = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtBairro = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cbCidade = new javax.swing.JComboBox<>();
        btnCadastraBairro = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        jLabel1.setText("Cadastra Endereços");

        jLabel2.setText("Estado");

        jLabel3.setText("UF");

        btnCadastraEstado.setText("Cadastrar estado");
        btnCadastraEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastraEstadoActionPerformed(evt);
            }
        });

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel4.setText("Estado");

        jLabel5.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel5.setText("Cidade");

        jLabel6.setText("Cidade");

        txtCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCidadeActionPerformed(evt);
            }
        });

        jLabel7.setText("Estado");

        cbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnCadastraCidade.setText("Cadastrar Cidade");
        btnCadastraCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastraCidadeActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel8.setText("Bairro");

        jLabel9.setText("Bairro");

        jLabel10.setText("Cidade");

        cbCidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnCadastraBairro.setText("Cadastra Bairro");
        btnCadastraBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastraBairroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(27, 27, 27)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtUF, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(91, 91, 91)
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(279, 279, 279)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cbEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(btnCadastraCidade))))
                    .addComponent(btnCadastraEstado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtBairro)
                            .addComponent(cbCidade, 0, 182, Short.MAX_VALUE)))
                    .addComponent(btnCadastraBairro))
                .addGap(83, 83, 83))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnFechar)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(jLabel4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(243, 243, 243)
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(257, 257, 257)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addGap(150, 150, 150))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtUF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(cbCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastraEstado)
                    .addComponent(btnCadastraCidade)
                    .addComponent(btnCadastraBairro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(btnFechar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastraEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastraEstadoActionPerformed
        if(validardados(1) == true){
            modelEstado estado = new modelEstado();
            estado.setNome_estado(txtEstado.getText());
            estado.setUf(txtUF.getText());
            controller.controllerCliente controller = new controllerCliente();
            boolean cadastraCliente = controller.cadastraEstado(estado);
            preencheEstado();
            CaixaDeDialogo.obterinstancia().exibirMensagem("Estado cadastrado: \n" + txtEstado.getText());
        }
    }//GEN-LAST:event_btnCadastraEstadoActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void txtCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCidadeActionPerformed

    }//GEN-LAST:event_txtCidadeActionPerformed

    private void btnCadastraCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastraCidadeActionPerformed
        modelCidade cidade = new modelCidade();
        if(validardados(2) == true){
            cidade.setNome(txtCidade.getText());
            Combos uf =  (Combos) cbEstado.getSelectedItem();
            int idestado = Integer.parseInt(uf.getCodigo());   
            cidade.setId_estado(idestado);
            controller.controllerCliente controller = new controllerCliente(); 
            boolean controllerCliente = controller.cadastraCidade(cidade);
            preencheCidades();
            CaixaDeDialogo.obterinstancia().exibirMensagem("Cidade cadastrada: \n" + txtCidade.getText());
        }
    }//GEN-LAST:event_btnCadastraCidadeActionPerformed

    private void btnCadastraBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastraBairroActionPerformed
        modelBairro bairro = new modelBairro();
        if(validardados(3) == true){
            bairro.setNome(txtBairro.getText());
            Combos cidade =  (Combos) cbCidade.getSelectedItem();
            int idCidade = Integer.parseInt(cidade.getCodigo());
            bairro.setId_cidade(idCidade);

            controller.controllerCliente controller = new controllerCliente(); 
            boolean controllerCliente = controller.cadastraBairro(bairro);
            CaixaDeDialogo.obterinstancia().exibirMensagem("Bairro cadastrado: \n" + txtBairro.getText());
        }
    }//GEN-LAST:event_btnCadastraBairroActionPerformed

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
            java.util.logging.Logger.getLogger(telaCadastraEndereco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaCadastraEndereco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaCadastraEndereco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaCadastraEndereco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaCadastraEndereco().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastraBairro;
    private javax.swing.JButton btnCadastraCidade;
    private javax.swing.JButton btnCadastraEstado;
    private javax.swing.JButton btnFechar;
    private javax.swing.JComboBox<String> cbCidade;
    private javax.swing.JComboBox<String> cbEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtUF;
    // End of variables declaration//GEN-END:variables
}
