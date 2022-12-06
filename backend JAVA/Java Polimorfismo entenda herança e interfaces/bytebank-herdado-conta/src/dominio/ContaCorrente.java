package dominio;

public class ContaCorrente extends Conta implements Tributavel{


    public ContaCorrente(int agencia, int numero) {  //criado Construtor com os parâmetros da Classe mãe
        super(agencia, numero);
    }



    @Override
    public void saca(double valor) throws SaldoInsuficienteException {  // mantivemos a assinatura do método e só alteramos a implementacao
        double valorASacar = valor + 0.20;
        super.saca(valorASacar);
    }

    @Override
    public void deposita(double valor) {
        super.saldo += valor;

    }

    @Override
    public double getValorImposto() {
        return super.saldo * 0.01;
    }
}
