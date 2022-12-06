package br.com.alura.escola.dominio.aluno;

import br.com.alura.escola.dominio.aluno.Telefone;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TelefoneTest {
    @Test
    void naoDeveriaCriarTelefoneComDddInvalido(){
        assertThrows(IllegalArgumentException.class,
                () -> new Telefone("", "123456789"));


        assertThrows(IllegalArgumentException.class,
                () -> new Telefone(null, "123456789"));

        assertThrows(IllegalArgumentException.class,
                () -> new Telefone("333", "123456789"));
    }

    @Test
    void naoDeveriaCriarTelefoneComNumeroInvalido(){
        assertThrows(IllegalArgumentException.class,
                () -> new Telefone("21", ""));


        assertThrows(IllegalArgumentException.class,
                () -> new Telefone("21", null));

        assertThrows(IllegalArgumentException.class,
                () -> new Telefone("21", "1234567"));
    }

    @Test
    void deveriaPermitirCriarTelefoneComDDDENumeroValidos(){
        String ddd = "21";
        String numero = "123456789";

        Telefone telefone = new Telefone(ddd, numero);
        assertEquals(ddd, telefone.getDdd());
        assertEquals(numero, telefone.getNumero());
    }
}
