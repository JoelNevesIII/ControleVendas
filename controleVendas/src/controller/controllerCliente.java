package controller;

import database.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.modelBairro;
import model.modelCidade;
import model.modelCliente;
import model.modelEstado;
import tools.CaixaDeDialogo;

/**
 *
 * @author Joel
 */
public class controllerCliente {
    
    public boolean cadastraCliente(modelCliente cliente){
        try{
            Connection con = Conexao.getConnection();
            ResultSet rs = null;
            PreparedStatement stmt = null;
            
            String wSQL = " INSERT INTO cliente(id_cliente, nome, id_bairro, id_cidade, id_estado, cpf_cnpj, cpf, cnpj, qt_compras, rua, numero) VALUES (default, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
            stmt = con.prepareStatement(wSQL);         
            //Nome do cliente
            stmt.setString(1, cliente.getNome());
            //Bairro
            stmt.setInt(2, cliente.getId_bairro());
            //Cidade
            stmt.setInt(3, cliente.getId_cidade());
            //Estado
            stmt.setInt(4, cliente.getId_estado());
            //CPF ou CNPJ
            stmt.setString(5, cliente.getCpf_cnpj());
            //CPF
            stmt.setString(6, cliente.getCpf());
            //CNPJ
            stmt.setString(7, cliente.getCnpj());
            //Quantidade de compras inicial
            stmt.setInt(8, 0);
            //Rua
            stmt.setString(9, cliente.getRua());
            //Numero da casa
            stmt.setInt(10, Integer.parseInt(cliente.getNumero()));
            
            stmt.executeUpdate();
            return rs.next();   
            
        }catch(Exception e){
                return false;
        }
    }
    public boolean cadastraEstado(modelEstado estado){
        try{
            Connection con = Conexao.getConnection();
            ResultSet rs = null;
            PreparedStatement stmt = null;
            
            String wSQL = "insert into estado values (default, ?, ?)";
            stmt = con.prepareStatement(wSQL);
            
            stmt.setString(1, estado.getUf());    
            stmt.setString(2, estado.getNome_estado());
            
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
    
    public boolean cadastraCidade(modelCidade cidade){
        try{
            Connection con = Conexao.getConnection();
            ResultSet rs = null;
            PreparedStatement stmt = null;
            
            String wSQL = "insert into cidade values (default, ?, ?)";
            stmt = con.prepareStatement(wSQL);
            stmt.setString(1, cidade.getNome());
            stmt.setInt(2, cidade.getId_estado());
            
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
    
    public boolean cadastraBairro(modelBairro bairro){
        try{
            Connection con = Conexao.getConnection();
            ResultSet rs = null;
            PreparedStatement stmt = null;
            
            String wSQL = "insert into bairro values (default, ?, ?)";
            stmt = con.prepareStatement(wSQL);
            stmt.setString(1, bairro.getNome());
            stmt.setInt(2, bairro.getId_cidade());
            
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

