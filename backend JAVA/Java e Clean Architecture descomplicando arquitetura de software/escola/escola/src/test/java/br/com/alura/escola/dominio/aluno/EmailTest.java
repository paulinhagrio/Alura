package br.com.alura.escola.dominio.aluno;

import br.com.alura.escola.dominio.aluno.Email;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class EmailTest {
    @Test
    void naoDeveriaCriarEmailsComEnderecosInvalidos(){
        assertThrows(IllegalArgumentException.class,
                () -> new Email(null));    //se criar um email passando null, esperamos receber a excessão acima

        assertThrows(IllegalArgumentException.class,
                () -> new Email(""));

        assertThrows(IllegalArgumentException.class,
                () -> new Email("emailinvalido"));

    }
}