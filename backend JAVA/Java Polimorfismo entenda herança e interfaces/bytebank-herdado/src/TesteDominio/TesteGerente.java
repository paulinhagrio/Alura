package TesteDominio;

import Dominio.Autenticavel;
import Dominio.Gerente;

public class TesteGerente {
    public static void main(String[] args) {

        Autenticavel gerente = new Gerente();

        Gerente g1 = new Gerente();
        g1.setNome("Carlos");
        g1.setCpf("111.222.333-00");
        g1.setSalario(5000.00);

        System.out.println("Meu nome é " + g1.getNome() + ", meu cpf é " + g1.getCpf()
                + " e meu salário é: " + g1.getSalario());

        g1.setSenha(2222);
        boolean autenticou = g1.autentica(2222);
        System.out.println(autenticou);

        System.out.println(g1.getBonificacao());


    }
}
