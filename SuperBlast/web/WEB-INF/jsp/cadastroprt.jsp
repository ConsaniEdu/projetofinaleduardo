<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="css/cadastroprt.css">
    </head>
    <body style="background-color: #E6EEF4">
        
        <jsp:include page="header.jsp"></jsp:include>
        <main>
            <form action="criarprt" enctype="multipart/form-data" method="post" class="cadastrar" onsubmit="return validateForm()">                      
                <h1>Cadastro de produtos</h1>
                
                <div class="imagem">
                    <img src="./assets/CLKHERE.png" alt="">
                </div>
                <div class="form-group">
                    <label for="nome">Nome do produto</label>
                    <input type="text" class="form-control" name="nome" id="nome" placeholder="">
                </div>
                <div class="form-group">
                    <label for="preco">Preço</label>
                    <input type="text" class="form-control" name="preco" id="preco" placeholder="" pattern="\d+(\.\d{1,2})?" title="Por favor, insira um número válido para o preço.">
                </div>
                <div class="form-group">
                    <label for="quantidade">Quantidade</label>
                    <input type="text" class="form-control" name="quantidade" id="quantidade" placeholder="" pattern="\d+" title="Por favor, insira um número válido para a quantidade.">
                </div>
                <div class="form-group">
                    <label for="descricao">Descrição</label>
                    <input type="text" class="form-control" name="descricao" id="descricao" placeholder="">
                </div>  
                <div class="input-img"> 
                    <label>Escolha a imagem do produto</label>
                    <input type="file" name="imagem" id="imagem">
                </div>
                <div class="input-group">
                    <select class="custom-select" id="inputGroupSelect02" name="categoria">
                        <c:forEach items="${categoria}" var="categorias">
                            <option value="${categorias.id_categoria}">${categorias.nome_categoria}</option>
                        </c:forEach>
                    </select>
                    <div class="input-group-append">
                        <label class="input-group-text" for="inputGroupSelect02">Categoria</label>
                    </div>
                </div>
                <button type="submit" class="btn btn-primary">Cadastrar</button>
            </form>
        </main>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <script>
            function validateForm() {
                const nome = document.getElementById('nome').value.trim();
                const preco = document.getElementById('preco').value.trim();
                const quantidade = document.getElementById('quantidade').value.trim();
                const descricao = document.getElementById('descricao').value.trim();
                const imagem = document.getElementById('imagem').value.trim();
                const categoria = document.getElementById('inputGroupSelect02').value;

                if (!nome || !preco || !quantidade || !descricao || !imagem || !categoria) {
                    alert('Por favor, preencha todos os campos.');
                    return false;
                }

                const precoPattern = /^\d+(\.\d{1,2})?$/;
                if (!precoPattern.test(preco)) {
                    alert('Por favor, insira um número válido para o preço.');
                    return false;
                }

                const quantidadePattern = /^\d+$/;
                if (!quantidadePattern.test(quantidade)) {
                    alert('Por favor, insira um número válido para a quantidade.');
                    return false;
                }

                return true;
            }
        </script>
    </body>
</html>
