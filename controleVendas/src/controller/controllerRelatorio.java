/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author Joel
 */
import database.Conexao;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author jonasdhein
 */
public class controllerRelatorio {
        
    public ResultSet buscarRelatorio(String wSelect)
    {
        ResultSet rs = null;
        try {
            Conexao.abreConexao();
            
            String wSql = "";
            wSql = wSelect;

            try{
                System.out.println("Vai Executar Conexão em buscar");
                rs = Conexao.stmt.executeQuery(wSql);
            }

            catch (SQLException ex )
            {
                System.out.println("ERRO de SQL: " + ex.getMessage());
                return rs;
            }

        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
            return rs;
        }
        
        System.out.println ("Executou buscar com sucesso");
        return rs;
    }
    
    
    
}

