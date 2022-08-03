package tests;

import entities.Afiliado;
import entities.Funcionario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VendedorTest {

    Funcionario f1, f2;
    Afiliado a1, a2;

    @BeforeEach
    void doBefore() {
        f1 = new Funcionario("Pedro", 1);
        f1.vender(1);

        f2 = new Funcionario("Maria", 2);
        f2.vender(1);

        a1 = new Afiliado("Ramon");
        a1.vender(1);

        a2 = new Afiliado("Paulo");
        a2.vender(1);

        f1.addAfiliado(a1);
        f1.addAfiliado(a2);
    }

    @Test
    void tests() {
        System.out.println(f1.mostrarCategoria());
        System.out.println(f2.mostrarCategoria());
        System.out.println(a1.mostrarCategoria());
        System.out.println(a2.mostrarCategoria());
    }
}
