package tests;

import entities.Contratado;
import entities.Efetivo;
import entities.Funcionario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FuncionarioTest {

    Funcionario funcionario1, funcionario2;

    @BeforeEach
    void preparacao() {
        funcionario1 = new Efetivo("Odair", "Antunes", "1234567890",
                3000.0, 1000.0, 500.0);

        funcionario2 = new Contratado("Marlene", "Peixoto", "9876543210",
                70.0, 50);
    }

    @Test
    void tests() {
        funcionario1.pagamentoSalario();
        funcionario2.pagamentoSalario();
    }
}
