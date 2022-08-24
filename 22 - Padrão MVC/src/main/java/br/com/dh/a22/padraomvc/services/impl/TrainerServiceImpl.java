package br.com.dh.a22.padraomvc.services.impl;

import br.com.dh.a22.padraomvc.entities.Trainer;
import br.com.dh.a22.padraomvc.services.TrainerService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class TrainerServiceImpl implements TrainerService {

    @Override
    public List<Trainer> listTrainer() {
        return Arrays.asList(
                new Trainer("Patrick"),
                new Trainer("Louis"),
                new Trainer("Ted")
                );
    }

}
