
package controller;

import database.Conexao;
import static database.Conexao.stmt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import tools.CaixaDeDialogo;
import model.modelFuncao;



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
            
            if(funcao.isFuncao_venda()){
                stmt.setBoolean(2, true);
                stmt.setInt(3, funcao.getArea_venda());
            }
            CaixaDeDialogo.obterinstancia().exibirMensagem("" + funcao.isFuncao_venda() + "\n" + funcao.getFuncao() + "\n" + funcao.getArea_venda());
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
}

