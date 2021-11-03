/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class controllerUsuario {

    /**
     * @param args the command line arguments
     */
    public boolean login (String user, String senha){
        try{
            Connection con = Conexao.getConnection();
            ResultSet rs = null;
            PreparedStatement stmt = null;

            String wSQL = " SELECT * FROM usuario where nome = ? AND senha = ?";
            stmt = con.prepareStatement(wSQL);
            stmt.setString(1, user);    
            stmt.setString(2, senha);

            rs = stmt.executeQuery();
            return rs.next();
        }
        catch(SQLException ex){
            System.out.println("ERRO de SQL: " + ex.getMessage());
            return false;
            }
        catch (Exception e) {
           System.out.println("ERRO: " + e.getMessage());
           return false;
        }    
    }
    
    public boolean cadastraUsuario(String usuario, String senha, int funcao){
    try{
            Connection con = Conexao.getConnection();
            ResultSet rs = null;
            PreparedStatement stmt = null;

            String wSQL = "INSERT INTO usuario VALUES (default, ?, ?, ?)";
            stmt = con.prepareStatement(wSQL);
             
            //Define Usuario
            if(usuario.equals("")){
                CaixaDeDialogo.obterinstancia().exibirMensagem("Define um usuario");
            }else{
                stmt.setString(1, usuario);
            }
            
            //Define Senha
            if(senha.equals("")){
                CaixaDeDialogo.obterinstancia().exibirMensagem("Defina uma senha");
            }else{
                stmt.setString(2, senha);
            }
            
            //Define Funcao
            if(funcao == 0){
                CaixaDeDialogo.obterinstancia().exibirMensagem("Defina uma função");
            }else{
                stmt.setInt(3, funcao);
            }

            stmt.executeUpdate();
            return rs.next();
        }
        catch(SQLException ex){
            System.out.println("ERRO de SQL: " + ex.getMessage());
            return false;
            }
        catch (Exception e) {
           System.out.println("ERRO: " + e.getMessage());
           return false;
        }    
        
    }
}
