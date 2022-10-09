package br.com.teste.iurysalino.listadecontatosapi.controller;

import br.com.teste.iurysalino.listadecontatosapi.model.Pessoa;
import br.com.teste.iurysalino.listadecontatosapi.service.PessoaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class PessoaController {
    @Autowired
    PessoaService pessoaService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Pessoa> listarPessoas() {
        return pessoaService.listarPessoas();
    }

    @GetMapping("/pessoas")
    @ResponseStatus(HttpStatus.OK)
    public Pessoa buscarPessoaPorId(long id) {
        return pessoaService.listaPessoaPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa não encontrada"));
    }

    @PostMapping("/pessoas")
    @ResponseStatus(HttpStatus.CREATED)
    public Pessoa salvarPessoa(@RequestBody Pessoa pessoa) {
        return pessoaService.cadastrarPessoa(pessoa);
    }

    @PutMapping("/pessoas/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void alterarPessoa(@PathVariable("id") Long id, @RequestBody Pessoa pessoa) {
        pessoaService.listaPessoaPorId(id)
                .map(pessoaBase -> {
                    modelMapper.map(pessoa, pessoaBase);
                    pessoaService.cadastrarPessoa(pessoaBase);
                    return Void.TYPE;
                }).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }

    @DeleteMapping("/pessoas/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletarPessoaPorId(@PathVariable("id") Long id) {
        pessoaService.listaPessoaPorId(id)
                .map(pessoa -> {
                    pessoaService.deletarPessoaPorId(id);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }
}
