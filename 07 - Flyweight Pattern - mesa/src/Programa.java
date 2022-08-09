import entities.Arvore;
import factory.ArvoreFactory;

public class Programa {

    public static void main(String[] args) {

        ArvoreFactory fabrica = new ArvoreFactory();

        for (int i = 0; i < 500000; i++) {
            Arvore arvoreOrnamental = fabrica.getArvore(200, 400, "Verde", "Ornamental");
            Arvore arvoreFrutifera = fabrica.getArvore(500, 300, "Vermelho", "Frutíferas");
        }

//        Arvore arvore1 = fabrica.getArvore(200, 400, "Verde", "Ornamental");
//        Arvore arvore2 = fabrica.getArvore(200, 400, "Verde", "Ornamental");
//
//        Arvore arvore3 = fabrica.getArvore(500, 300, "Vermelho", "Frutíferas");
//        Arvore arvore4 = fabrica.getArvore(500, 300, "Vermelho", "Frutíferas");

//        Arvore arvore5 = fabrica.getArvore(100, 200, "Azul", "Florífera");
//        Arvore arvore6 = fabrica.getArvore(100, 200, "Azul", "Florífera");

        System.out.println("");

//        System.out.println("Árvore 1: " + arvore1);
//        System.out.println("Árvore 2: " + arvore2);
//        System.out.println("Árvore 3: " + arvore3);
//        System.out.println("Árvore 4: " + arvore4);
//        System.out.println("Árvore 5: " + arvore5);
//        System.out.println("Árvore 6: " + arvore6);

        System.out.println("");

        Runtime runtime = Runtime.getRuntime();
        System.out.println("Memória total: " + runtime.totalMemory() / (1024 * 1024));
        System.out.println("Memória utilizada: " + (runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024));

    }

}
