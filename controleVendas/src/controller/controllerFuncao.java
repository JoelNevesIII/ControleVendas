
package controller;

import database.Conexao;
import static database.Conexao.stmt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import tools.CaixaDeDialogo;
import model.modelFuncao;
import model.modelAtribuifuncao;
import model.modelAtribuifuncao;



/**
 *
 * @author Joel
 */
public class controllerFuncao {
    public boolean CadastraFuncao(modelFuncao funcao){

       try{
            Connection con = Conexao.getConnection();
            ResultSet rs = null;
            PreparedStatement stmt = null;
            
            String wSQL = "insert into funcao values (default, ?, ?, ?)";
            stmt = con.prepareStatement(wSQL);
            stmt.setString(1, funcao.getFuncao());
            stmt.setBoolean(2, funcao.isFuncao_venda());
            if(funcao.getArea_venda() == 0){
                stmt.setNull(3, 0);
            }else{
                stmt.setInt(3, funcao.getArea_venda());
            }
            stmt.executeUpdate();
            return rs.next();           
        }catch(SQLException ex){
            System.out.println("ERRO de SQL: " + ex.getMessage());
            return false;
        }
        catch (Exception e) {
           System.out.println("ERRO: " + e.getMessage());
           return false;
        }    
    }
    public boolean atribuiFuncao(modelAtribuifuncao funcao){

       try{
            Connection con = Conexao.getConnection();
            ResultSet rs = null;
            PreparedStatement stmt = null;
            
            String wSQL = "UPDATE usuario SET id_funcao = ? WHERE id_usuario = ?";
            stmt = con.prepareStatement(wSQL);
            stmt.setInt(1 , funcao.getId_funcao());
            stmt.setInt(2, funcao.getId_usuario());
            
            stmt.executeUpdate();
            return true;

        }
        catch (Exception e) {
           System.out.println("ERRO: " + e.getMessage());
           return false;
        }    
    } 
}

