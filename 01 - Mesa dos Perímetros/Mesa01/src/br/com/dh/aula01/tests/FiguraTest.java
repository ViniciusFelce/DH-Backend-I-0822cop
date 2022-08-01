package br.com.dh.aula01.tests;

import br.com.dh.aula01.entities.Circulo;
import br.com.dh.aula01.entities.Figura;
import br.com.dh.aula01.entities.Quadrado;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FiguraTest {

    Figura quadrado;
    Figura circulo;

    @BeforeEach
    void doBefore() {
        quadrado = new Quadrado(2);
        circulo = new Circulo(2);
    }

    @Test
    void buscarPerimetroCirculo() {
        Assertions.assertEquals(12.5663706143591729, circulo.calcularPerimetro());
    }

    @Test
    void buscarPerimetroQuadrado() {
        Assertions.assertEquals(8, quadrado.calcularPerimetro());
    }
}

/*
* Quadrado = 4 * 2 = 8
* Círculo = 4 * PI = 12.5663706143591729
* */