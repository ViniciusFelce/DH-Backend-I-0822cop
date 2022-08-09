package factory;

import entities.Computador;

import java.util.HashMap;
import java.util.Map;

public class ComputadorFactory {

    private static Map<String, Computador> flyweight = new HashMap<>();

    public Computador getComputador(int id, int ram, int hd) { // 2 16 500

        String comp = "RAM: " + ram + " - HD: " + hd + ". ";
        System.out.printf(comp);

        if (flyweight.containsKey(comp)) {
            System.out.println("PC obtido da memória.");
            return flyweight.get(comp); // Busca a chave do objeto.
        } else { // O método put adiciona um registro no Map
            flyweight.put(comp, new Computador(id, ram, hd)); // 1 16 500
            System.out.println("PC instanciado!");
            return flyweight.get(comp);
        }
    }
}
