package dominio;

public class SaldoInsuficienteException extends Exception{ // checked

    public SaldoInsuficienteException(String msg){     //construtor recebendo uma mensagem
        super(msg);                                    //chamando o construtor da Classe mãe que recebe uma mensagem

    }
}
