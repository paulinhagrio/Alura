package domain;

public class NotasServico {

    private int numero;
    private String mes;
    private double valorTotal;
    private String cliente;
    private double aliquota;

    public NotasServico(int numero, String mes, double valorTotal, String cliente, double aliquota) {
        this.numero = numero;
        this.mes = mes;
        this.valorTotal = valorTotal;
        this.cliente = cliente;
        this.aliquota = aliquota;
    }

    @Override
    public String toString() {

        return "[NFS: " + this.numero + ", " + this.mes + ", " + +this.valorTotal + ", " +
                this.cliente + ", " + this.aliquota + "]";
    }
}
