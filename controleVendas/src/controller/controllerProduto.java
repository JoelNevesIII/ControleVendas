
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
public class controllerProduto {
    
    public boolean cadastraProduto(int areaVenda, String produto, String descricao, String quantidade, String estMax, String estMin, boolean controlaEst, String comissao, String valorVenda, String valorCusto){
        try{
            Connection con = Conexao.getConnection();
            ResultSet rs = null;
            PreparedStatement stmt = null;           
            String wSQL = "insert into produto values (default, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            stmt = con.prepareStatement(wSQL);
            
            //Definindo Area
            if(areaVenda == 0){
                CaixaDeDialogo.obterinstancia().exibirMensagem("Defina uma area de venda");      
            }else{
                stmt.setInt(1, areaVenda);
            }
            
            //Definindo o nome
            if(produto.equals("")){
                CaixaDeDialogo.obterinstancia().exibirMensagem("Defina o nome do produto");  
            }else{
                stmt.setString(2, produto);
            }
            
            //Definindo a descrição
            if(descricao.equals("")){
                CaixaDeDialogo.obterinstancia().exibirMensagem("Defina uma descrição"); 
            }else{
                stmt.setString(3, descricao);
            }
            
            //Define Quantidade
            if(quantidade.equals("")){
                CaixaDeDialogo.obterinstancia().exibirMensagem("Defina uma quantidade");  
            }else{
                stmt.setDouble(4, Double.parseDouble(quantidade));               
            }
            
            //Define se controla estoque
            if(controlaEst = false){
                stmt.setNull(5, 0);
                stmt.setNull(6, 0);
                stmt.setBoolean(7, false);
            }else{
                stmt.setBoolean(7, true);
                //Define estoque maximo
                if(estMax.equals("")){
                    CaixaDeDialogo.obterinstancia().exibirMensagem("Defina um estoque maximo");
                }
                else{stmt.setDouble(5, Double.parseDouble(estMax));
                }
                
                //Define estoque Minimo
                if(estMin.equals("")){
                    CaixaDeDialogo.obterinstancia().exibirMensagem("Defina um estoque minimo");
                }
                else{stmt.setDouble(6, Double.parseDouble(estMin));
                }
            }
            //Define Comissão
            if(comissao.equals("")){
                stmt.setDouble(8, 0);
            }else{
                stmt.setDouble(8, Double.parseDouble(comissao));
            }
            
            //Define Valor de Venda
            if(valorVenda.equals("")){
                CaixaDeDialogo.obterinstancia().exibirMensagem("Defina um valor de venda");
            }else{
                stmt.setDouble(9, Double.parseDouble(valorVenda));
            }
            
            //Define Valor de Custo
            if(valorCusto.equals("")){
                CaixaDeDialogo.obterinstancia().exibirMensagem("Defina um valor de custo");
            }
            else{stmt.setDouble(10, Double.parseDouble(valorCusto));
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
