<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="css/login.css">

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>tela - login</title>
    </head>

    <body>
    <main>
        <form action="logar" id="login" enctype="multipart/form-data" method="post" class="logar">
            <h1> Login </h1>
            <img src="./assets/CLKHERE.png" alt="">
            <div class="form-group1">
              <label for="exampleInputEmail1">Endere�o de email</label>
              <input type="email" id="usuario" name="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Seu email">
              <small id="emailHelp" class="form-text text-muted">Nunca vamos compartilhar seu email, com ningu�m.</small>
            </div>
            <div class="form-group">
              <label for="exampleInputPassword1">Senha</label>
              <input type="password" id="senha" name="senha" class="form-control" id="exampleInputPassword1" placeholder="Senha">
            </div>
            
            <button type="submit" class="btn btn-primary">Entrar</button>
            <a href="./cadastrar">N�o possui Cadastro? Clique aqui</a>
          </form>
        </main>
    
    <script>
        const form = document.getElementById("login");

form.addEventListener("submit", function (event) {
    event.preventDefault();

    const usuario = document.getElementById("usuario");
    const senha = document.getElementById("senha");

    if(usuario.value.trim() === "" || senha.value.trim() === "" ) {
        alert("Usuario e/ou Senha n�o preenchidos!");
    } else {
        form.submit();
    }
});
        
    </script>
            <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </body>
</html>
