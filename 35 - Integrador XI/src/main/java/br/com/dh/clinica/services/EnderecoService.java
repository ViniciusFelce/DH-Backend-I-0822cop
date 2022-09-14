package br.com.dh.clinica.services;

import br.com.dh.clinica.dtos.DentistaDto;
import br.com.dh.clinica.dtos.EnderecoDto;
import br.com.dh.clinica.entities.Dentista;
import br.com.dh.clinica.entities.Endereco;
import br.com.dh.clinica.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository repository;

    // buscar todos
    @Transactional(readOnly = true)
    public List<EnderecoDto> buscarTodos() {
        List<Endereco> list = repository.findAll();
        return list.stream().map(x -> new EnderecoDto(x)).collect(Collectors.toList());
    }

    // buscar por ID
    @Transactional(readOnly = true)
    public EnderecoDto buscarPorId(Integer id) {
        Optional<Endereco> objeto = repository.findById(id);
        Endereco entidade = objeto.get();
        return new EnderecoDto(entidade);
    }

    // inserir
    @Transactional
    public EnderecoDto inserir(EnderecoDto dto) {
        Endereco entity = new Endereco();
        copiarDtoParaEntidade(dto, entity);
        entity = repository.save(entity);
        return new EnderecoDto(entity);
    }

    // atualizar
    @Transactional
    public EnderecoDto atualizar(Integer id, EnderecoDto dto) {
        Endereco entity = repository.getReferenceById(id);
        copiarDtoParaEntidade(dto, entity);
        entity = repository.save(entity);
        return new EnderecoDto(entity);
    }

    // deletar
    public void excluir(Integer id) {
        repository.deleteById(id);
    }

    private void copiarDtoParaEntidade(EnderecoDto dto, Endereco entidade) {
        entidade.setRua(dto.getRua());
        entidade.setNumero(dto.getNumero());
        entidade.setBairro(dto.getBairro());
        entidade.setCidade(dto.getCidade());
        entidade.setCep(dto.getCep());
        entidade.setEstado(dto.getEstado());
    }
}
