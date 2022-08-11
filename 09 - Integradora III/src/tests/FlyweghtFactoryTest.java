package tests;

import entities.Quadrado;
import entities.Triangulo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.FlyweightFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class FlyweghtFactoryTest {

    Triangulo t1, t2, t3;
    Quadrado q1, q2, q3;

    @BeforeEach
    void doBefore() {
        t1 = FlyweightFactory.criarTriangulo("Vermelho");
        t2 = FlyweightFactory.criarTriangulo("Azul");
        t3 = FlyweightFactory.criarTriangulo("Azul");

        q1 = FlyweightFactory.criarQuadrado(2);
        q2 = FlyweightFactory.criarQuadrado(5);
        q3 = FlyweightFactory.criarQuadrado(5);
    }

    @Test
    void triangulosIguais() {
        // Retorna um boolean - se for true o teste passa, senão dará erro;
        assertEquals("Vermelho", t1.getCor());
        assertEquals("Azul", t2.getCor());
        //assertEquals("Roxo", t3.getCor());
        System.out.println("Qtde de objetos do tipo Triângulo: " + FlyweightFactory.trianguloMap.size());
    }

    @Test
    void triangulosNaoIguais() {
        assertNotEquals("cinza", t1.getCor());
        assertNotEquals(false, FlyweightFactory.trianguloMap.size() == 2);
    }

    @Test
    void quadradosIguais() {
        assertEquals(2, q1.getTamanho());
        assertEquals(5, q2.getTamanho());
        assertEquals(true, FlyweightFactory.quadradoMap.size() == 2);
        System.out.println("Qtde de objetos do tipo Quadrado: " + FlyweightFactory.quadradoMap.size());
    }

    @Test
    void quadradosNaoIguais() {
        assertNotEquals(20, q1.getTamanho());
        assertNotEquals(15, q2.getTamanho());
        assertNotEquals(false, FlyweightFactory.quadradoMap.size() == 2);
    }

}