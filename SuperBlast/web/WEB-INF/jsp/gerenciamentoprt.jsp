<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="css/gerenciamento.css">
    <title>Gerenciamento de Produto</title>
</head>
<body>
    <jsp:include page="header.jsp"></jsp:include>
    <main>
        <div class="container">
            <div class="container-produto">
                <c:forEach var="produto" items="${produtos}">
                    <div class="card" style="width: 350px;">
                       <img src="${contextPath}/${produto.imagem}" class="card-img-top" alt="${produto.nome_produto}"> 
                        <div class="card-body">
                            <h5 class="card-title">${produto.nome_produto}</h5>
                            <p class="card-text">Categoria: ${produto.categoria}</p>
                            <p class="card-text">Valor: ${produto.preco}</p>
                            <p class="card-text">Descrição: ${produto.descricao}</p>
                            <form class="form-inline" action="gerenciamento" method="post">
                                <input type="hidden" name="deleta" value="deletar"/>
                                <input type="hideen" name="id_produto" value="${produto.id_produto}"/>
                                <button type="submit" class="btn">excluir Produto</button>
                            </form>

                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </main>
</body>
</html>
