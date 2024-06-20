
package modelDAO;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelBean.CategoriaDTO;

public class CategoriaDAO {

    
    public List<CategoriaDTO> listarCategorias(){
        
        
        List<CategoriaDTO> objCategoriaDTO = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
           
            conn = Conexao.conectar();
            
            stmt = conn.prepareStatement("SELECT * FROM categoria");
            
            
            rs = stmt.executeQuery();
            
           
            while(rs.next()){
                CategoriaDTO categoriaDTO = new CategoriaDTO();
                
                categoriaDTO.setId_categoria(rs.getInt("id_categoria"));
                categoriaDTO.setNome_categoria(rs.getString("nome_categoria"));
            
                objCategoriaDTO.add(categoriaDTO);
            }
            
            stmt.close();
            conn.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        
       
        return objCategoriaDTO;
    }
}
