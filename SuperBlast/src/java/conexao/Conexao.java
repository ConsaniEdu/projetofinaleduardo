/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class Conexao {
    
    //aqui passo o caminho para o banco, o usuario, a senha e o conectador jdbc

    private static final String url = "jdbc:mysql://localhost:3306/bancoprojetofinal?useSSL=false";
    private static final String usuario = "root";
    private static final String senha = "5550123";
    private static final String driver = "com.mysql.cj.jdbc.Driver";

    public static Connection conectar() {
       
        //aqui onde eu faço a conexao com o banco
        
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, usuario, senha);
            return conn;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

}
