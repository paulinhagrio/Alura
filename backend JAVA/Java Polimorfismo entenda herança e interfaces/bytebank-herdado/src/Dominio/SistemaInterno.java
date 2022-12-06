package Dominio;

public class SistemaInterno {
    private int senha = 2222;
    public void autentica(Autenticavel fa){
        boolean autenticou = fa.autentica(this.senha);
        if(autenticou){
            System.out.println("Senha ok. Pode entrar no sistema");
        }else {
            System.out.println("Senha incorreta. Não pode entrar no sistema");
        }
    }
}
