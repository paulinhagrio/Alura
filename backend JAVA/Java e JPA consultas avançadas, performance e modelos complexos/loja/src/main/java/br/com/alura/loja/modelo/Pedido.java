package br.com.alura.loja.modelo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity  //Fazendo o mapeamento objeto relacional ORM => @Entity indica que é uma entidade da Jpa, que existe uma tabela no banco de dados que é o espelho dessa Classe.
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // indica que o banco de dados irá gerar automaticamente o valor do id
    private Long id;                                  //É .IDENTITY porque o id não será sequencial
    @Column(name = "valor_total")
    private BigDecimal valorTotal = BigDecimal.ZERO;   //Iniciando o valor total com zero
    private LocalDate data = LocalDate.now();
    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente cliente;
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<ItemPedido> itens = new ArrayList<>();

    public Pedido() {
    }

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
    }

    public void adicionarItem(ItemPedido item){
        item.setPedido(this);
        this.itens.add(item);
        this.valorTotal = this.valorTotal.add(item.getValor());

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }
}

