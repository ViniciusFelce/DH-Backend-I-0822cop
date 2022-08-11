package tests;

import entities.Quadrado;
import entities.Triangulo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.FlyweightFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlyweghtFactoryTest {

    Triangulo t1, t2, t3;
    Quadrado q1, q2, q3;

    @BeforeEach
    void doBefore() {
        t1 = FlyweightFactory.criarTriangulo("Vermelho");
        t2 = FlyweightFactory.criarTriangulo("Azul");
        t3 = FlyweightFactory.criarTriangulo("Azul");
    }

    @Test
    void triangulosIguais() {
        // Retorna um boolean - se for true o teste passa, senão dará erro;
        assertEquals("Vermelho", t1.getCor());
        assertEquals("Azul", t2.getCor());
        //assertEquals("Roxo", t3.getCor());
    }
}
