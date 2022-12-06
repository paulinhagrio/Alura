package dominio;

public class ContaPoupanca extends Conta{
    public ContaPoupanca(int agencia, int numero) {  //criado Construtor com os parâmetros da Classe mãe
        super(agencia, numero);
    }

    @Override
    public void deposita(double valor) {
        super.saldo += valor;
    }
}
