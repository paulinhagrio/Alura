package br.com.alura.escola.dominio.aluno;

public class FabricaDeAlunos {
    private Aluno aluno;

    public FabricaDeAlunos comNomeCPFEmail(String nome, String cpf, String email){
        this.aluno = new Aluno(new CPF(cpf), nome, new Email(email));
        return this;
    }

    public FabricaDeAlunos  comTelefone(String ddd, String numero){
        this.aluno.adicionarTelefone(ddd, numero);
        return this;
    }

    public Aluno criar(){
        return this.aluno;
    }

    public static void main(String[] args) {
        FabricaDeAlunos fabrica = new FabricaDeAlunos();
        Aluno aluno2 = fabrica.comNomeCPFEmail("", "", "")
                .comTelefone("", "")
                .comTelefone("", "")
                .criar();
    }
}
