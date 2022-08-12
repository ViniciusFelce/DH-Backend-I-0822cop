import java.util.Arrays;

public class Programa {

    public static void main(String[] args) {

        ListaMedia listaMediaMaior5 = new ListaMedia(Arrays.asList(1, 2, 3, 4, 5, 6));

        ListaMedia listaMediaMaior10 = new ListaMedia(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11));

        int listaMedia = new ListaMedia(Arrays.asList(1,2,3,4,5)).media();

        ListaMedia listaMediaVazia = new ListaMedia(Arrays.asList());


    }

}
