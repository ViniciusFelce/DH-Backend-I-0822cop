package factory;

import entities.Arvore;

import java.util.HashMap;
import java.util.Map;

public class ArvoreFactory {

    private static Map<String, Arvore> flyweight = new HashMap<>();

    public Arvore getArvore(int altura, int largura, String cor, String tipo) {

        String arvore = "Altura: " + altura + " - Largura: " + largura +
                " - Cor: " + cor + " - Tipo: " + tipo + ". ";
        System.out.println(arvore);

        if (flyweight.containsKey(arvore)) {
            System.out.println("Árvore obtida da memória.");
            System.out.println("----------------------------------------------------------");
            return flyweight.get(arvore); // Busca a chave do objeto.
        } else { // O método put adiciona um registro no Map
            flyweight.put(arvore, new Arvore(altura, largura, cor, tipo)); // 1 16 500
            System.out.println("Árvore instanciada!");
            System.out.println("----------------------------------------------------------");
            return flyweight.get(arvore);
        }
    }
}
