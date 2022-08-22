import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Programa {

    public static void main(String[] args) {

        List<Cachorro> cachorros = new ArrayList<>();

        Cachorro c1 = new Cachorro("Pluto", "Fila", 5, "Av. Bento Gonçalves, 254");
        Cachorro c2 = new Cachorro("Tob", "Beagle", 3, "Rua das Hortências, 569");

        cachorros.add(c1);
        cachorros.add(c2);

        // Salvar esta coleção em um arquivo .txt
        FileOutputStream fo = null;

        try {
            fo = new FileOutputStream("saida.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fo);
            oos.writeObject(cachorros);
        }
        catch (FileNotFoundException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        // Recuperar a coleção de um arquivo .txt
        List<Cachorro> recuperaCachorros = null;
        FileInputStream fi = null;

        try {
            fi = new FileInputStream("saida.txt");
            ObjectInputStream ois = new ObjectInputStream(fi);
            recuperaCachorros = (ArrayList)ois.readObject();
        }
        catch (FileNotFoundException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        for (Cachorro cach : recuperaCachorros) {
            System.out.println(
                cach.getNome() + " | " +
                cach.getRaca() + " | " +
                cach.getIdade() + " | " +
                cach.getEndereco());
        }
    }

}
