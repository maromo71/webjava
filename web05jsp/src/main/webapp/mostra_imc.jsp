<%@page contentType="text/html" pageEncoding="UTF-8"
    import="java.util.*"
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <title>Resultado</title>
</head>
<body>
    <p>Com base no seu peso: ${param.peso} seu imc foi calculado</p>
    <%
        double peso = Double.parseDouble(request.getParameter("peso"));
        double altura = Double.parseDouble(request.getParameter("altura"));
        double imc = peso / (altura * altura);
    %>
    <p>Valor do imc = <%=imc%> </p>

</body>
</html>