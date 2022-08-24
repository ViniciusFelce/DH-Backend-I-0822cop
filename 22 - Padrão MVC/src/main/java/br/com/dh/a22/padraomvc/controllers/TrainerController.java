package br.com.dh.a22.padraomvc.controllers;

import br.com.dh.a22.padraomvc.entities.Trainer;
import br.com.dh.a22.padraomvc.services.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/trainers") // Aqui é definida a rota para o navegador
public class TrainerController {

    @Autowired // Injeção de dependência
    private TrainerService service;

    public TrainerController(TrainerService service) {
        this.service = service;
    }

    @GetMapping
    public List<Trainer> buscarTodosOsTrainers() {
        return service.listTrainer();
    }

}
