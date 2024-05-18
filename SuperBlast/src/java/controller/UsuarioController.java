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

@WebServlet(urlPatterns = {"/cadastrar"})
@MultipartConfig

public class UsuarioController extends HttpServlet {

  UsuarioDTO objUsuarioDTO = new UsuarioDTO();
  UsuarioDAO objUsuarioDAO = new UsuarioDAO();
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/pages/cadastrar.jsp";
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
        if(action.equals("/cadastrar")){
            cadastrar(request, response);
        }
        else{
            processRequest(request, response);
        }
        
        
    }

    
    protected void cadastrar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        objUsuarioDTO.setNome_usuario(request.getParameter("nome"));
        objUsuarioDTO.setSenha(request.getParameter("senha"));
        objUsuarioDTO.setEmail(request.getParameter("email"));
        objUsuarioDTO.setTelefone(request.getParameter("telefone"));
        objUsuarioDTO.setCpf(request.getParameter("Cpf"));
        
        objUsuarioDAO.CriarUsuario(objUsuarioDTO);
        
        PrintWriter out = response.getWriter();
        out.println("<script type=\"text/javascript\">");
            out.println("alert('usuario cadastrado com sucesso!');");
            out.println("window.location.href = 'pages/login.jsp';");
            out.println("</script>");
        
    }
    
    

}
