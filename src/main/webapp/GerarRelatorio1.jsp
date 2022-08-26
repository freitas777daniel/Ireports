<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Passar parametros</title>
</head>
<body>
	<h2>Gerar relatorio 01</h2>
	<form method="post" action="Reports" target="blank">
		<input type="text" name="orgaoaut" placeholder="digite o orgao autuador"><br><br>
		<input type="text" name="tipovei" placeholder="digite o tipo de veiculo"><br><br>
		<input type="date" name="dataini" placeholder="digite a data inicial"><br><br>
		<input type="date" name="datafim" placeholder="digite a data final"><br><br>
		<input type="submit" name="enviar" value="enviar">
	</form>
</body>
</html>