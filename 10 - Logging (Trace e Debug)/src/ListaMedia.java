import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ListaMedia {

    // Injeção da biblioteca no arquivo ListaMedia
    private static final Logger logger = Logger.getLogger(ListaMedia.class);

    private List<Integer> inteiros = new ArrayList<>();

    public ListaMedia(List<Integer> inteiros) {
        this.inteiros = inteiros;
        comparaListas(inteiros);
    }

    // Este método é privado por é chamado apenas dentro desta classe
    private void comparaListas(List<Integer> inteiros) {

        try {
            if (inteiros.size() > 5 && inteiros.size() <= 10) {
                logger.info("O comprimento da lista é maior que 5.");
            }
            if (inteiros.size() > 10) {
                logger.info("O comprimento da lista é maior que 10.");
            }
            if (inteiros.size() == 0) {
                throw new Exception();
            }
        }
        catch (Exception e) {
            logger.error("A lista está vazia!", e);
        }
    } // Fecha o método comparaListas

    public int media() {
        int soma = 0;
        for (Integer inteiro: inteiros) {
            soma += inteiro;
        }
        int media = soma / inteiros.size();
        logger.info("A média da lista é: " + media);
        return media;
    }
}
