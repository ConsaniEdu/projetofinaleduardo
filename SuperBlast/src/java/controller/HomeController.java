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
        
        String busca = request.getParameter("busca");
        List<ProdutoDTO> produtos;
        
        if (busca != null && !busca.isEmpty()) {
            produtos = objProdutoDAO.buscarProdutos(busca);
        } else {
            produtos = objProdutoDAO.listarProdutos();
        }
        
        request.setAttribute("produtos", produtos);
        String url = "/WEB-INF/jsp/index.jsp";
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
        String url = request.getServletPath();
        if(url.equals("/addCarrinho")){
            int idProduto = Integer.parseInt(request.getParameter("produtoId"));
            CarrinhoDAO dao = new CarrinhoDAO();
            CarrinhoDTO c = new CarrinhoDTO();
            c.setFk_produto(idProduto);
            c.setFk_usuario(UsuarioDTO.getIdUsuarioStatico());
            
            dao.adicionarCarrinho(c);
        }
        processRequest(request, response);
    }
}
