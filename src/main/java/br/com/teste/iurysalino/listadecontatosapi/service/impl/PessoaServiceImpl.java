package br.com.teste.iurysalino.listadecontatosapi.service.impl;

import br.com.teste.iurysalino.listadecontatosapi.model.Pessoa;
import br.com.teste.iurysalino.listadecontatosapi.repository.PessoaRepository;
import br.com.teste.iurysalino.listadecontatosapi.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaServiceImpl implements PessoaService {
    @Autowired
    PessoaRepository pessoaRepository;

    @Override
    public List<Pessoa> listarPessoas() {
        return pessoaRepository.findAll();
    }

    @Override
    public Optional<Pessoa> listaPessoaPorId(long id) {
        return pessoaRepository.findById(id);
    }

    @Override
    public Pessoa cadastrarPessoa(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    @Override
    public Pessoa alterarPessoa(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    @Override
    public void deletarPessoaPorId(long id) {
        pessoaRepository.deleteById(id);
    }
}
