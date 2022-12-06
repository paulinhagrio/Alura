package TesteDominio;

import Dominio.Funcionario;
import Dominio.Gerente;

public class TesteFuncionario {
    public static void main(String[] args) {
        Gerente nico = new Gerente();

        nico.setNome("Paul");
        nico.setCpf("123.456.789-00");
        nico.setSalario(1000.00);

        System.out.println("Meu nome é " + nico.getNome() + ", meu cpf é " + nico.getCpf()
                + " e meu salário é: " + nico.getSalario());

        System.out.println("Recebi de bonificação: " + nico.getBonificacao());
    }
}
