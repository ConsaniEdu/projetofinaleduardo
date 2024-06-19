<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/carrinho.css">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
        
        <header>
            <h2>Meu Carrinho</h2>
        </header>
        
        <main>
            <div class="container-prts">
                <div class="container-product">
                    <c:forEach var="produtoId" items="${sessionScope.carrinho}">
                        
                        <c:set var="produto" value="${produtoService.getProdutoById(produtoId)}" />
                        
                        <div class="card" style="width: 350px;">
                            <img src="${contextPath}/${produto.imagem}" class="card-img-top" alt="${produto.nome_produto}">
                            <div class="card-body">
                                <h5 class="card-title">${produto.nome_produto}</h5>
                                <p class="card-text">Categoria: ${produto.categoria}</p>
                                <p class="card-text">Valor: ${produto.preco}</p>
                                <p class="card-text">Descrição: ${produto.descricao}</p>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
            
            <div class="container-conf">
                <div class="order-text">
                    <h4>Pedido</h4>
                </div>
                <label for="preco">Preço Total</label>
                <hr>
                <div class="btn">
                    <button>Confirmar Pedido</button>
                </div>
            </div>
        </main>
    </body>
</html>
