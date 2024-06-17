<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="css/cadastro.css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>tela - login</title>
</head>

<body>
    <form id="cadastroForm" action="cadastrar" enctype="multipart/form-data" method="post" class="cadastro">
        <h1> Cadastrar-se </h1>
        <img src="./assets/CLKHERE.png" alt="">
        <div class="form-group">
            <label for="exampleInputEmail1">Endere�o de email</label>
            <input type="email" name="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Seu email">
        </div>
        <div class="form-group">
            <label for="exampleInputNome">Nome</label>
            <input type="text" name="nome" class="form-control" id="exampleInputNome" placeholder="Digite seu nome...">
        </div>
        <div class="form-group">
            <label for="exampleInputSenha">Senha</label>
            <input type="password" name="senha" class="form-control" id="exampleInputSenha" placeholder="Digite sua senha...">
        </div>
        <div class="form-group">
            <label for="exampleInputTelefone">N�mero de Telefone</label>
            <input type="tel" name="telefone" class="form-control" id="exampleInputTelefone" aria-describedby="telefoneHelp" placeholder="Digite seu telefone...">
        </div>
        <div class="form-group">
            <label for="exampleInputCpf">CPF</label>
            <input type="text" name="cpf" class="form-control" id="exampleInputCpf" placeholder="Digite seu CPF">
        </div>
        <button type="submit" class="btn btn-primary">Cadastrar-se</button>
        <a href="./logar">Ir para login</a>
    </form>

    <script>
        document.getElementById("cadastroForm").addEventListener("submit", function(event) {
            var cpfInput = document.getElementById("exampleInputCpf");
            var cpf = cpfInput.value.trim().replace(/\D/g, '');
            if (cpf.length !== 11) {
                event.preventDefault(); 
                alert("Por favor, digite um CPF v�lido.");
                return;
            }

            var telefoneInput = document.getElementById("exampleInputTelefone");
            var telefone = telefoneInput.value.trim().replace(/\D/g, ''); 

            var regexTelefone = /^[1-9]{2}[2-9][0-9]{7,8}$/;

            if (!regexTelefone.test(telefone)) {
                event.preventDefault();
                alert("Por favor, digite um n�mero de telefone v�lido.");
                return;
            }
        });
    </script>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>
