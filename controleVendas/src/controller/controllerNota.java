
package controller;

import database.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.modelNota;


/**
 *
 * @author Joel
 */
public class controllerNota {
    public boolean CadastraNota(modelNota nota){
        try{
            Connection con = Conexao.getConnection();
            ResultSet rs = null;
            PreparedStatement stmt = null;
            
            String wSQL = "insert into nota values (default, ?) ";
            stmt = con.prepareStatement(wSQL);
            stmt.setInt(1, nota.getId_cliente());    
            
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
