package domain;

public class TesteReferencias {
    public static void main(String[] args) {
        Conta primeiraConta = new Conta();
        primeiraConta.saldo = 300;

        System.out.println("saldo da primeira conta: " + primeiraConta.saldo);

        Conta segundaConta = primeiraConta;

        System.out.println("saldo da segunda conta " + segundaConta.saldo);

        segundaConta.saldo += 100;
        System.out.println("saldo da segunda conta: " + segundaConta.saldo);
        System.out.println("saldo da primeira conta: " + primeiraConta.saldo);

        if(primeiraConta == segundaConta) {
            System.out.println("são as mesmissimas contas");
        }

        System.out.println(primeiraConta);
        System.out.println(segundaConta);
    }
}
