package modelDAO;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelBean.ProdutoDTO;

public class ProdutoDAO {

    public void cadastrarProduto(ProdutoDTO objProdutoDTO) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = Conexao.conectar();
            stmt = conn.prepareStatement("INSERT INTO produto (nome_produto, descricao, preco, quantidade, imagem) VALUES (?, ?, ?, ?, ?)");
            stmt.setString(1, objProdutoDTO.getNome_produto());
            stmt.setString(2, objProdutoDTO.getDescricao());
            stmt.setFloat(3, objProdutoDTO.getPreco());
            stmt.setInt(4, objProdutoDTO.getQuantidade());
            stmt.setString(5, objProdutoDTO.getImagem());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
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
                buscar.add(objProdutoDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
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
            stmt = conn.prepareStatement("SELECT * FROM produto LIMIT 10");
            rs = stmt.executeQuery();

            while (rs.next()) {
                ProdutoDTO objProdutoDTO = new ProdutoDTO();
                objProdutoDTO.setNome_produto(rs.getString("nome_produto"));
                objProdutoDTO.setDescricao(rs.getString("descricao"));
                objProdutoDTO.setPreco(rs.getFloat("preco"));
                objProdutoDTO.setQuantidade(rs.getInt("quantidade"));
                objProdutoDTO.setImagem(rs.getString("imagem"));

                objProdutoDTOs.add(objProdutoDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return objProdutoDTOs;
    }

    public List<ProdutoDTO> buscarCategoria(int categoria) {
        List<ProdutoDTO> resultadoBusca = new ArrayList<>();
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
                objProdutoDTO.setDescricao(rs.getString("descricao"));
                objProdutoDTO.setPreco(rs.getFloat("preco"));
                objProdutoDTO.setQuantidade(rs.getInt("quantidade"));

                resultadoBusca.add(objProdutoDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return resultadoBusca;
    }
}
