/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelDAO;

import com.mysql.cj.protocol.Resultset;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelBean.ProdutoDTO;

/**
 *
 * @author Eduardo Consani
 */
public class ProdutoDAO {
    
    List<ProdutoDTO> buscarProduto = new ArrayList<>();
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
    
    public void cadastrarProduto(ProdutoDTO objProdutoDTO){
            
            
        try {
            conn = Conexao.conectar();
            stmt = conn.prepareStatement("INSERT INTO produto (nome_produto, descricao, preco, quantidade, imagem) VALUES (?, ?, ?, ?, ?)");
            stmt.setString(1, objProdutoDTO.getNome_produto());
            stmt.setString(2, objProdutoDTO.getDescricao());
            stmt.setFloat(3, objProdutoDTO.getPreco());
            stmt.setInt(4, objProdutoDTO.getQuantidade());
            stmt.setBytes(5, objProdutoDTO.getImagem());
                    
            stmt.executeUpdate();
            
            stmt.close();
            conn.close();
                    
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    }
    
    
    public List<ProdutoDTO> buscarProdutos(String buscarProduto) {
            List<ProdutoDTO> buscar = new ArrayList<>();
        try {
            conn = Conexao.conectar();
            stmt = conn.prepareStatement("SELECT * FROM produto where nome_produto LIKE ? OR descricao LIKE ?");
            
            
            stmt.setString(1, buscarProduto);
            stmt.setString(2, buscarProduto);
            
            rs = stmt.executeQuery();
            
            while(rs.next()){
                ProdutoDTO objProdutoDTO = new ProdutoDTO();
                
                objProdutoDTO.setNome_produto(rs.getString("nome_produto"));
                objProdutoDTO.setDescricao(rs.getString("descricao"));
                
                buscar.add(objProdutoDTO);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return buscar;
    }
    
    
    public List<ProdutoDTO> listarProdutos(){
        
        List<ProdutoDTO> objProdutoDTOs = new ArrayList<>();
        
        try {
            conn = Conexao.conectar();
            stmt = conn.prepareStatement("SELECT * FROM produto LIMIT 10");
            
            rs = stmt.executeQuery();
            
            while(rs.next()){
                ProdutoDTO objProdutoDTO = new ProdutoDTO();
                objProdutoDTO.setNome_produto(rs.getString("nome_produto"));
                objProdutoDTO.setDescricao(rs.getString("descricao"));
                objProdutoDTO.setPreco(rs.getFloat("preco"));
                objProdutoDTO.setQuantidade(rs.getInt("quantidade"));
                objProdutoDTO.setImagem(rs.getBytes("imagem"));
            
            
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
    
    
    public List<ProdutoDTO> buscarCategoria(int categoria){
                
            List<ProdutoDTO> resultadoBusca = new ArrayList<>();
            
            
            try {
            conn = Conexao.conectar();
            stmt = conn.prepareStatement("SELECT FROM produto WHERE categoria ?");
            
            stmt.setInt(1, categoria);
            
            rs = stmt.executeQuery();
            while(rs.next()){
                ProdutoDTO objProdutoDTO = new ProdutoDTO();
                
                objProdutoDTO.setId_produto(rs.getInt("id_produto"));
                objProdutoDTO.setNome_produto(rs.getString("nome_produto"));
                objProdutoDTO.setDescricao(rs.getString("descricao"));
                objProdutoDTO.setPreco(rs.getFloat("preco"));
                objProdutoDTO.setQuantidade(rs.getInt("quantidade"));
                
                resultadoBusca.add(objProdutoDTO);               
            
            }
            
            rs.close();
            stmt.close();
            conn.close();
                
        } catch (SQLException e) {
        }
            return resultadoBusca;
        
        }
}
