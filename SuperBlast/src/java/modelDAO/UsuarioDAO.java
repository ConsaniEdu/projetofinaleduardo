/*
 * Classe responsável pela interação com a tabela usuario do banco de dados
 */

package modelDAO;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelBean.UsuarioDTO;

public class UsuarioDAO {
    
    // preparando a conexao com o banco
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    UsuarioDTO objUsuarioDTO = new UsuarioDTO();
    
    // funcao para autenticar o usuario
    public boolean Login(UsuarioDTO objUsuarioDTO){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean autenticacao = false;
        
        try {
            // estabelecendo conexao
            conn = Conexao.conectar();
            // seleciona o id do usuario de acordo com o email e senha
            stmt = conn.prepareStatement("SELECT id_usuario FROM usuario WHERE email = ? AND senha = ?");
            stmt.setString(1, objUsuarioDTO.getEmail());
            stmt.setString(2, objUsuarioDTO.getSenha());
            
            rs = stmt.executeQuery();
            
           
            if (rs.next()){
                objUsuarioDTO.setId_usuario(rs.getInt("id_usuario"));  
                UsuarioDTO.setIdUsuarioStatico(rs.getInt("id_usuario"));
                autenticacao = true;
            }
          
        } catch (SQLException e) {
            e.printStackTrace();
            
            JOptionPane.showMessageDialog(null, "Erro ao validar usuário: " + e.getMessage());
        } 
        
        return autenticacao;
    }
    
    // funcao para criar um novo usuario
    public void CriarUsuario(UsuarioDTO objUsuarioDTO) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            // estabelece conexao
            conn = Conexao.conectar();
            
            // insere no banco um novo usuario
            String sql = "INSERT INTO usuario (nome_usuario, senha, email, telefone, cpf) VALUES (?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            //insere nos paramentros necessarios para criar un novo usuario
            stmt.setString(1, objUsuarioDTO.getNome_usuario());
            stmt.setString(2, objUsuarioDTO.getSenha());
            stmt.setString(3, objUsuarioDTO.getEmail());
            stmt.setString(4, objUsuarioDTO.getTelefone());
            stmt.setString(5, objUsuarioDTO.getCpf());

           
            stmt.executeUpdate();

        } catch (SQLException e) {
           
            e.printStackTrace();
            throw new RuntimeException("Erro ao criar usuário: " + e.getMessage(), e); 

        } finally {
          
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
           
                e.printStackTrace();
            }
        }
    }
}
    

