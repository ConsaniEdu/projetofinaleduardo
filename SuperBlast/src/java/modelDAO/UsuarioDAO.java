/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelDAO;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelBean.UsuarioDTO;

/**
 *
 * @author Eduardo Consani
 */
public class UsuarioDAO {
    
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    UsuarioDTO objUsuarioDTO = new UsuarioDTO();
    
    
    public void Login(UsuarioDTO objUsuarioDTO){
            
        try {
            conn = Conexao.conectar();
            stmt = conn.prepareStatement("SELECT id_usuario FROM usuario WHERE email = ? AND senha = ?");
            stmt.setString(1, objUsuarioDTO.getEmail());
            stmt.setString(2, objUsuarioDTO.getSenha());
            
            rs = stmt.executeQuery();
            
            if (rs.next()){
                objUsuarioDTO.setId_usuario(rs.getInt("id_usuario"));                
            
            }
          
            rs.close();
            stmt.close();
            conn.close();
            
        } catch (Exception e) {
        }
        
        
    }
    
    public void CriarUsuario(UsuarioDTO objUsuarioDTO){
        
        try {
            conn = Conexao.conectar();
            stmt = conn.prepareStatement("INSERT INTO usuario (nome_usuario, senha, email, telefone, cpf) VALUES (?, ?, ? , ?, ?)");
            
            stmt.setString(1, objUsuarioDTO.getNome_usuario());
            stmt.setString(2, objUsuarioDTO.getSenha());
            stmt.setString(3, objUsuarioDTO.getEmail());
            stmt.setString(4, objUsuarioDTO.getTelefone());
            stmt.setString(5, objUsuarioDTO.getCpf());
            
            stmt.executeUpdate();
            
            conn.close();
            stmt.close();
            
        } catch (SQLException e) {
           e.printStackTrace();
            JOptionPane.showMessageDialog(null,"USUARIODAO CREATE" + e);
        }
        
    }
    
}
