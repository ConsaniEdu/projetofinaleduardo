
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

    // Método para listar todas as categorias disponíveis
    public List<CategoriaDTO> listarCategorias(){
        
        // Inicializa uma lista para armazenar as categorias
        List<CategoriaDTO> objCategoriaDTO = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            // Abre a conexão com o banco de dados
            conn = Conexao.conectar();
            // Prepara a query SQL para selecionar todas as categorias
            stmt = conn.prepareStatement("SELECT * FROM categoria");
            
            // Executa a query e obtém o resultado
            rs = stmt.executeQuery();
            
            // Itera sobre o resultado e cria objetos CategoriaDTO com os dados das categorias
            while(rs.next()){
                CategoriaDTO categoriaDTO = new CategoriaDTO();
                
                categoriaDTO.setId_categoria(rs.getInt("id_categoria"));
                categoriaDTO.setNome_categoria(rs.getString("nome_categoria"));
            
                objCategoriaDTO.add(categoriaDTO);
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
        
        // Retorna a lista de categorias
        return objCategoriaDTO;
    }
}
