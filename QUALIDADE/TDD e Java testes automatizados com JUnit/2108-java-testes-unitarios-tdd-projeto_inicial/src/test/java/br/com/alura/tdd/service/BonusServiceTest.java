package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.Assert.*;

class BonusServiceTest {
    @Test
    void bunusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto(){

        BonusService service = new BonusService();

        assertThrows(IllegalArgumentException.class,
                () -> service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("25000")))); //LocalDate.now() = data atual


// Uma segunda maneira seria utilizando o try / catch:

//        try {
//            service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("25000")));
//            fail("não deu a exception");
//        }catch (Exception e) {
//            assertEquals("Funcionario com o salario maior que dez mil Reais não pode receber bonuns", e.getMessage());
//                                                                                                    // Verifica se está vindo a mensagem corretamente
//
//        }
    }

    @Test
    void bunusDeveriaSerDezPorCentoDoSalario() {

        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("2500")));


        assertEquals(new BigDecimal("250.00"), bonus);
    }



    @Test
    void bunusDeveriaSerDezPorCentoParaSalarioDeExatamenteDezMilReais() {

        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("10000")));


        assertEquals(new BigDecimal("1000.00"), bonus);
    }
}
