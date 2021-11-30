/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.controllerNota;
import database.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import controller.controllerNumeros;
import controller.controllerRealizarVenda;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.modelNota;
import model.modelNotaProduto;
import tools.CaixaDeDialogo;
import tools.Combos;

/**
 *
 * @author Joel
 */
public class telaRealizarVenda extends javax.swing.JFrame {

    /**
     * Creates new form telaRealizarVenda
     */
    public telaRealizarVenda() {
        try{
        initComponents();
        txtQuantidade.setDocument(new controller.controllerNumeros());
        carregaTabelaProduto("");
        carregaTabelaCliente("");
        carregaNotaProduto(0);
        Combos comboVendedor;
        Connection con = Conexao.getConnection();
        ResultSet rs = null;
        PreparedStatement stmt = null;
            
        stmt = con.prepareStatement("SELECT Max(id_nota) FROM nota");
        
        rs = stmt.executeQuery();
        while(rs.next()){
            txtId.setText(rs.getString(1));
        }
            comboVendedor = new Combos(cbVendedor);
            comboVendedor.preencheCombo("select u.id_usuario, u.nome from usuario u, funcao f\n" +
                                        "where f.id_funcao = u.id_funcao and f.funcao_venda = true");
            
        }catch(Exception e){
            
        }
    }
    private boolean validardados(){  
        String erro = "";
        if(!(jtClientes.getSelectedRowCount() > 0)){
            erro += "Defina um cliente \n";
        }
        if(!(jtProduto.getSelectedRowCount() > 0)){
            erro += "Defina um Produto \n";
        }
        if(txtQuantidade.getText().trim().equals("")){
            erro += "Defina uma Quantidade \n";
        }
        if(erro != ""){
            CaixaDeDialogo.obterinstancia().exibirMensagem("" + erro);
            return false;
        }
        return true;      
    }
    
        private void carregaTabelaProduto(String filtro){
        DefaultTableModel modelo = (DefaultTableModel) jtProduto.getModel();
        modelo.setNumRows(0);
        
        jtProduto.getColumnModel().getColumn(0).setPreferredWidth(80);
        jtProduto.getColumnModel().getColumn(1).setPreferredWidth(20);
        jtProduto.getColumnModel().getColumn(2).setPreferredWidth(20);
        
        try{
            Connection con = Conexao.getConnection();
            ResultSet rs = null;
            PreparedStatement stmt = null;
            
            stmt = con.prepareStatement("select nome,concat('R$ ',valor_venda), id_produto from produto where nome like '%"+filtro+"%'");
            
            rs = stmt.executeQuery();
            
            while(rs.next()){
                modelo.addRow(new Object[]{
                    rs.getString(1),
                    rs.getString(2),
                    rs.getInt(3)
                });
            }
            
            Conexao.closeConnection(con);
        }catch(Exception e){
            
        }
    }

