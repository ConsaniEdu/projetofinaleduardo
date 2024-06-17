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
    
    // Atributos para conexão com o banco de dados e manipulação de resultados
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    UsuarioDTO objUsuarioDTO = new UsuarioDTO();
    
    // Método para realizar o login do usuário
    public boolean Login(UsuarioDTO objUsuarioDTO){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean isValidUser = false;
        
        try {
            // Estabelece a conexão com o banco de dados
            conn = Conexao.conectar();
            // Prepara a query SQL para selecionar o ID do usuário com base no email e senha fornecidos
            stmt = conn.prepareStatement("SELECT id_usuario FROM usuario WHERE email = ? AND senha = ?");
            stmt.setString(1, objUsuarioDTO.getEmail());
            stmt.setString(2, objUsuarioDTO.getSenha());
            
            // Executa a query
            rs = stmt.executeQuery();
            
            // Se houver um resultado, o usuário é válido
            if (rs.next()){
                objUsuarioDTO.setId_usuario(rs.getInt("id_usuario"));                
                isValidUser = true;
            }
          
        } catch (SQLException e) {
            e.printStackTrace();
            // Exibe uma mensagem de erro em caso de falha na validação do usuário
            JOptionPane.showMessageDialog(null, "Erro ao validar usuário: " + e.getMessage());
        } finally {
            // Fecha a conexão com o banco de dados
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return isValidUser;
    }
    
    // Método para criar um novo usuário
    public void CriarUsuario(UsuarioDTO objUsuarioDTO) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            // Estabelece a conexão com o banco de dados
            conn = Conexao.conectar();
            
            // Prepara a query SQL para inserir um novo usuário na tabela
            String sql = "INSERT INTO usuario (nome_usuario, senha, email, telefone, cpf) VALUES (?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);

            // Define os parâmetros da query com base no objeto UsuarioDTO fornecido
            stmt.setString(1, objUsuarioDTO.getNome_usuario());
            stmt.setString(2, objUsuarioDTO.getSenha());
            stmt.setString(3, objUsuarioDTO.getEmail());
            stmt.setString(4, objUsuarioDTO.getTelefone());
            stmt.setString(5, objUsuarioDTO.getCpf());

            // Executa a query de inserção
            stmt.executeUpdate();

        } catch (SQLException e) {
           
            e.printStackTrace();
            throw new RuntimeException("Erro ao criar usuário: " + e.getMessage(), e); // Lança uma exceção para o caller tratar

        } finally {
          
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                // Em caso de erro ao fechar a conexão, imprime o stack trace (ou faça log adequado)
                e.printStackTrace();
                // Não lança exceção aqui para evitar mascarar a exceção original
            }
        }
    }
}
    

