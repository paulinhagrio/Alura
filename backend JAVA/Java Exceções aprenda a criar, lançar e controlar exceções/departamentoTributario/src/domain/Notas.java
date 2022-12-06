package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Notas {
    private int numero;
    private String mes;
    private double valorTotal;
    private String Fornecedor;
    private String cliente;
    private double retencaoIss;
    private double retencaoPcc;
    private double retencaoInss;
    private double aliquota;
    private List<NotasServico> notasFiscaisServico = new ArrayList<>();

    public Notas(String mes, String cliente) {
        this.mes = mes;
        cliente = cliente;
    }

    public int getNumero() {
        return numero;
    }

    public String getMes() {
        return mes;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public String getCliente() {
        return cliente;
    }

    public List<NotasServico> getNotasFiscaisServico() {
        return Collections.unmodifiableList(notasFiscaisServico);

    }

    public void adiciona(NotasServico nfservico){
        this.notasFiscaisServico.add(nfservico);
    }

//    @Override
//    public String toString() {
//
//        return "[NFS: " + this.numero + ", " +  this.mes + ", " + + this.valorTotal + ", " +
//                this.cliente + ", " + this.aliquota + "]";
//    }
}
