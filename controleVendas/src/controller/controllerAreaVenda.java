
package controller;

import database.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.modelAreaVenda;


public class controllerAreaVenda {
    
    public boolean CadastraAreaVenda(modelAreaVenda area){
        try{
            Connection con = Conexao.getConnection();
            ResultSet rs = null;
            PreparedStatement stmt = null;
            
            String wSQL = "insert into area_venda values (default, ?)";
            stmt = con.prepareStatement(wSQL);
            stmt.setString(1, area.getNome());    
            
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
