<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Página JSP</title>
</head>
<body>
   <h1>Olá alunos!!!</h1>

   <%
        String mensagem = "Sejam bem vindos";
        out.println(mensagem);
   %>
   <br />
   <%
        String desenvolvedor = "Site criado pelo professor";
   %>
   <br />
   <%= desenvolvedor %>
</body>
</html>
