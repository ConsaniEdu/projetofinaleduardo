
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

    //inicializando os objeto de acesso e de tranferencia de dados do produto
    
    ProdutoDAO objProdutoDAO = new ProdutoDAO();
    ProdutoDTO objProdutoDTO = new ProdutoDTO();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //determinando a url da pagina que esta na JSP
        
        String url = "/WEB-INF/jsp/carrinho.jsp";
        
        //usando o objprodutodao para lisatar os produtos no carrinho de compra
        
        List<ProdutoDTO>  objProdutoDTOs = objProdutoDAO.listarCarrinho();
        
        //atribuindo a lista de produtos requerida em produtos e carrinho
        
        request.setAttribute("produtos", objProdutoDTOs);
        request.setAttribute("carrinho", objProdutoDTOs);
        
        //encaminnando a requisição e tambem a resposta para a pagina usando a url
        
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

      //obtem o id do produto (produtoId)do form na pagina
       
        String produtoId = request.getParameter("produtoId");

       
        List<String> objCarrinhoDTOs = (List<String>) request.getSession().getAttribute("carrinho");

        //obtem o produto no carrinho e o adiciona ao produtoId
        
        if (objCarrinhoDTOs == null) {
            objCarrinhoDTOs = new ArrayList<>();
            request.getSession().setAttribute("carrinho", objCarrinhoDTOs);
        }

       
       objCarrinhoDTOs.add(produtoId);

       //redireciona o usuario a pagina inicial 
       
        response.sendRedirect(request.getHeader("referer"));
    }


    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
