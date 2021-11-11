/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.controllerNumeros;
import java.sql.SQLException;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import tools.CaixaDeDialogo;
import tools.Combos;
import controller.controllerCliente;
import model.modelCliente;

/**
 *
 * @author Joel
 */
public class telaCadastraCliente extends javax.swing.JFrame {
    
        Combos comboestados;
        Combos comboCidade;
        Combos comboBairro;
        modelCliente cliente = new modelCliente();
        
    public telaCadastraCliente() {
        initComponents();
        txtNumero.setDocument(new controllerNumeros());
        txtCpf.setDocument(new controllerNumeros());
        txtCnpj.setDocument(new controllerNumeros());
        RCpf.setSelected(true);
        if(RCpf.isSelected() == true){
            txtCnpj.setText("");
            txtCnpj.setEnabled(false);
            txtCpf.setEnabled(true);
            cliente.setCpf_cnpj("CPF");
        }else{
            txtCnpj.setEnabled(true);
        }       
        
        try {    
            preencheEstado();
            preencheCidades(0);
            preencheBairro(0);
        }catch (Exception ex) {
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro no init");
        }
    }
    private boolean validardados(){  
        String erro = "";
        if(txtNome.getText().trim().equals("")){
            erro += "Defina um nome \n";
        }
        if(cbCidade.getSelectedIndex() <= 0 || cbEstado.getSelectedIndex() <= 0 || cbBairro.getSelectedIndex() <= 0){
            erro += "Defina um endereço valido \n";
        }
        if(txtRua.getText().trim().equals("")){
            erro += "Defina uma rua \n";
        }
        if(txtNumero.getText().trim().equals("")){
            erro += "Defina um número da residencia \n";
        }
        if(txtCpf.getText().trim().equals("") && RCpf.isSelected()){
            erro += "Defina o CPF \n";
        }
        if(txtCnpj.getText().trim().equals("") && RCnpj.isSelected()){
            erro += "Defina o CNPJ \n";
        }
        if(erro != ""){
            CaixaDeDialogo.obterinstancia().exibirMensagem("" + erro);
            return false;
        }
            return true;      
    }
    
