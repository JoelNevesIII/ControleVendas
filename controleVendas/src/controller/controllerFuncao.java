
package controller;

import database.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import tools.CaixaDeDialogo;


/**
 *
 * @author Joel
 */
public class controllerFuncao {
    public boolean CadastraFuncao(String funcao, String realizaVenda, int areaVenda){
       boolean vendera;
       try{
            Connection con = Conexao.getConnection();
            ResultSet rs = null;
            PreparedStatement stmt = null;
            
            String wSQL = "insert into funcao values (default, ?, ?, ?)";
            stmt = con.prepareStatement(wSQL);
            stmt.setString(1, funcao);
            if(realizaVenda.equals("Selecione")){
                CaixaDeDialogo.obterinstancia().exibirMensagem("Funcionario realizará venda?");
            }else{
                if(realizaVenda.equals("Sim")){
                    CaixaDeDialogo.obterinstancia().exibirMensagem("Sim");
                    vendera = true;
                    stmt.setBoolean(2, vendera);
                    stmt.setInt(3, areaVenda);
                }else{
                    CaixaDeDialogo.obterinstancia().exibirMensagem("Não");
                    vendera = false;
                    stmt.setBoolean(2, vendera);
                    stmt.setNull(3, areaVenda);
                };
            };     
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
