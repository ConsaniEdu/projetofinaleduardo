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
                <c:forEach var="prt" items="${carrinho}">
                    <div class="card" style="width: 350px;">
                        <img src="${pageContext.request.contextPath}/${prt.imagem}" class="card-img-top" alt="${prt.nome_produto}">
                        <div class="card-body">
                            <h5 class="card-title">${prt.nome_produto}</h5>
                            <p class="card-text">Valor: R$ ${prt.preco}</p>
                            <p class="card-text">Descrição: ${prt.descricao}</p>
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
