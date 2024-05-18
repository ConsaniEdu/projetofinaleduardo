<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>tela - login</title>
    </head>

    <body>
        <form action="cadastrar" enctype="multipart/form-data" method="post" class="cadastro">
            <div class="form-group">
              <label for="exampleInputEmail1">Endereço de email</label>
              <input type="email" name="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Seu email">

            </div>
            <div class="form-group">
                <label for="exampleInputEmail1">Nome</label>
                <input type="text" name="nome" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Digite seu nome...">
               
              </div>
              <div class="form-group">
                <label for="exampleInputEmail1">Senha</label>
                <input type="password" name="senha" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Digite sua senha...">
               
              </div>
              <div class="form-group">
                <label for="exampleInputEmail1">Numero de Telefone</label>
                <input type="tel" name="telefone" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Digite seu telefone...">
                
              </div>
            <div class="form-group">
              <label for="exampleInputPassword1">Cpf</label>
              <input type="text" name="Cpf" class="form-control" id="exampleInputPassword1" placeholder="Digite seu Cpf">
            </div>
            <div class="form-group form-check">
              <input type="checkbox" class="form-check-input" id="exampleCheck1">
              <label class="form-check-label" for="exampleCheck1">Clique em mim</label>
            </div>
            <button type="submit" class="btn btn-primary">Cadastrar-se</button>
          </form>
          <a href="./LoginController">Ir para login</a>
            <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </body>
</html>
