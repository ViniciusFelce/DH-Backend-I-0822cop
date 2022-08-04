import entities.CheckMail;
import entities.Mail;

public class Programa {

    public static void main(String[] args) {

        CheckMail verificaMail = new CheckMail();

        verificaMail.verificar(
                new Mail("email@email.com", "tecnica@dh.com.br", "Aulas")
        );

        verificaMail.verificar(
                new Mail("email@email.com", "sds@dh.com.br", "Gerência")
        );

        verificaMail.verificar(
                new Mail("email@email.com", "sds@dh.com.br", "Comercial")
        );

        verificaMail.verificar(
                new Mail("email@email.com", "tecnica@colmeia.com", "Sextou!")
        );

    }

}
