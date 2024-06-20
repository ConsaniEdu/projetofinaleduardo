
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelBean.ProdutoDTO;
import modelDAO.ProdutoDAO;


public class CarrinhoController extends HttpServlet {

    ProdutoDAO objProdutoDAO = new ProdutoDAO();
    ProdutoDTO objProdutoDTO = new ProdutoDTO();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/WEB-INF/jsp/carrinho.jsp";
        
        
        
        List<ProdutoDTO>  objProdutoDTOs = objProdutoDAO.listarCarrinho();
        
        request.setAttribute("produtos", objProdutoDTOs);
        request.setAttribute("carrinho", objProdutoDTOs);
        
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

      
        String produtoId = request.getParameter("produtoId");

       
        List<String> objCarrinhoDTOs = (List<String>) request.getSession().getAttribute("carrinho");

        
        if (objCarrinhoDTOs == null) {
            objCarrinhoDTOs = new ArrayList<>();
            request.getSession().setAttribute("carrinho", objCarrinhoDTOs);
        }

       
       objCarrinhoDTOs.add(produtoId);

        
        response.sendRedirect(request.getHeader("referer"));
    }


    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
