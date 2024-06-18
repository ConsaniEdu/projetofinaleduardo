<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="css/index.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Principal</title>
    </head>

    <body>
        <jsp:include page="header.jsp"></jsp:include>

        <!-- Adiciona a variável que guarda o contexto da aplicação -->
        <c:set var="contextPath" value="${pageContext.request.contextPath}" />

        <main>
            <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                <ol class="carousel-indicators">
                    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                </ol>
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img class="img1" src="${contextPath}/assets/3.png" alt="First slide">
                    </div>
                    <div class="carousel-item">
                        <img class="img1" src="${contextPath}/assets/2.png" alt="Second slide">
                    </div>
                    <div class="carousel-item">
                        <img class="img1" src="${contextPath}/assets/1.png" alt="Third slide">
                    </div>
                </div>
                <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>
        </main>

        <div class="cabeçalho-con" style="text-align: center">
            <h1>Destaques</h1>
        </div>
        
        <hr>
        
        <div class="cabeçalho" style="text-align: center">
            <h1>Mais Vendidos</h1>
        </div>
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
                            <form class="form-inline">
                                <button type="submit" class="btn">Adicionar ao carrinho</button>
                            </form>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>

        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>
</html>
