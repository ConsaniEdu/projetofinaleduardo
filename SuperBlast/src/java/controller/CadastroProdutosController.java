/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import modelDAO.CategoriaDAO;
import modelDAO.ProdutoDAO;
import modelBean.CategoriaDTO;
import modelBean.ProdutoDTO;

//defino as urls

@WebServlet(urlPatterns = {"/criarprt", "/cad-produtos"})
@MultipartConfig
public class CadastroProdutosController extends HttpServlet {

    //acionando os objetos de acesso e de tranferencia do produto
    
    ProdutoDTO objProduto = new ProdutoDTO();
    ProdutoDAO objProdutoDao = new ProdutoDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //obtendo a lista de categorias
        
        CategoriaDAO categoria = new CategoriaDAO();
        List<CategoriaDTO> categorias = categoria.listarCategorias();
        request.setAttribute("categoria", categorias);
        String nextPage = "/WEB-INF/jsp/cadastroprt.jsp";
        
            //encaminha a requisao para a JSP
        
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
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
        if (action.equals("/criarprt")) {
            product(request, response);
        }
    }

    protected void product(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Cria um novo objeto de produto com os parâmetros fornecidos na requisição
        ProdutoDTO objProdutoDTO = new ProdutoDTO();
        
        //definindo os atributos do parametro para passar ao formulario

        objProdutoDTO.setNome_produto(request.getParameter("nome"));

        try {
            String categoriaStr = request.getParameter("categoria");
            System.out.println(categoriaStr);
            if (categoriaStr != null && !categoriaStr.isEmpty()) {
                objProdutoDTO.setCategoria(Integer.parseInt(categoriaStr));
                System.out.println(objProdutoDTO.getCategoria());
            }

            String precoStr = request.getParameter("preco");
            if (precoStr != null && !precoStr.isEmpty()) {
    float preco = new Float(precoStr);
    objProdutoDTO.setPreco(preco);
}

            String quantidadeStr = request.getParameter("quantidade");
            if (quantidadeStr != null && !quantidadeStr.isEmpty()) {
                objProdutoDTO.setQuantidade(Integer.parseInt(quantidadeStr));
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        objProdutoDTO.setDescricao(request.getParameter("descricao"));

        // Obtém a parte do arquivo de imagem da requisição
        Part filePart = request.getPart("imagem");
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // Corrige problemas com o navegador IE
        if (fileName != null && !fileName.isEmpty()) {
            // Se o arquivo de imagem foi enviado, salva-lo no diretório assets
            String basePath = getServletContext().getRealPath("/") + "assets"; // Caminho para a pasta assets
            File uploads = new File(basePath);

            if (!uploads.exists()) {
                uploads.mkdirs(); // Cria o diretório se não existir
            }
            File file = new File(uploads, fileName);

            try (InputStream input = filePart.getInputStream()) {
                Files.copy(input, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
            } catch (Exception e) {
                e.printStackTrace(); // Trata as exceções de forma adequada
            }

            // Configura o caminho relativo da imagem no banco de dados
            objProdutoDTO.setImagem("assets/" + fileName);
        } else {
            objProdutoDTO.setImagem(null);
        }

        // Salva o produto e tbm redireciona a JSP principal
        ProdutoDAO objProdutoDAO = new ProdutoDAO();
        objProdutoDAO.cadastrarProduto(objProdutoDTO);
        response.sendRedirect("./HomeController");
    }


       
        /*PrintWriter out = response.getWriter();
        Part filePart = request.getPart("imagem");
        InputStream inputStream = filePart.getInputStream();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096];
        int bytesRead = -1;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }
        byte[] imageBytes = outputStream.toByteArray();
        
        
            objProduto.setImagem(imageBytes);
         objProduto.setNome_produto(request.getParameter("nome"));
         System.out.println("O nome do produto é: "+ objProduto.getNome_produto());
        objProduto.setCategoria(Integer.parseInt(request.getParameter("categoria")));
        objProduto.setPreco(Float.parseFloat(request.getParameter("preco")));
        objProduto.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
        objProduto.setDescricao(request.getParameter("descricao"));
        
        
        
        objProdutoDao.cadastrarProduto(objProduto);
        response.sendRedirect("./cadastroProdutos");
        */

    }

