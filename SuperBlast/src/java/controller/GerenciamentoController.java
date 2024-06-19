package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelBean.ProdutoDTO;
import modelDAO.ProdutoDAO;

@WebServlet(urlPatterns = {"/gerenciamento"})
public class GerenciamentoController extends HttpServlet {
    
    ProdutoDTO objProdutoDTO = new ProdutoDTO();
    ProdutoDAO objProdutoDAO = new ProdutoDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String deleta = request.getParameter("deleta");
        if(deleta != null && deleta.equals("deletar")){
        String idproduto = request.getParameter("idproduto");
        
        objProdutoDAO.deletarProduto(Integer.parseInt(idproduto));
        
        }
        
        List<ProdutoDTO> objProdutoDTOs = objProdutoDAO.listarProdutos();
        
        request.setAttribute("produtos", objProdutoDTOs);
        
        String url = "WEB-INF/jsp/gerenciamentoprt.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
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
       
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
