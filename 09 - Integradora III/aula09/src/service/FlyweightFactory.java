package service;

import entities.Quadrado;
import entities.Triangulo;

import java.util.HashMap;
import java.util.Map;

public class FlyweightFactory {

    public static final Map<String, Triangulo> trianguloMap = new HashMap<>();
    public static final Map<Integer, Quadrado> quadradoMap = new HashMap<>();

    public static Triangulo criarTriangulo(String cor) {

        String corRec = cor;

        if (trianguloMap.containsKey(corRec)) {
            System.out.println("Triângulo obtido da memória.");
            return trianguloMap.get(corRec);
        } else {
            trianguloMap.put(corRec, new Triangulo(cor));
            System.out.println("Triângulo instanciado");
            return trianguloMap.get(corRec);
        }
    }

    public static Quadrado criarQuadrado(int tamanho) {
        int tamRec = tamanho;

        if (quadradoMap.containsKey(tamRec)) {
            System.out.println("Quadrado obtido da memória");
            return quadradoMap.get(tamRec);
        } else {
            quadradoMap.put(tamRec, new Quadrado(tamanho));
            System.out.println("Quadrado instanciado");
            return quadradoMap.get(tamRec);
        }
    }

}
