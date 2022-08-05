package tests;

import entities.Pessoa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.ServicoVacinar;
import service.ServicoVacinarProxy;
import service.Vacinar;

import java.time.LocalDate;

public class PessoaTest {

    LocalDate diaDaVacinaAnterior, diaDaVacinaHoje;
    Pessoa p1, p2;

    @BeforeEach
    void doBefore() {
        diaDaVacinaAnterior = LocalDate.now().minusDays(4); // 2022-08-01
        diaDaVacinaHoje = LocalDate.now(); // 2022-08-05

        // Dia anterior
        p1 = new Pessoa("Jonas", "Block", "1245326598", diaDaVacinaAnterior, "Coronavac");

        // Dia de hoje
        p2 = new Pessoa("Paola", "Marques", "8594401254", diaDaVacinaHoje, "Pfizer");
    }

    @Test
    public void vac1() {
        Vacinar vacinar = new ServicoVacinarProxy();
        vacinar.vacinarPessoa(p1.getRg(), p1.getDataVacina(), p1.getNomeVacina());
        System.out.println(p1);
        System.out.printf("");
    }

    @Test
    public void vac2() {
        Vacinar vacinar = new ServicoVacinarProxy();
        vacinar.vacinarPessoa(p2.getRg(), p2.getDataVacina(), p2.getNomeVacina());
        System.out.println(p2);
    }

}
