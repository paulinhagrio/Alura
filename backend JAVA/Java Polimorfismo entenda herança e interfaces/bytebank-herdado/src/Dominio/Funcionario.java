package Dominio;
  //Não pode instanciar objetos dessa classe porque agora ela é abstrata
public abstract class Funcionario {
    private String nome;
    private String cpf;
    private Double salario;

    // método sem corpo (não há implementação)
    public abstract Double getBonificacao();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }
}
