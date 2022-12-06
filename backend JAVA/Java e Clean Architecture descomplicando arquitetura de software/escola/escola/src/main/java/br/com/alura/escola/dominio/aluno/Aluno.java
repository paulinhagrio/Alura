package br.com.alura.escola.dominio.aluno;

import java.util.ArrayList;
import java.util.List;

public class Aluno {
// entidade => é quando podemos diferenciar dois objetos (por exemplo diferenciar alunos através do cpf)

    private CPF cpf;
    private String nome;
    private Email email;

    private List<Telefone> telefones = new ArrayList<>();
    private String senha;   // a implementação faz parte de Infraestrutura


    public void adicionarTelefone(String ddd, String numero){
        this.telefones.add(new Telefone(ddd, numero));
    }

    public Aluno(CPF cpf, String nome, Email email) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
    }

    public String getCpf() {
        return cpf.getNumero();
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email.getEndereco();
    }


    public List<Telefone> getTelefones() {
        return telefones;
    }


    public static void main(String[] args) {
        Aluno a = new Aluno(
                new CPF("123"),
                "Fulano da Silva",
                new Email("email"));
    }
}
