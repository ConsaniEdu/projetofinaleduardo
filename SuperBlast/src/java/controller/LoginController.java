package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelBean.UsuarioDTO;
import modelDAO.UsuarioDAO;

@WebServlet(urlPatterns = {"/logar"})
@MultipartConfig
public class LoginController extends HttpServlet {
    
    //iniciando os objetos de acesso e tranferencia do usuario

    UsuarioDTO objUsuarioDTO = new UsuarioDTO();
    UsuarioDAO objUsuarioDAO = new UsuarioDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //encaminhando para a pagina jsp de login
        String url = "/WEB-INF/jsp/login.jsp";
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
        String action = request.getServletPath();
        
        //verifica a requisao para chamar o metodo logar

        if (action.equals("/logar")) {
            logar(request, response);
        } else {
            processRequest(request, response);
        }
    }

    protected void logar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //obtem os parametros da pagina para a verificação
        
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        objUsuarioDTO.setEmail(email);
        objUsuarioDTO.setSenha(senha);

        boolean usuarioValido = objUsuarioDAO.Login(objUsuarioDTO);

        //caso o usuario seja valido encaminhará para a pagina inicial, caso o usuario nao exista, será enviado uma mensagem de erro
        
        if (usuarioValido) {
            HttpSession session = request.getSession();
            session.setAttribute("user", email);
            response.sendRedirect("./HomeController"); // Página de redirecionamento após login bem-sucedido
        } else {
            request.setAttribute("errorMessage", "Email ou senha inválidos");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
            dispatcher.forward(request, response);
        }
    }
}
