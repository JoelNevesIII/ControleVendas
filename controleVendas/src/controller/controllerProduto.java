
package controller;

import database.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.modelProduto;
import tools.CaixaDeDialogo;

/**
 *
 * @author Joel
 */
public class controllerProduto {
    
    public boolean cadastraProduto(modelProduto produto){
        try{
            Connection con = Conexao.getConnection();
            ResultSet rs = null;
            PreparedStatement stmt = null;           
            String wSQL = "insert into produto values (default, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            stmt = con.prepareStatement(wSQL);
            
            //Definindo Area
            stmt.setInt(1, produto.getId_area());
            //Definindo o nome
            stmt.setString(2, produto.getNome());
            //Definindo a descrição
            stmt.setString(3, produto.getDescricao());   
            //Define Quantidade
            stmt.setDouble(4, produto.getQuantidade());                      
            //Define se controla estoque
            stmt.setBoolean(7, produto.isControla_est()); 
            //Define estoque maximo
            stmt.setDouble(5, produto.getEst_max());
            //Define estoque Minimo
            stmt.setDouble(6, produto.getEst_min());
            //Define Comissão
            stmt.setDouble(8, produto.getComissao());
            //Define Valor de Venda
            stmt.setDouble(9, produto.getValor_venda()); 
            //Define Valor de Custo
            stmt.setDouble(10, produto.getValor_custo());
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
