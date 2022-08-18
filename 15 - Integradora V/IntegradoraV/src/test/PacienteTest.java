package test;

import dao.config.ConfigJDBC;
import dao.impl.PacienteDaoH2;
import entities.Paciente;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;
import service.PacienteService;

import java.sql.Date;

public class PacienteTest {

    private PacienteService pacienteService = new PacienteService(
            new PacienteDaoH2(
                    new ConfigJDBC()));

    Paciente p1, p2, p3;
    Date dt = new Date(2022,8,18);

    @Test
    public void cadastrarPacientes() {

        p1 = pacienteService.salvar(new Paciente("Jonas", "Petros", "3265894410", dt, "Av. dos Estados, 255 - Centro - Porto Alegre/RS"));

        p2 = pacienteService.salvar(new Paciente("Jamile", "Albuquerque", "6522114457", dt, "Rua das Hortências, 547 - São José - Florianópolis/SC"));

        p3 = pacienteService.salvar(new Paciente("Paula", "Silveira", "7456689520", dt, "Rua Santos, 2554 - Cidade Baixa - Porto Alegre/RS"));

    }

    @Test
    public void buscarTodos() {
        System.out.println(pacienteService.buscarTodos());
    }

}
