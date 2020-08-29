package br.com.ftec.exemploJPA.domain.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.ftec.exemploJPA.domain.model.Pessoa;

public interface PessoaRepository extends CrudRepository<Pessoa, Long> {

}
