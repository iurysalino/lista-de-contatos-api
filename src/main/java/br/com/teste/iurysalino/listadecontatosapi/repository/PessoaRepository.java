package br.com.teste.iurysalino.listadecontatosapi.repository;

import br.com.teste.iurysalino.listadecontatosapi.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
