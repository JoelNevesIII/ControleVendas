package controller;

import database.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.modelCliente;
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
            
            String wSQL = " INSERT INTO cliente VALUES (default, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
            stmt = con.prepareStatement(wSQL);
            String erro= "";
           
            //Nome do cliente
            if(cliente.getNome().equals("")){
                erro += "Defina um nome ao cliente \n";
            }else{
                stmt.setString(1, cliente.getNome());
            }

            //Endereço
            if(cliente.getId_estado() <= 0 && cliente.getId_cidade() <= 0 && cliente.getId_bairro() <= 0){
                erro += "Verifique o endereço \n";
            }else{
                //Bairro
                stmt.setInt(2, cliente.getId_bairro());
                //Cidade
                stmt.setInt(3, cliente.getId_cidade());
                //Estado
                stmt.setInt(4, cliente.getId_estado());
            }
            //CPF ou CNPJ
            if(cliente.getCpf_cnpj().equals("")){
               erro += "Defina se será usado CPF ou CNPJ \n";
            }else{
                stmt.setString(5, cliente.getCpf_cnpj());
                
                if(cliente.getCpf_cnpj().equals("CPF")){
                    //CPF
                    if(cliente.getCpf().equals("")){
                        erro += "Defina o CPF \n";
                    }else{
                        stmt.setString(6, cliente.getCpf());
                        stmt.setString(7, cliente.getCnpj());
                    }
                }
                if(cliente.getCpf_cnpj().equals("CNPJ")){
                //CNPJ
                    if(cliente.getCnpj().equals("")){
                        erro += "Defina o CNPJ \n";
                    }else{
                        stmt.setString(7, cliente.getCnpj());
                        stmt.setString(6, cliente.getCpf());
                    }
            }
            //quantidade de compras inicial
            stmt.setInt(8, 0);
            //Rua
            if(cliente.getRua().equals("")){
               erro += "Defina o nome da rua \n";
            }else{
                stmt.setString(9, cliente.getRua());
            }
            //Numero da casa
            if(cliente.getNumero().equals("")){
                erro += "Defina o numero da casa \n";
            }else{
                stmt.setInt(10, Integer.parseInt(cliente.getNumero()));
            }
            if(erro != ""){
                CaixaDeDialogo.obterinstancia().exibirMensagem("" + erro);
            }
            stmt.executeUpdate();
            return rs.next();   
            }
        }catch(Exception e){
                return false;
        }
        return false;
    }
      
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

