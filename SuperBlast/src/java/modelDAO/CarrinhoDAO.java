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
            // conecta com banco
            conn = Conexao.conectar();
            // prepara a query que vai selecionar todos os itens do carrinho
            stmt = conn.prepareStatement("SELECT * FROM carrinho");
            
            // executa a query
            rs = stmt.executeQuery();
            
            // cria um carrinho com os itens do carrinho
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
            // Feecha conexao
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
    
    ///funcao para adicionar um item no carrinho
    public void adicionarCarrinho(CarrinhoDTO objCarrinhoDTO){
        try {
            // fazendo conexao com o banco
            conn = Conexao.conectar();
            System.out.println("Produto> " + objCarrinhoDTO.getFk_produto());
            System.out.println("Usuario> " + objCarrinhoDTO.getFk_usuario());
            // preparando a query
            stmt = conn.prepareStatement("INSERT INTO carrinho (fk_produto, fk_usuario) VALUES (?, ?)");
        
            // definindo os parametros necessarios da query
            stmt.setInt(1, objCarrinhoDTO.getFk_produto());
            stmt.setInt(2, objCarrinhoDTO.getFk_usuario());
        
            //executa a query
            stmt.executeUpdate();
        
            // fecha onexao com o banco de dados
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
