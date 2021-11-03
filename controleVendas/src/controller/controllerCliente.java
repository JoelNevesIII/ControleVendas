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
public class controllerCliente {
    
    public boolean cadastraEstado(String estado, String uf){
        try{
            Connection con = Conexao.getConnection();
            ResultSet rs = null;
            PreparedStatement stmt = null;
            
            String wSQL = "insert into estado values (default, ?, ?)";
            stmt = con.prepareStatement(wSQL);
            
            if(estado.equals("")){
                CaixaDeDialogo.obterinstancia().exibirMensagem("Defina o estado");   
            }else{
                stmt.setString(1, uf);    
            }
            if(uf.equals("")){
                CaixaDeDialogo.obterinstancia().exibirMensagem("Defina a UF");  
            }else{
                stmt.setString(2, estado);
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
    
    public boolean cadastraCidade(String cidade, int uf){
        try{
            Connection con = Conexao.getConnection();
            ResultSet rs = null;
            PreparedStatement stmt = null;
            
            String wSQL = "insert into cidade values (default, ?, ?)";
            stmt = con.prepareStatement(wSQL);
            
            if(cidade.equals("")){
                CaixaDeDialogo.obterinstancia().exibirMensagem("Defina uma cidade");
            }else{
                stmt.setString(1, cidade);
            }
            if(uf == 0){
                CaixaDeDialogo.obterinstancia().exibirMensagem("Defina o estado da cidade");
            }else{
                stmt.setInt(2, uf);
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
    
    public boolean cadastraBairro(String bairro, int cidade){
        try{
            Connection con = Conexao.getConnection();
            ResultSet rs = null;
            PreparedStatement stmt = null;
            
            String wSQL = "insert into bairro values (default, ?, ?)";
            stmt = con.prepareStatement(wSQL);
            
            if(bairro.equals("")){
                CaixaDeDialogo.obterinstancia().exibirMensagem("Defina um bairro");
            }else{
                stmt.setString(1, bairro);
            }
            if(cidade == 0){
                CaixaDeDialogo.obterinstancia().exibirMensagem("Defina a cidade do bairro");
            }else{
                stmt.setInt(2, cidade);
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

