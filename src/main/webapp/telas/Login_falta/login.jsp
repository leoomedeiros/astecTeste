<!DOCTYPE html>
<html lang="PT-br">
	<head>
			<meta charset="UTF-8">
			<title>Login</title>
			<link rel="stylesheet" type="text/css" href="estilo.css">
	</head>
	<body>
		
		<div id="log">
		<img src="logo.png" id="logo" />
		
		<form action="${pageContext.request.contextPath}/FuncionarioAutenticar" method="post">
		<label> Usuário:   </label>
		<input type="text" id="txtUser" name="usuario"/>
		<p/>
                <label> Senha:   </label>
		<input type="password" id="txtSenha" name="senha"/>
		<p/>
		<input type="submit" id="inpSubmit" />
		<a href="#">Esqueceu a senha?</a>
                </form>
		</div>
	</body>
</html>