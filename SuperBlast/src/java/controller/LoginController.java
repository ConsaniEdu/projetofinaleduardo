
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelBean.UsuarioDTO;
import modelDAO.UsuarioDAO;

@WebServlet(urlPatterns = {"/logar"})
@MultipartConfig

public class LoginController extends HttpServlet {

        UsuarioDTO objUsuarioDTO = new UsuarioDTO();
        UsuarioDAO objUsuarioDAO = new UsuarioDAO();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String url = "/pages/login.jsp";
        RequestDispatcher dispacher = getServletContext().getRequestDispatcher(url);
        dispacher.forward(request, response);
    }

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getServletPath();
       
         if(action.equals("/logar")){
            logar(request, response);
        }
        else{
            processRequest(request, response);
        }
    }
    
    protected void logar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        objUsuarioDTO.setEmail(request.getParameter("email"));
        objUsuarioDTO.setSenha(request.getParameter("senha"));
        
        objUsuarioDAO.Login(objUsuarioDTO);
        
        
        response.sendRedirect("redirect.jsp");
                
        PrintWriter out = response.getWriter();
        out.println("<script type=\"text/javascript\">");
            out.println("alert('logado com sucesso!');");
            out.println("window.location.href = 'redirect.jsp';");
            out.println("</script>");
        }

    
    
}
