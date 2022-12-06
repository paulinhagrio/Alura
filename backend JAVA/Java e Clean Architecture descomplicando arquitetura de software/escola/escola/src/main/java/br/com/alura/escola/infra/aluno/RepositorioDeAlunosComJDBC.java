package br.com.alura.escola.infra.aluno;

import br.com.alura.escola.dominio.aluno.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepositorioDeAlunosComJDBC implements RepositorioDeAlunos {
    private final Connection connection;

    public RepositorioDeAlunosComJDBC(Connection connection) {  //quem for instanciar essa classe será responsável por passar uma connecition
        this.connection = connection;
    }

    @Override
    public void matricular(Aluno aluno) {  //quando esse método for chamado já teremos a conexão (feita acima)
        try {
            String sql = "INSERT INTO ALUNO VALUES(?, ?, ?)"; //temos que passar o CPF, o nome e o e-mail, referentes à classe Aluno
            PreparedStatement ps = connection.prepareStatement(sql); //para rodar o comando acima
            ps.setString(1, aluno.getCpf());
            ps.setString(2, aluno.getNome());
            ps.setString(3, aluno.getEmail());
            ps.execute();  //vai disparar esse Insert lá no Banco de Dados  (H2, SQLITE, MYSQL, etc)

            sql = "INSERT INTO TELEFONE VALUES(?, ?)";  //Depois que inserimos o aluno, modificamos o SQL para inserir o telefone
            ps = connection.prepareStatement(sql);
            for (Telefone telefone : aluno.getTelefones()) {
                ps.setString(1, telefone.getDdd());
                ps.setString(2, telefone.getNumero());
                ps.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Aluno buscarPorCPF(CPF cpf) {  //são consultas => utilizar SELEC ao invés do INSERT
        try {
            String sql = "SELECT id, nome, email FROM ALUNO WHERE cpf = ?";
            PreparedStatement ps = connection.prepareStatement(sql); //para rodar o comando acima
            ps.setString(1, cpf.getNumero());

            ResultSet rs = ps.executeQuery();  //Como é uma consulta (um Select) precisamos usar o ResutSet
            boolean encontrou = rs.next();
            if (!encontrou) {
                throw new AlunoNaoEncontrado(cpf);
            }

            String nome = rs.getString("nome");
            Email email = new Email(rs.getString(""));
            Aluno encontrado = new Aluno(cpf, nome, email);

            Long id = rs.getLong("id");
            sql = "SELECT ddd, numero FROM TELEFONE WHERE aluno_id = ?";
            ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            while ((rs.next())) {
                String numero = rs.getString("numero");
                String ddd = rs.getString("ddd");
                encontrado.adicionarTelefone(ddd, numero);
            }

            return encontrado;


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public List<Aluno> listarTodosOsAlunosMatriculados() {  //são consultas
        try {
            String sql = "SELECT id, cpf, nome, email FROM ALUNO ";
            PreparedStatement ps = connection.prepareStatement(sql); //para rodar o comando acima
            ResultSet rs = ps.executeQuery();  //Como é uma consulta (um Select) precisamos usar o ResutSet
            List<Aluno> alunos = new ArrayList<>();
            while (rs.next()) {
                CPF cpf = new CPF(rs.getString("cpf"));
                String nome = rs.getString("nome");
                Email email = new Email(rs.getString("email"));
                Aluno aluno = new Aluno(cpf, nome, email);

                Long id = rs.getLong("id");
                sql = "SELECT ddd, numero FROM TELEFONE WHERE aluno_id = ?";
                PreparedStatement psTelefone = connection.prepareStatement(sql);
                ps = connection.prepareStatement(sql);
                ps.setLong(1, id);
                rs = ps.executeQuery();
                while ((rs.next())) {
                    String numero = rs.getString("numero");
                    String ddd = rs.getString("ddd");
                    aluno.adicionarTelefone(ddd, numero);
                }

                alunos.add(aluno);
            }

            return alunos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}