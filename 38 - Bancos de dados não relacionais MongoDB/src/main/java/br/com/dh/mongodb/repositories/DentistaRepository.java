package br.com.dh.mongodb.repositories;

import br.com.dh.mongodb.entities.Dentista;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DentistaRepository extends MongoRepository<Dentista, Integer> {
}