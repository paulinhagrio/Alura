package br.com.alura.leilao.dao;

import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import br.com.alura.leilao.util.JPAUtil;
import br.com.alura.leilao.util.builder.LanceBuilder;
import br.com.alura.leilao.util.builder.LeilaoBuilder;
import br.com.alura.leilao.util.builder.UsuarioBuilder;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LanceDaoTest {

    private LanceDao dao;
    private EntityManager em;

    @BeforeEach
    public void beforeEach(){
        this.em = JPAUtil.getEntityManager();
        this.dao = new LanceDao(em);
        em.getTransaction().begin();
    }

    @AfterEach
    public void afterEach(){
        em.getTransaction().rollback();   // rollback() => após executar cada teste e ter feito todas as modificações no
                               // banco de dado, tudo será desfeito para o próximo teste (o banco será zerado novamente)
    }

    @Test
    void deveriaCadastrarUmLance(){
        Usuario usuario = new UsuarioBuilder()
                .comNome("fulano")
                .comEmail("fulano@email.com")
                .comSenha("12345678")
                .criar();
        em.persist(usuario);

        Leilao leilao = new LeilaoBuilder()
                .comNome("mochila")
                .comValorInicial("500")
                .comData(LocalDate.now())
                .comUsuario(usuario)
                .criar();

        em.persist(leilao);

        Lance lance = new LanceBuilder()
                .comValor("70")
                .comData(LocalDate.now())
                .comUsuario(usuario)
                .comLeilao(leilao)
                .criar();

        em.persist(lance);

       lance = dao.salvar(lance);

        Lance salvo = dao.salvar(lance);
        Assert.assertNotNull(lance);

    }

    @Test
    void deveriaBuscarOMaiorLanceDoLeilao(){
        List<Lance> lances = new ArrayList<>();

        Usuario usuario = new UsuarioBuilder()
                .comNome("fulano")
                .comEmail("fulano@email.com")
                .comSenha("12345678")
                .criar();
        em.persist(usuario);

        Leilao leilao = new LeilaoBuilder()
                .comNome("mochila")
                .comValorInicial("500")
                .comData(LocalDate.now())
                .comUsuario(usuario)
                .criar();

        em.persist(leilao);

        Lance lance = new LanceBuilder()
                .comValor("700")
                .comData(LocalDate.now())
                .comUsuario(usuario)
                .comLeilao(leilao)
                .criar();

        em.persist(lance);

       lance = dao.salvar(lance);


        Lance lanceMaior = this.dao.buscarMaiorLanceDoLeilao(leilao);
        Assert.assertNotNull(lanceMaior);

    }
}
