package br.com.dh.mongodb.controller;

import br.com.dh.mongodb.entities.Dentista;
import br.com.dh.mongodb.services.DentistaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/dentistas")
public class DentistaController {

    private DentistaService service;

    public DentistaController(DentistaService service) {
        this.service = service;
    }

    @PostMapping
    public Dentista inserirDentista(Dentista json) {
        Dentista colecao = service.inserir(json);
        return colecao;
    }

    @GetMapping
    public List<Dentista> buscarTodosOsDentistas() {
        List<Dentista> lista = service.buscarTodos();
        return lista;
    }
}
