package br.com.dh.clinica.services;

import br.com.dh.clinica.dtos.DentistaDto;
import br.com.dh.clinica.entities.Dentista;
import br.com.dh.clinica.repositories.DentistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DentistaService {

    @Autowired
    private DentistaRepository repository;

    @Transactional(readOnly = true)
    public List<DentistaDto> buscarTodos() {
        List<Dentista> list = repository.findAll();
        return list.stream().map(x -> new DentistaDto(x)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public DentistaDto buscarPorId(Integer id) {
        Optional<Dentista> objeto = repository.findById(id);
        Dentista entidade = objeto.get();
        return new DentistaDto(entidade);
    }

    public void excluir(Integer id) {
        repository.deleteById(id);
    }

    @Transactional
    public DentistaDto inserir(DentistaDto dto) {
        Dentista entidade = new Dentista();
        entidade.setNome(dto.getNome());                    // Paula
        entidade.setEmail(dto.getEmail());                  // paula@gmail.com
        entidade.setCro(dto.getCro());                      // 21456
        entidade.setAtendeconvenio(dto.isAtendeconvenio()); // TRUE
        entidade = repository.save(entidade);               // Retorna o objeto com ID
        return new DentistaDto(entidade);
    }

}
