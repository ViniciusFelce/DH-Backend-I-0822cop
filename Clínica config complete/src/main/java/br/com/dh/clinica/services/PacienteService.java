package br.com.dh.clinica.services;

import br.com.dh.clinica.dtos.DentistaDto;
import br.com.dh.clinica.dtos.EnderecoDto;
import br.com.dh.clinica.dtos.PacienteDto;
import br.com.dh.clinica.entities.Dentista;
import br.com.dh.clinica.entities.Endereco;
import br.com.dh.clinica.entities.Paciente;
import br.com.dh.clinica.repositories.EnderecoRepository;
import br.com.dh.clinica.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository repository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Transactional(readOnly = true)
    public List<PacienteDto> buscarTodos() {
        List<Paciente> list = repository.findAll();
        return list.stream().map(x -> new PacienteDto(x)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PacienteDto buscarPorId(Integer id) {
        Optional<Paciente> objeto = repository.findById(id);
        Paciente entidade = objeto.get();
        return new PacienteDto(entidade);
    }

    public void excluir(Integer id) {
        repository.deleteById(id);
    }

    @Transactional
    public PacienteDto inserir(PacienteDto dto) {
        Paciente entidade = new Paciente();
        copiarDtoParaEntidade(dto, entidade);
        entidade = repository.save(entidade);
        return new PacienteDto(entidade);
    }

    @Transactional
    public PacienteDto atualizar(Integer id, PacienteDto dto) {
        Paciente entidade = repository.getReferenceById(id);
        copiarDtoParaEntidade(dto, entidade);
        entidade = repository.save(entidade);
        return new PacienteDto(entidade);
    }

    private void copiarDtoParaEntidade(PacienteDto dto, Paciente entidade) {
        entidade.setNome(dto.getNome());
        entidade.setEmail(dto.getEmail());
        entidade.setCpf(dto.getCpf());
        entidade.setDatacadastro(dto.getDatacadastro());

        entidade.getEnderecos().clear();
        for (EnderecoDto endDto : dto.getEnderecos()) {
            Endereco endereco = enderecoRepository.getReferenceById(endDto.getId());
            entidade.getEnderecos().add(endereco);
        }
    }
}
