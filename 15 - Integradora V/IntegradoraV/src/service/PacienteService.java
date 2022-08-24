package service;

import dao.IDao;
import entities.Paciente;

import java.util.List;

public class PacienteService {

    private IDao<Paciente> pacienteIDao;

    public PacienteService(IDao<Paciente> pacienteIDao) {
        this.pacienteIDao = pacienteIDao;
    }

    public Paciente salvar(Paciente paciente) {
        pacienteIDao.salvar(paciente);
        return paciente;
    }

    public List<Paciente> buscarTodos(){
        return pacienteIDao.buscarTodos();
    }
}
