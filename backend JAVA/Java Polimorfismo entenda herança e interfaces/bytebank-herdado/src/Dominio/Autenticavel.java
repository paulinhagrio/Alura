package Dominio;
    //Definimos um contrato chamado Autenticável
    //Quem assina esse contrato precisa:
        //implementar o método setSenha e o método autentica
public abstract interface Autenticavel {


    public abstract boolean autentica(int senha);

    public abstract void setSenha(int senha);
}
