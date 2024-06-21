package modelDAO;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelBean.ProdutoDTO;
import modelBean.UsuarioDTO;

public class ProdutoDAO {

    public void cadastrarProduto(ProdutoDTO objProdutoDTO) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = Conexao.conectar();
            stmt = conn.prepareStatement("INSERT INTO produto (nome_produto, descricao, categoria, preco, quantidade, imagem) VALUES (?, ?, ?, ?, ?, ?)");
            
            stmt.setString(1, objProdutoDTO.getNome_produto());
            stmt.setString(2, objProdutoDTO.getDescricao());
            stmt.setInt(3, objProdutoDTO.getCategoria());
            stmt.setFloat(4, objProdutoDTO.getPreco());
            stmt.setInt(5, objProdutoDTO.getQuantidade());
            stmt.setString(6, objProdutoDTO.getImagem());

            
            
            stmt.executeUpdate();
            
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }
    
   public void deletarProduto(int id_produto) {
    Connection conn = null;
    PreparedStatement stmt = null;

    try {
        conn = Conexao.conectar();
        stmt = conn.prepareStatement("DELETE FROM produto WHERE id_produto = ?");
        stmt.setInt(1, id_produto);

        stmt.executeUpdate();

        conn.close();
        stmt.close();
    } catch (SQLException e) {
        e.printStackTrace();
       
    } 
    
}


    
    public List<ProdutoDTO> buscarProdutos(String buscarProduto) {
    
    List<ProdutoDTO> buscar = new ArrayList<>();
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    try {
        
        conn = Conexao.conectar();
        
        stmt = conn.prepareStatement("SELECT * FROM produto WHERE nome_produto LIKE ? OR descricao LIKE ?");
        
        String busca = "%" + buscarProduto + "%";
        stmt.setString(1, busca);
        stmt.setString(2, busca);

       
        rs = stmt.executeQuery();

        
        while (rs.next()) {
            ProdutoDTO objProdutoDTO = new ProdutoDTO();
            objProdutoDTO.setNome_produto(rs.getString("nome_produto"));
            objProdutoDTO.setDescricao(rs.getString("descricao"));
            objProdutoDTO.setCategoria(rs.getInt("categoria")); 
            objProdutoDTO.setPreco(rs.getFloat("preco")); 
            objProdutoDTO.setImagem(rs.getString("imagem")); 
            buscar.add(objProdutoDTO);
        }
        
        rs.close();
        stmt.close();
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    } 
    
    

    return buscar;
}

    public List<ProdutoDTO> listarProdutos() {

        List<ProdutoDTO> objProdutoDTOs = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = Conexao.conectar();
            stmt = conn.prepareStatement("SELECT * FROM produto");
            rs = stmt.executeQuery();

            while (rs.next()) {
                ProdutoDTO objProdutoDTO = new ProdutoDTO();
                objProdutoDTO.setId_produto(rs.getInt("id_produto"));
                objProdutoDTO.setNome_produto(rs.getString("nome_produto"));
                objProdutoDTO.setDescricao(rs.getString("descricao"));
                objProdutoDTO.setCategoria(rs.getInt("categoria"));
                objProdutoDTO.setPreco(rs.getFloat("preco"));
                objProdutoDTO.setQuantidade(rs.getInt("quantidade"));
                objProdutoDTO.setImagem(rs.getString("imagem"));

                objProdutoDTOs.add(objProdutoDTO);
            }
            
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } 

           
        return objProdutoDTOs;
    }
    
     public ProdutoDTO readyById(int id) {

        ProdutoDTO objProdutoDTO = new ProdutoDTO();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = Conexao.conectar();
            stmt = conn.prepareStatement("SELECT * FROM produto WHERE id_produto = ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                objProdutoDTO.setId_produto(rs.getInt("id_produto"));
                objProdutoDTO.setNome_produto(rs.getString("nome_produto"));
                objProdutoDTO.setDescricao(rs.getString("descricao"));
                objProdutoDTO.setCategoria(rs.getInt("categoria"));
                objProdutoDTO.setPreco(rs.getFloat("preco"));
                objProdutoDTO.setQuantidade(rs.getInt("quantidade"));
                objProdutoDTO.setImagem(rs.getString("imagem"));
            }
            
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } 

           
        return objProdutoDTO;
    }
    
    public List<ProdutoDTO> listarCarrinho() {

        List<ProdutoDTO> objProdutoDTOs = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = Conexao.conectar();
            stmt = conn.prepareStatement("SELECT * FROM carrinho WHERE fk_usuario = ?");
            stmt.setInt(1, UsuarioDTO.getIdUsuarioStatico());
            rs = stmt.executeQuery();

            while (rs.next()) {
                ProdutoDTO objProdutoDTO = new ProdutoDTO();
                ProdutoDAO daoP = new ProdutoDAO();
                objProdutoDTO =  daoP.readyById(rs.getInt("fk_produto"));
                
                System.out.println("Nome: " + objProdutoDTO.getNome_produto());
                objProdutoDTOs.add(objProdutoDTO);
            }
            
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } 

           
        return objProdutoDTOs;
    }

    // funcao para buscar produtos com base na categoria
    public List<ProdutoDTO> buscarCategoria(int categoria) {
       
        List<ProdutoDTO> busca = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
           
            conn = Conexao.conectar();
            stmt = conn.prepareStatement("SELECT * FROM produto WHERE categoria = ?");
            stmt.setInt(1, categoria);

            rs = stmt.executeQuery();
           
            while (rs.next()) {
                ProdutoDTO objProdutoDTO = new ProdutoDTO();
                objProdutoDTO.setId_produto(rs.getInt("id_produto"));
                objProdutoDTO.setNome_produto(rs.getString("nome_produto"));
                objProdutoDTO.setCategoria(rs.getInt("categoria"));
                objProdutoDTO.setDescricao(rs.getString("descricao"));
                objProdutoDTO.setPreco(rs.getFloat("preco"));
                objProdutoDTO.setQuantidade(rs.getInt("quantidade"));

                busca.add(objProdutoDTO);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } 

        return busca;

    }
    
    
    
}
