package net.maromo.dao;

import net.maromo.model.Jogador;

import javax.persistence.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JogadorDao {

    @PersistenceContext
    private EntityManager em;
    private EntityTransaction tx;

    public JogadorDao() {

    }


    public void adicionar(Jogador jogador) {
        em = JpaUtil.getEntityManager();
        tx = em.getTransaction();
        tx.begin();
        em.persist(jogador);
        tx.commit();
        em.close();
    }

    public List<Jogador> getJogadores() {
        em = JpaUtil.getEntityManager();
        List<Jogador> lista = new ArrayList<>();


        Query query = em.createQuery("select j from Jogador j");
        lista = query.getResultList();

        return lista;
    }


    public void remover(Jogador jogador){
        em = JpaUtil.getEntityManager();
        tx = em.getTransaction();
        tx.begin();
        em.remove(jogador);
        tx.commit();
        em.close();
    }

    public void editar(Jogador jogador) {
        em = JpaUtil.getEntityManager();
        tx = em.getTransaction();
        tx.begin();
        em.merge(jogador);
        tx.commit();
        em.close();
    }

    public Jogador buscar(int idJogador) {
        em = JpaUtil.getEntityManager();
        Jogador j = em.find(Jogador.class, idJogador);
        em.close();
        return  j;
    }
}
