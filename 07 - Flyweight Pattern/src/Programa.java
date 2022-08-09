import entities.Computador;
import factory.ComputadorFactory;

public class Programa {

    public static void main(String[] args) {

        ComputadorFactory fabrica = new ComputadorFactory();

        Computador mac1 = fabrica.getComputador(1, 16, 500);
        Computador mac2 = fabrica.getComputador(2, 16, 500);
        Computador mac3 = fabrica.getComputador(3, 32, 1000);

        Computador win1 = fabrica.getComputador(4, 64, 1000);
        Computador win2 = fabrica.getComputador(5, 64, 1000);

        System.out.println("MAC1: " + mac1);
        System.out.println("MAC2: " + mac2); // Pega da memória
        System.out.println("MAC3: " + mac3);
        System.out.println("Windows1: " + win1);
        System.out.println("Windows2: " + win2); // Pega da memória

    }

}
