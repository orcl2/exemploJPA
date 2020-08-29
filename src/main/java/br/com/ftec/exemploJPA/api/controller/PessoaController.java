package br.com.ftec.exemploJPA.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.ftec.exemploJPA.domain.model.Pessoa;
import br.com.ftec.exemploJPA.domain.repository.PessoaRepository;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

	@Autowired
	PessoaRepository pessoaRepository;

	@GetMapping("/buscar")
	public Iterable<Pessoa> buscar() {
		return pessoaRepository.findAll();
	}
	
	@GetMapping(params = "id", path = "/buscar/")
	public ResponseEntity<Optional<Pessoa>> buscaPessoa(@RequestParam Long id){
		Optional<Pessoa> pessoa = pessoaRepository.findById(id);
		
		if(pessoa.isPresent()) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(pessoa);
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@PostMapping("/adicionar")
	public ResponseEntity<Pessoa> adicionar(@RequestBody Pessoa pessoa) {
		pessoa = pessoaRepository.save(pessoa);

		return ResponseEntity.status(HttpStatus.CREATED).body(pessoa);
	}

	@PutMapping("/atualizar")
	public ResponseEntity<Pessoa> atualizar(@RequestBody Pessoa novaPessoa) {

		if (pessoaRepository.existsById(novaPessoa.getId())) {
			pessoaRepository.save(novaPessoa);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(novaPessoa);
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<Void> deletar(@RequestParam Long id) {
		
		if(pessoaRepository.existsById(id)) {
			pessoaRepository.deleteById(id);
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.notFound().build();
	}
}
