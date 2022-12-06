package dominio;

public class TestaGetESet {
    public static void main(String[] args) {

        Conta conta = new Conta(1337, 24226);
        //conta.numero = 1337; => não funciona mais pq o atributo agora é privado
       // conta.setNumero(1337); => não precisa mais porque já foi setado ali em cima no construtor
        System.out.println(conta.getNumero());     //invocando o método

        Cliente paulo = new Cliente();
        //conta.titular = paulo; => não pode mais fazer assim pq os atributos agora são privados
        conta.setTitular(paulo);
        paulo.setNome("paulo silveira");

        System.out.println(conta.getTitular().getNome());

        conta.getTitular().setProfissao("programador");
        //agora em duas linhas:
        Cliente titularDaConta = conta.getTitular();
        titularDaConta.setProfissao("programador");

        System.out.println(titularDaConta);
        System.out.println(paulo);
        System.out.println(conta.getTitular());





    }
}
