package net.maromo.bean;

import net.maromo.dao.JogadorDao;
import net.maromo.model.Jogador;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.List;

@ManagedBean
@SessionScoped
public class JogadorBean {
    private Jogador jogador;
    private JogadorDao dao = new JogadorDao();


    @PostConstruct
    public void init() {
        jogador = new Jogador();
    }

    public Jogador getJogador() {

        return jogador;
    }

    public List<Jogador> getJogadores() {
        return dao.getJogadores();
    }

    public String adicionar() {
        dao.adicionar(jogador);

        jogador = new Jogador();
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null,
                new FacesMessage("Jogador adicionado com sucesso!"));
        context.getExternalContext().getFlash().setKeepMessages(true);
        return "home";
    }

    public String editar() {
        dao.editar(jogador);

             jogador = new Jogador();

             FacesContext context = FacesContext.getCurrentInstance();
             context.addMessage(null, new FacesMessage("Jogador editado com sucesso!"));
             context.getExternalContext().getFlash().setKeepMessages(true);

             return "home";
    }

    public String remover() {
         dao.remover(jogador);

         jogador = new Jogador();

         FacesContext context = FacesContext.getCurrentInstance();
         context.addMessage(null, new FacesMessage("Jogador removido com sucesso!"));
         context.getExternalContext().getFlash().setKeepMessages(true);

        return "home";
    }
    public void jogadorPorId() {
        jogador = dao.buscar(jogador.getIdJogador());
        if (jogador == null || jogador.getIdJogador()== 0) {
            jogador = new Jogador();
            FacesMessage message = new FacesMessage("Jogador não encontrado.");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
}

