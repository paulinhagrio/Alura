package dominio;

public class Conta {
    private double saldo;
    private int agencia;
    private int numero;
    private Cliente titular;
    private static int total;


    public void deposita(double valor){
        this.saldo += valor;

    }

    public boolean saca(double valor){
        if(this.saldo >= valor){
            this.saldo -= valor;
            return true;
        }else {
            return false;
        }
    }

    public boolean transfere(double valor, Conta destino){
        if(saca(valor)){
            destino.deposita(valor);
            return true;
        }
        return false;
    }

    public Conta(int agencia, int numero){
        Conta.total++;   //não é necessário escrever Conta nesse caso mas é só para deixar claro que se refere à classe e não ao objeto
        //System.out.println("o total de contas é " + Conta.total);
        this.agencia = agencia;
        this.numero = numero;
       // System.out.println("Estou criando uma conta " + numero);
    }

    public double getSaldo(){
        return this.saldo;
    }

    public int getNumero(){
        return this.numero;
    }

    public void setNumero(int numero){  // numero = variável temporária => novoNumero
        if(numero <=0){
            System.out.println("não pode valor menor ou igual a 0");
            return;
        }
        this.numero = numero;
    }

    public int getAgencia() {
        return this.agencia;
    }

    public void setAgencia(int agencia) {
        if(agencia <=0){
            System.out.println("não pode valor menor ou igual a 0");
            return;
        }
        this.agencia = agencia;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    public Cliente getTitular() {
        return titular;
    }

    public static int getTotal() {
        return total;
    }
}

