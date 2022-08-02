package tests;

import entities.Contratado;
import entities.Efetivo;
import entities.Funcionario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FuncionarioTest {

    Funcionario funcionario1, funcionario2;

    @BeforeEach
    void doBefore() {
        funcionario1 = new Efetivo("Odair", "Antunes", "321654", 3000.0, 1000.0, 500.0);

        funcionario2 = new Contratado("Marlene", "Peixoto", "456789", 50.0, 70);
    }

    @Test
    void tests() {
        funcionario1.pagamentoSalario();
        funcionario2.pagamentoSalario();
    }

}
