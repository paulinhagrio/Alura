package br.com.alura.escola.dominio.aluno;

import java.util.List;

public interface RepositorioDeAlunos {
    void matricular(Aluno aluno);   //método que vai salvar no Banco de Dados

    Aluno buscarPorCPF(CPF cpf);

    List<Aluno> listarTodosOsAlunosMatriculados();

    //Aqui na Camada de domínio definimos os comportamentos e deixamos a
    // implementação para a parte de Infraestrutura
}
