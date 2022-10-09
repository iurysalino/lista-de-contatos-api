package br.com.teste.iurysalino.listadecontatosapi.service;

import br.com.teste.iurysalino.listadecontatosapi.model.Pessoa;

import java.util.List;
import java.util.Optional;

public interface PessoaService {
    List<Pessoa> listarPessoas();
    Optional<Pessoa> listaPessoaPorId(long id);
    Pessoa cadastrarPessoa(Pessoa pessoa);
    Pessoa alterarPessoa(Pessoa pessoa);
    void deletarPessoaPorId(long id);
}
