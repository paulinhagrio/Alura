package br.com.alura.loja.testes;

import br.com.alura.loja.dao.CategoriaDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.time.LocalDate;

public class TesteCriteria {
    public static void main(String[] args) {
    popularBancoDeDados();
    EntityManager em = JPAUtil.getEntityManager();
    ProdutoDao produtoDao = new ProdutoDao(em);
    produtoDao.buscarPorParametrosComCriteria(null, null, LocalDate.now());


}

    private static void popularBancoDeDados() {
        Categoria celulares = new Categoria("CELULARES");
        Categoria videogames = new Categoria("VIDEOGAMES");
        Categoria informatica = new Categoria("INFORMATICA");

        Produto celular = new Produto("xiaomi","muito legal",new BigDecimal("800"), celulares);
        Produto videogame = new Produto("PS5","Playstation 5",new BigDecimal("5000"), videogames);
        Produto macbook = new Produto("Macbook","Macbook pro retil",new BigDecimal("7000"), informatica);

        //Cliente cliente = new Cliente("Rodrigo", "12345");

        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);
        CategoriaDao categoriaDao = new CategoriaDao(em);


        em.getTransaction().begin();

        categoriaDao.cadastrar(celulares);
        categoriaDao.cadastrar(videogames);
        categoriaDao.cadastrar(informatica);

        produtoDao.cadastrar(celular);
        produtoDao.cadastrar(videogame);
        produtoDao.cadastrar(macbook);


        em.getTransaction().commit();
        em.close();

    }

}