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

    // Método para cadastrar um novo produto no banco de dados
    public void cadastrarProduto(ProdutoDTO objProdutoDTO) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            // Abre a conexão com o banco de dados
            conn = Conexao.conectar();
            // Prepara a query SQL para inserir um novo produto
            stmt = conn.prepareStatement("INSERT INTO produto (nome_produto, descricao, categoria, preco, quantidade, imagem) VALUES (?, ?, ?, ?, ?, ?)");
            // Define os parâmetros da query com base no ProdutoDTO fornecido
            stmt.setString(1, objProdutoDTO.getNome_produto());
            stmt.setString(2, objProdutoDTO.getDescricao());
            stmt.setInt(3, objProdutoDTO.getCategoria());
            stmt.setFloat(4, objProdutoDTO.getPreco());
            stmt.setInt(5, objProdutoDTO.getQuantidade());
            stmt.setString(6, objProdutoDTO.getImagem());

            // Executa a query para inserir o produto no banco de dados
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Fecha a conexão com o banco de dados
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Método para buscar produtos com base em um termo de pesquisa
    public List<ProdutoDTO> buscarProdutos(String buscarProduto) {
        // Inicializa uma lista para armazenar os produtos encontrados
        List<ProdutoDTO> buscar = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // Abre a conexão com o banco de dados
            conn = Conexao.conectar();
            // Prepara a query SQL para buscar produtos com base no termo de pesquisa
            stmt = conn.prepareStatement("SELECT * FROM produto WHERE nome_produto LIKE ? OR descricao LIKE ?");
            // Define o termo de pesquisa com base no argumento fornecido
            String busca = "%" + buscarProduto + "%";
            stmt.setString(1, busca);
            stmt.setString(2, busca);

            // Executa a query e obtém o resultado
            rs = stmt.executeQuery();

            // Itera sobre o resultado e cria objetos ProdutoDTO com os dados encontrados
            while (rs.next()) {
                ProdutoDTO objProdutoDTO = new ProdutoDTO();
                objProdutoDTO.setNome_produto(rs.getString("nome_produto"));
                objProdutoDTO.setDescricao(rs.getString("descricao"));
                buscar.add(objProdutoDTO);
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

        // Retorna a lista de produtos encontrados
        return buscar;
    }

    // Método para listar os produtos (limitado a 10)
    public List<ProdutoDTO> listarProdutos() {
        // Inicializa uma lista para armazenar os produtos listados
        List<ProdutoDTO> objProdutoDTOs = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // Abre a conexão com o banco de dados
            conn = Conexao.conectar();
            // Prepara a query SQL para listar os produtos (limitado a 10)
            stmt = conn.prepareStatement("SELECT * FROM produto LIMIT 10");
            // Executa a query e obtém o resultado
            rs = stmt.executeQuery();

            // Itera sobre o resultado e cria objetos ProdutoDTO com os dados listados
            while (rs.next()) {
                ProdutoDTO objProdutoDTO = new ProdutoDTO();
                objProdutoDTO.setNome_produto(rs.getString("nome_produto"));
                objProdutoDTO.setDescricao(rs.getString("descricao"));
                objProdutoDTO.setCategoria(rs.getInt("categoria"));
                objProdutoDTO.setPreco(rs.getFloat("preco"));
                objProdutoDTO.setQuantidade(rs.getInt("quantidade"));
                objProdutoDTO.setImagem(rs.getString("imagem"));

                objProdutoDTOs.add(objProdutoDTO);
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

        // Retorna a lista de produtos listados
        return objProdutoDTOs;
    }

    // Método para buscar produtos com base em uma categoria específica
    public List<ProdutoDTO> buscarCategoria(int categoria) {
        // Inicializa uma lista para armazenar os produtos encontrados
        List<ProdutoDTO> resultadoBusca = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // Abre a conexão com o banco de dados
            conn = Conexao.conectar();
            // Prepara a query SQL para buscar produtos com base em uma categoria específica
            stmt = conn.prepareStatement("SELECT * FROM produto WHERE categoria = ?");
            // Define a categoria com base no argumento fornecido
            stmt.setInt(1, categoria);

            // Executa a query e obtém o resultado
            rs = stmt.executeQuery();
            // Itera sobre o resultado e cria objetos ProdutoDTO com os dados encontrados
            while (rs.next()) {
                ProdutoDTO objProdutoDTO = new ProdutoDTO();
                objProdutoDTO.setId_produto(rs.getInt("id_produto"));
                objProdutoDTO.setNome_produto(rs.getString("nome_produto"));
                objProdutoDTO.setCategoria(rs.getInt("categoria"));
                objProdutoDTO.setDescricao(rs.getString("descricao"));
                objProdutoDTO.setPreco(rs.getFloat("preco"));
                objProdutoDTO.setQuantidade(rs.getInt("quantidade"));

                resultadoBusca.add(objProdutoDTO);
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

        // Retorna a lista de produtos encontrados
        return resultadoBusca;

    }
    
    
    
}
