package br.com.dh.mongodb.services;

import br.com.dh.mongodb.entities.Dentista;
import br.com.dh.mongodb.repositories.DentistaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DentistaService {

    private DentistaRepository repository;

    public DentistaService(DentistaRepository repository) {
        this.repository = repository;
    }

    // Inserir dados
    public Dentista inserir(Dentista dentista) {
        return repository.save(dentista);
    }

    // Buscar todos os dados
    public List<Dentista> buscarTodos() {
        return repository.findAll();
    }
}
