package net.maromo.dao;

import net.maromo.modelo.Jogador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JogadorDao {
    private final Connection connection;

    public JogadorDao() throws ClassNotFoundException {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void adicionarJogador(Jogador jogador) {
        String sql = "Insert into jogadores " +
                " (nomeJogador, apelidoJogador, posicaoJogador, idadeJogador) " +
                " values (?,?,?,?);";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, jogador.getNome());
            statement.setString(2, jogador.getApelido());
            statement.setString(3, jogador.getPosicao());
            statement.setInt(4, jogador.getIdade());
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
    }

    public List<Jogador> listarJogadores() throws SQLException {
        List<Jogador> lista = new ArrayList<>();
        String sql = "Select * from jogadores;";
        ResultSet resultSet = null;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                Jogador jogador = new Jogador();
                jogador.setNome(resultSet.getString("nomeJogador"));
                jogador.setApelido(resultSet.getString("apelidoJogador"));
                jogador.setPosicao(resultSet.getString("posicaoJogador"));
                jogador.setIdade(resultSet.getInt("idadeJogador"));
                lista.add(jogador);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if(resultSet != null) resultSet.close();
        }
        return lista;
    }
}
