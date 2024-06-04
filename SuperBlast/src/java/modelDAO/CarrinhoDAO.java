
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
    
    
    public List <CarrinhoDTO> ListarCarrinho(){
        
        List <CarrinhoDTO> objCategoriaDTO = new ArrayList<>();
    
        try {
            conn = Conexao.conectar();
            stmt = conn.prepareStatement("SELECT * FROM carrinho");
            
            rs = stmt.executeQuery();
            
            while(rs.next()){
            
                CarrinhoDTO carrinhoDTO = new CarrinhoDTO();
                
                carrinhoDTO.setId_carrinho(rs.getInt("id_carrinho"));
                carrinhoDTO.setFk_produto(rs.getInt("fk_produto"));
                carrinhoDTO.setFk_usuario(rs.getInt("fk_usuario"));
                
                objCategoriaDTO.add(carrinhoDTO);
            }
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
           
        return objCategoriaDTO;
    }
    
    public void adicionarCarrinho(CarrinhoDTO objCarrinhoDTO){
    
    
        try {
            
    conn = Conexao.conectar();
    stmt = conn.prepareStatement("INSERT INTO carrinho (fk_produto, fk_usuario) VALUES (?, ?)");
            
            
            stmt.setInt();
        } catch (Exception e) {
        }
    
    }
    
    
}
