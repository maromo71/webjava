package net.maromo.servlet;


import net.maromo.dao.JogadorDao;
import net.maromo.modelo.Jogador;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/time")
public class TimeServlet extends HttpServlet {

    private List<Jogador> lista = new ArrayList<>();

    public void adicionarNoTime(Jogador jogador) throws ClassNotFoundException {
        lista.add(jogador);
        JogadorDao dao = new JogadorDao();
        dao.adicionarJogador(jogador);
    }

    public List<Jogador> listaDeJogadores() throws ClassNotFoundException {
        JogadorDao dao = new JogadorDao();
        try {
            return dao.listarJogadores();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.getWriter().println("<html>");
        resp.getWriter().println("<head>");
        resp.getWriter().println("<title>Primeira Servlet</title>");
        resp.getWriter().println("</head>");
        resp.getWriter().println("<body>");
        resp.getWriter().println("<h1>Servlet para times - VAZIO</h1>");
        resp.getWriter().println("</body>");
        resp.getWriter().println("</html>");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Jogador jogador = new Jogador();
        jogador.setNome(req.getParameter("nomeJogador"));
        jogador.setApelido(req.getParameter("apelidoJogador"));
        jogador.setPosicao(req.getParameter("posicaoJogador"));
        jogador.setIdade(Integer.parseInt(req.getParameter("idadeJogador")));
        try {
            this.adicionarNoTime(jogador);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        resp.getWriter().println("<html>");
        resp.getWriter().println("<head>");
        resp.getWriter().println("<title>Dados Cadastrados</title>");
        resp.getWriter().println("</head>");
        resp.getWriter().println("<body>");
        resp.getWriter().println("<h1>Jogador Cadastrado com sucesso</h1>");
        try {
            for (Jogador j: this.listaDeJogadores()) {
                resp.getWriter().println("<p>Jogador: " + j.getNome() + "</p>");
                resp.getWriter().println("<p>Apelido: " + j.getApelido() + "</p>");
                resp.getWriter().println("<p>Posicao: " + j.getPosicao() + "</p>");
                resp.getWriter().println("<p>idade: " + j.getIdade() + "</p>");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        resp.getWriter().println("</body>");
        resp.getWriter().println("</html>");
    }

}