    private void preencheCidades(int estado){
        try {         
            comboCidade = new Combos(cbCidade);
            comboCidade.preencheCombo("SELECT id_cidade, nome FROM cidade where id_estado = "+estado+" ORDER BY nome"); 
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
    private void preencheBairro(int id_cidade){
        try {         
            comboBairro = new Combos(cbBairro);
            comboBairro.preencheCombo("SELECT id_bairro, nome FROM bairro where id_cidade = "+id_cidade+" ORDER BY nome");
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

        cpf_cnpj = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        cbEstado = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbCidade = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cbBairro = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtRua = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        RCpf = new javax.swing.JRadioButton();
        RCnpj = new javax.swing.JRadioButton();
        txtCpf = new javax.swing.JTextField();
        txtCnpj = new javax.swing.JTextField();
        btnCadastraCliente = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cadastra Clientes");

        jLabel2.setText("Nome");

        cbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbEstado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbEstadoItemStateChanged(evt);
            }
        });

        jLabel3.setText("Estado");

        jLabel4.setText("Cidade");

        cbCidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbCidade.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbCidadeItemStateChanged(evt);
            }
        });

        jLabel5.setText("Bairro");

        cbBairro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setText("Rua");

        jLabel7.setText("Número");

        cpf_cnpj.add(RCpf);
        RCpf.setText("CPF");
        RCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RCpfActionPerformed(evt);
            }
        });

        cpf_cnpj.add(RCnpj);
        RCnpj.setText("CNPJ");
        RCnpj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RCnpjActionPerformed(evt);
            }
        });

        txtCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCpfActionPerformed(evt);
            }
        });

        btnCadastraCliente.setText("Cadastrar Cliente");
        btnCadastraCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastraClienteActionPerformed(evt);
            }
        });

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel2)
                        .addGap(3, 3, 3)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel3)
                        .addGap(7, 7, 7)
                        .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel4)
                        .addGap(7, 7, 7)
                        .addComponent(cbCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel5)
                        .addGap(12, 12, 12)
                        .addComponent(cbBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel6)
                        .addGap(11, 11, 11)
                        .addComponent(txtRua, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(jLabel7)
                        .addGap(13, 13, 13)
                        .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(RCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(RCnpj)
                        .addGap(19, 19, 19)
                        .addComponent(txtCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(btnCadastraCliente)
                        .addGap(183, 183, 183)
                        .addComponent(btnFechar)))
                .addContainerGap(46, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(121, 121, 121))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel1)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(cbCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(cbBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RCpf)
                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RCnpj)
                    .addComponent(txtCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCadastraCliente)
                    .addComponent(btnFechar))
                .addContainerGap(69, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastraClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastraClienteActionPerformed
        try{ 
            if(validardados() == true){
                cliente.setNome(txtNome.getText()); 
                
                Combos bairro = (Combos) cbBairro.getSelectedItem();
                int id_bairro = Integer.parseInt(bairro.getCodigo());
                cliente.setId_bairro(id_bairro);

                Combos cidade = (Combos) cbCidade.getSelectedItem();
                int id_cidade = Integer.parseInt(cidade.getCodigo());
                cliente.setId_cidade(id_cidade);

                Combos estado = (Combos) cbEstado.getSelectedItem();
                int id_estado = Integer.parseInt(estado.getCodigo());
                cliente.setId_estado(id_estado);
                
                cliente.setRua(txtRua.getText());
                
                cliente.setNumero(txtNumero.getText());
                
                 cliente.setCpf(txtCpf.getText());
                 cliente.setCnpj(txtCnpj.getText());
            }
               
            controller.controllerCliente controller = new controllerCliente();
            boolean cadastraCliente = controller.cadastraCliente(cliente);
        }catch(Exception e){
            
        }
    }//GEN-LAST:event_btnCadastraClienteActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void RCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RCpfActionPerformed
       
        if(RCpf.isSelected() == true){
            txtCnpj.setText("");
            txtCnpj.setEnabled(false);
            txtCpf.setEnabled(true);
            cliente.setCpf_cnpj("CPF");
       }else{
            txtCnpj.setEnabled(true);
       }       
    }//GEN-LAST:event_RCpfActionPerformed

    private void txtCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCpfActionPerformed

    private void RCnpjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RCnpjActionPerformed
        if(RCnpj.isSelected() == true){
            txtCpf.setText("");
            txtCpf.setEnabled(false);
            txtCnpj.setEnabled(true);
            cliente.setCpf_cnpj("CNPJ");

       }else{
            txtCpf.setEnabled(false);
       }
    }//GEN-LAST:event_RCnpjActionPerformed

    private void cbEstadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbEstadoItemStateChanged
        try{
            Combos uf =  (Combos) cbEstado.getSelectedItem();
            int idestado = Integer.parseInt(uf.getCodigo());
            preencheCidades(idestado);
        }catch(Exception e){
            
        }
    }//GEN-LAST:event_cbEstadoItemStateChanged

    private void cbCidadeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbCidadeItemStateChanged
        try{
            Combos cidade =  (Combos) cbCidade.getSelectedItem();
            int id_cidade = Integer.parseInt(cidade.getCodigo());
            preencheBairro(id_cidade);
        }catch(Exception e){
            
        }
    }//GEN-LAST:event_cbCidadeItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton RCnpj;
    private javax.swing.JRadioButton RCpf;
    private javax.swing.JButton btnCadastraCliente;
    private javax.swing.JButton btnFechar;
    private javax.swing.JComboBox<String> cbBairro;
    private javax.swing.JComboBox<String> cbCidade;
    private javax.swing.JComboBox<String> cbEstado;
    private javax.swing.ButtonGroup cpf_cnpj;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtCnpj;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtRua;
    // End of variables declaration//GEN-END:variables
}
