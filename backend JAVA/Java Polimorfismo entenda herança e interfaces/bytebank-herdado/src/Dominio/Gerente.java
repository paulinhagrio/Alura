package Dominio;
// Gerente é um Funcionario; Gerente herda da Classe Funcionario e assina o contrato autenticavel;
// Gerente é um autenticável
public class Gerente extends Funcionario implements Autenticavel{

    private AutenticacaoUtil autenticador;

    public Gerente(){
        this.autenticador = new AutenticacaoUtil()

    }


    public Double getBonificacao(){
        System.out.println("Chamando o método de bonificacao do gerente");
        return super.getSalario();
    }

    @Override
    public void setSenha(int senha){
        this.autenticador.setSenha(senha);
    }

    @Override
    public boolean autentica(int senha) {
        return this.autenticador.autentica(senha);
    }
}
