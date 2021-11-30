
package controller;

import database.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.modelNota;
import model.modelNotaProduto;

/**
 *
 * @author Joel
 */
public class controllerRealizarVenda {
    public boolean CadastraVenda(modelNotaProduto notaProduto){
        try{
            Connection con = Conexao.getConnection();
            ResultSet rs = null;
            PreparedStatement stmt = null;
            
            String wSQL = "insert into produto_nota values (default, ?, ?, ?, ?, ?) ";
            stmt = con.prepareStatement(wSQL);
            stmt.setInt(1, notaProduto.getId_produto()); 
            stmt.setInt(2, notaProduto.getId_nota()); 
            stmt.setInt(3, notaProduto.getQuantidade()); 
            stmt.setDouble(4, notaProduto.getValor_vendido());
            if(notaProduto.getId_vendedor() == 0){
                stmt.setNull(5, 0);    
            }
            else{
                stmt.setInt(5, notaProduto.getId_vendedor()); 
            }
            stmt.executeUpdate();
            return true;
        }catch(SQLException ex){
            System.out.println("ERRO de SQL: " + ex.getMessage());
            return false;
        }
        catch (Exception e) {
           System.out.println("ERRO: " + e.getMessage());
           return false;
        }    
    }
}
