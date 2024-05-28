<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="css/cadastroprt.css">
    </head>
    <body>
        
        <jsp:include page="header.jsp"></jsp:include>
        <main>
        <form class="cadastrar">                      
                <h1>Cadastro de produtos</h1>
                
                <div class="imagem">
                <img src="./assets/CLK_HERE-removebg-preview.png" alt="">
                </div>
            <div class="form-group">
                <label for="exampleInputEmail1">Nome do produto</label>
                <input type="text" class="form-control" name="nome" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="">
            </div>
                        <div class="form-group">
                <label for="exampleInputEmail1">Descrição do produto</label>
                <input type="text" class="form-control" name="nome" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="">
            </div>            <div class="form-group">
                <label for="exampleInputEmail1">Preço</label>
                <input type="text" class="form-control" name="nome" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="">
            </div>            <div class="form-group">
                <label for="exampleInputEmail1">Quantidade</label>
                <input type="text" class="form-control" name="nome" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="">
            </div>  
            <div class="input-group mb-3">
                <select class="custom-select" id="inputGroupSelect02">
                    <option selected>Escolher...</option>
                    <option value="1">Um</option>
                    <option value="2">Dois</option>
                    <option value="3">Três</option>
                </select>
                <div class="input-group-append">
                    <label class="input-group-text" for="inputGroupSelect02">Opções</label>
                </div>
            </div>
            <button type="submit" class="btn btn-primary">Cadastrar</button>
        </form>
            </main>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </body>
</html>
