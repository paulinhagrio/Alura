package br.com.alura.escola.infra.indicacao;

import br.com.alura.escola.dominio.EnviarEmailIndicacao;
import br.com.alura.escola.dominio.aluno.Aluno;

public class EnviarEmailIndicacaoComJavaMail implements EnviarEmailIndicacao {
    @Override
    public void enviarPara(Aluno indicado) {
        // lógica de envio de emails com a lib JAVA Mail
    }
}
