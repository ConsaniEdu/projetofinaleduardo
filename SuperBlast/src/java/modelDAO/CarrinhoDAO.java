package modelDAO;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelBean.CarrinhoDTO;

public class CarrinhoDAO {
    
    
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
    
    // funcao para listar os itens do carrinho
    public List <CarrinhoDTO> ListarCarrinho(){
        
        // armazenar os itens do carrinho na lista
        List <CarrinhoDTO> objCategoriaDTO = new ArrayList<>();
    
        try {
            // Estabelece a conexão com o banco de dados
            conn = Conexao.conectar();
            // Prepara a query SQL para selecionar todos os itens do carrinho
            stmt = conn.prepareStatement("SELECT * FROM carrinho");
            
            // Executa a query
            rs = stmt.executeQuery();
            
            // Itera sobre o resultado e cria objetos CarrinhoDTO com os dados dos itens do carrinho
            while(rs.next()){
                CarrinhoDTO carrinhoDTO = new CarrinhoDTO();
                
                carrinhoDTO.setId_carrinho(rs.getInt("id_carrinho"));
                carrinhoDTO.setFk_produto(rs.getInt("fk_produto"));
                carrinhoDTO.setFk_usuario(rs.getInt("fk_usuario"));
                
                objCategoriaDTO.add(carrinhoDTO);
            }
            
            
        } catch (SQLException e) {
            e.printStackTrace();
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
           
        return objCategoriaDTO;
    }
    
    // Método para adicionar um novo item ao carrinho
    public void adicionarCarrinho(CarrinhoDTO objCarrinhoDTO){
        try {
            // Estabelece a conexão com o banco de dados
            conn = Conexao.conectar();
            System.out.println("Produto> " + objCarrinhoDTO.getFk_produto());
            System.out.println("Usuario> " + objCarrinhoDTO.getFk_usuario());
            // Prepara a query SQL para inserir um novo item no carrinho
            stmt = conn.prepareStatement("INSERT INTO carrinho (fk_produto, fk_usuario) VALUES (?, ?)");
        
            // Define os parâmetros da query com base no objeto CarrinhoDTO fornecido
            stmt.setInt(1, objCarrinhoDTO.getFk_produto());
            stmt.setInt(2, objCarrinhoDTO.getFk_usuario());
        
            // Executa a query de inserção
            stmt.executeUpdate();
        
            // Fecha a conexão com o banco de dados
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
