package br.com.alura.escola.dominio.aluno;

public class Email {
    // Essa classe não é uma entidade pq ela não diferencia seus objetos de nenhumma forma
    // Esse tipo de Classe é chamada de VALUE OBJECT  (Se 2 emails tiverem o mesmo endereço será o mesmo e-mail)
    private String endereco;

    public Email(String endereco) {
        if (endereco == null ||
                !endereco.matches("^[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            throw new IllegalArgumentException("E-mail invalido!");
        }

        this.endereco = endereco;
    }

    public String getEndereco() {
        return endereco;
    }
}
