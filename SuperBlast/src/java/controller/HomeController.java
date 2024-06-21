package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelBean.CarrinhoDTO;
import modelBean.ProdutoDTO;
import modelBean.UsuarioDTO;
import modelDAO.CarrinhoDAO;
import modelDAO.ProdutoDAO;

public class HomeController extends HttpServlet {

    ProdutoDAO objProdutoDAO = new ProdutoDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        //obtem o parametro busca do JSP
        
        String busca = request.getParameter("busca");
        List<ProdutoDTO> produtos;
        
        //se a requisiçao de busca nao for vazia ele irá buscar os produtos, caso contrario ele irá listar novamento toodos os itens normelmente
        
        if (busca != null && !busca.isEmpty()) {
            produtos = objProdutoDAO.buscarProdutos(busca);
        } else {
            produtos = objProdutoDAO.listarProdutos();
        }
        
        //defino produtos com a lista de produtos obtidas da requisição
        
        request.setAttribute("produtos", produtos);
        String url = "/WEB-INF/jsp/index.jsp";
        
        //refireciono o usuario para a pagina principal aonde serao mostrados os itens procurados
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //obtem a url da requisição
        
        String url = request.getServletPath();
        //se a requisiçao for chamada cria um novo objeto do carrinho e passa para o usuario que será associado
        
        if(url.equals("/addCarrinho")){
            int idProduto = Integer.parseInt(request.getParameter("produtoId"));
            CarrinhoDAO dao = new CarrinhoDAO();
            CarrinhoDTO c = new CarrinhoDTO();
            c.setFk_produto(idProduto);
            c.setFk_usuario(UsuarioDTO.getIdUsuarioStatico());
            
            //aqui adiciona os produtos ao carrinho do usuario
            
            dao.adicionarCarrinho(c);
        }
        processRequest(request, response);
    }
}
