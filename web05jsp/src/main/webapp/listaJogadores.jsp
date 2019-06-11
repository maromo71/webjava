<%@page contentType="text/html" pageEncoding="UTF-8"
    import="java.util.*, net.maromo.dao.*, net.maromo.modelo.*"
%>
<!DOCTYPE html>
<html>
<head>
    <title>Lista de Jogadores</title>
    <style>
    table {
      border-collapse: collapse;
    }

    table, td, th {
      border: 1px solid black;
    }
    </style>
</head>
<body>
    <h1>Jogadores</h1>
    <table>
        <tr>
            <td>Nome do Jogador</td>
            <td>Apelido</td>
            <td>Posição</td>
            <td>Idade</td>
        <tr>
        <%
            JogadorDao dao = new JogadorDao();
            List<Jogador> lista = dao.listarJogadores();
            for(Jogador j : lista){
        %>
            <td><%= j.getNome() %></td>
            <td><%= j.getApelido() %></td>
            <td><%= j.getPosicao() %></td>
            <td><%= j.getIdade() %></td>
        </tr>
        <% } %>
     </table>
</body>
</html>