        private void carregaTabelaCliente(String filtro){
        DefaultTableModel modelo = (DefaultTableModel) jtClientes.getModel();
        modelo.setNumRows(0);
        
        jtClientes.getColumnModel().getColumn(0).setPreferredWidth(80);
        jtClientes.getColumnModel().getColumn(1).setPreferredWidth(20);
        jtClientes.getColumnModel().getColumn(2).setPreferredWidth(20);
        
        try{
            Connection con = Conexao.getConnection();
            ResultSet rs = null;
            PreparedStatement stmt = null;
            
            stmt = con.prepareStatement("select nome, qt_compras, id_cliente from cliente where nome like '%"+filtro+"%'");
            
            rs = stmt.executeQuery();
            
            while(rs.next()){
                modelo.addRow(new Object[]{
                    rs.getString(1),
                    rs.getInt(2),
                    rs.getInt(3)
                });
            }
            
            Conexao.closeConnection(con);
        }catch(Exception e){
            
        }

    }
    private void carregaNotaProduto(Integer filtro){
        DefaultTableModel modelo = (DefaultTableModel) jtNotaProduto.getModel();
        modelo.setNumRows(0);
        
        jtNotaProduto.getColumnModel().getColumn(0).setPreferredWidth(80);
        jtNotaProduto.getColumnModel().getColumn(1).setPreferredWidth(20);
        jtNotaProduto.getColumnModel().getColumn(2).setPreferredWidth(20);
        
        try{
            Connection con = Conexao.getConnection();
            ResultSet rs = null;
            PreparedStatement stmt = null;
            
            stmt = con.prepareStatement("select p.nome, concat('R$ ',p.valor_venda), pn.quantidade from produto_nota pn, produto p\n" +
                                        "where pn.id_produto = p.id_produto\n" +
                                        "and pn.id_nota = " + filtro );
            
            rs = stmt.executeQuery();
            
            while(rs.next()){
                modelo.addRow(new Object[]{
                    rs.getString(1),
                    rs.getString(2),
                    rs.getInt(3)
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
        jLabel2 = new javax.swing.JLabel();
        txtPesquisaProduto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtProduto = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JTextField();
        btnAdicionar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtNotaProduto = new javax.swing.JTable();
        btnFinalizar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtId = new javax.swing.JLabel();
        btnFechar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtPesquisaCliente = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtClientes = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtClienteSelecionado = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbVendedor = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Cambria", 1, 36)); // NOI18N
        jLabel1.setText("Realizar Venda");

        jLabel2.setText("Pesquisar");

        txtPesquisaProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesquisaProdutoActionPerformed(evt);
            }
        });
        txtPesquisaProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPesquisaProdutoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisaProdutoKeyReleased(evt);
            }
        });

        jtProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Produto", "Valor", "ID"
            }
        ));
        jtProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtProdutoMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtProduto);

        jLabel3.setText("Quantidade");

        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jLabel4.setText("Produtos Selecionados");

        jtNotaProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Produto", "Valor", "Quantidade"
            }
        ));
        jScrollPane2.setViewportView(jtNotaProduto);

        btnFinalizar.setText("Finalizar Venda");
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });

        jLabel5.setText("Codigo da Nota");

        txtId.setText("ID");

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jLabel7.setText("Selecionar o cliente");

        jLabel8.setText("Pesquisar");

        txtPesquisaCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisaClienteKeyReleased(evt);
            }
        });

        jtClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nome", "Quantidade de Compras", "ID"
            }
        ));
        jScrollPane3.setViewportView(jtClientes);

        jLabel9.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jLabel9.setText("Adicionar Produto");

        jLabel10.setText("Cliente:");

        jLabel6.setText("Vendedor");

        cbVendedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbVendedorActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("TOTAL");

        txtTotal.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtTotal.setText("         ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(164, 164, 164)
                .addComponent(jLabel4)
                .addGap(121, 121, 121))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtId)
                        .addGap(153, 153, 153)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(jLabel7))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPesquisaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(jLabel9)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPesquisaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(194, 194, 194)
                        .addComponent(btnFechar)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(txtTotal)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtClienteSelecionado)))
                        .addContainerGap(24, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnFinalizar)
                        .addGap(111, 111, 111))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtId)
                    .addComponent(jLabel10)
                    .addComponent(txtClienteSelecionado)
                    .addComponent(jLabel6)
                    .addComponent(cbVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtPesquisaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtPesquisaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAdicionar)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtTotal))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFechar)
                    .addComponent(btnFinalizar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPesquisaProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisaProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesquisaProdutoActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        try{
            Connection con = Conexao.getConnection();
            ResultSet rs = null;
            PreparedStatement stmt = null;
            PreparedStatement stmt2 = null;
            
            stmt = con.prepareStatement("DELETE FROM produto_nota WHERE id_nota = " + txtId.getText() + ";\n" +
                                        "DELETE FROM nota WHERE id_nota = " + txtId.getText());
            rs = stmt.executeQuery();
            
            Conexao.closeConnection(con);
        }catch(Exception e){
            
        }
        dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void txtPesquisaProdutoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaProdutoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesquisaProdutoKeyPressed

    private void txtPesquisaProdutoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaProdutoKeyReleased
        try{
            String filtro = txtPesquisaProduto.getText();
            carregaTabelaProduto(filtro);
            
        }catch(Exception ex){
            
        }
    }//GEN-LAST:event_txtPesquisaProdutoKeyReleased

    private void txtPesquisaClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaClienteKeyReleased
        try{
            String filtro = txtPesquisaCliente.getText();
            carregaTabelaCliente(filtro);
            
        }catch(Exception ex){
            
        }
    }//GEN-LAST:event_txtPesquisaClienteKeyReleased

    private void jtProdutoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtProdutoMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtProdutoMousePressed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        //Criando a nota
        try{
        modelNotaProduto notaProduto = new modelNotaProduto();
        if(validardados()){
            modelNota nota = new modelNota();
            int cliente = jtClientes.getSelectedRow();
            String id_cliente = jtClientes.getModel().getValueAt(cliente, 2).toString();
            String id_cliente_sele = jtClientes.getModel().getValueAt(cliente, 0).toString();

            //Id Cliente
            nota.setId_cliente(cliente + 1);
            controller.controllerNota controller = new controllerNota();
            boolean AlteraNota = controller.AlteraNota(nota);
            txtClienteSelecionado.setText(id_cliente_sele);

            //Produto
            int produto = jtProduto.getSelectedRow();
            String id_produto = jtProduto.getModel().getValueAt(produto, 2).toString();
            notaProduto.setId_produto(Integer.parseInt(id_produto));
            
            //id nota
            int id_nota = Integer.parseInt(txtId.getText());
            notaProduto.setId_nota(id_nota);
            
            
            //Quantidade
            notaProduto.setQuantidade(Integer.parseInt(txtQuantidade.getText()));
            
            //Id Vendedor
            Combos vendedor = (Combos) cbVendedor.getSelectedItem();
            int id_vendedor = Integer.parseInt(vendedor.getCodigo());
            notaProduto.setId_vendedor(id_vendedor);
            jtClientes.disable();
                
            //Valor vendido
            Connection con = Conexao.getConnection();
            ResultSet rs = null;
            PreparedStatement stmt = null;
            stmt = con.prepareStatement("select valor_venda from produto where id_produto = " + id_produto);

            rs = stmt.executeQuery();
            
            while(rs.next()){
                notaProduto.setValor_vendido(rs.getInt(1));
            }
            
        }
        
            controller.controllerRealizarVenda controller = new controller.controllerRealizarVenda();
            boolean RealizarVenda = controller.CadastraVenda(notaProduto);
            
            

            Connection con = Conexao.getConnection();
            ResultSet rs = null;
            PreparedStatement stmt = null;
            
            stmt = con.prepareStatement("select sum(valor_vendido) from produto_nota where id_nota = " + txtId.getText());
            rs = stmt.executeQuery();
            
            while(rs.next()){
                txtTotal.setText("R$ " + Integer.parseInt(rs.getString(1)) * Integer.parseInt(txtQuantidade.getText()));
                notaProduto.setValor_total(Integer.parseInt(rs.getString(1)) * Integer.parseInt(txtQuantidade.getText()));
                
            }
                stmt = con.prepareStatement("update nota set valor_total = " + notaProduto.getValor_total() + " where id_nota = " + txtId.getText());          
                rs = stmt.executeQuery();
                       
            } catch (SQLException ex) {
               
            }    
        carregaNotaProduto(Integer.parseInt(txtId.getText()));
        txtQuantidade.setText("");
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void cbVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbVendedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbVendedorActionPerformed

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        telaTroco telaTroco = new telaTroco();
        telaTroco.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnFinalizarActionPerformed

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
            java.util.logging.Logger.getLogger(telaRealizarVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaRealizarVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaRealizarVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaRealizarVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                    new telaRealizarVenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JComboBox<String> cbVendedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jtClientes;
    private javax.swing.JTable jtNotaProduto;
    private javax.swing.JTable jtProduto;
    private javax.swing.JLabel txtClienteSelecionado;
    private javax.swing.JLabel txtId;
    private javax.swing.JTextField txtPesquisaCliente;
    private javax.swing.JTextField txtPesquisaProduto;
    private javax.swing.JTextField txtQuantidade;
    private javax.swing.JLabel txtTotal;
    // End of variables declaration//GEN-END:variables
}
