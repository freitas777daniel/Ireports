<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Passar parametros</title>
</head>
<body>
	<h2>Gerar relatorio 02</h2>
	<form method="post" action="Reports2" target="blank">
		<input type="text" name="codmun" placeholder="digite o codigo do municipio"><br><br>
		<input type="text" name="ano" placeholder="digite o ano de consulta"><br><br>
		<input type="submit" name="enviar" value="enviar">
	</form>
</body>
</html>