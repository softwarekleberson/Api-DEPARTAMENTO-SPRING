package api.rh.api.domain.departamento.infra.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import api.rh.api.domain.departamento.entity.Departamento;
import api.rh.api.domain.departamento.infra.persistencia.jpa.DepartamentoRepoitory;
import api.rh.api.domain.departamento.infra.web.dto.list.DadosListagemDepartamento;
import api.rh.api.domain.departamento.infra.web.dto.post.DadosCadastroDepartamento;
import api.rh.api.domain.departamento.infra.web.dto.put.DadosAtualizarDepartamento;
import api.rh.api.domain.departamento.infra.web.dto.put.DadosDetalhamentoDepartamento;
import api.rh.api.domain.departamento.usecase.CrudDepartamento;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("departamento")
public class DepartamentoController {

	@Autowired
	private DepartamentoRepoitory repository;
	
	@Transactional
	@PostMapping
	public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroDepartamento dados, UriComponentsBuilder uriBuilder) {
		
		var departamento = new Departamento(dados);
		new CrudDepartamento(repository).criarDepartamento(departamento);		
		
		var uri = uriBuilder.path("/departamentos/{id}").buildAndExpand(departamento.getId()).toUri();
		return ResponseEntity.created(uri).body(new DadosDetalhamentoDepartamento(departamento));
	}
	
	@GetMapping
	public ResponseEntity<Page<DadosListagemDepartamento>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
		var page = new CrudDepartamento(repository).listarAtivo(paginacao);
		return ResponseEntity.ok(page);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity detalharDepartamento(@PathVariable Long id) {
		var departamenento = new CrudDepartamento(repository).listarAll(id);
		return ResponseEntity.ok(new DadosDetalhamentoDepartamento(departamenento));
	}
	
	@Transactional
	@PutMapping
	public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizarDepartamento dados) {
		
		var departamento = new CrudDepartamento(repository).atualizarDados(dados);
		if(departamento == null) {
        	throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		return ResponseEntity.ok(new DadosDetalhamentoDepartamento(departamento));
	}
	
	@Transactional
	@DeleteMapping("/{id}")
	public ResponseEntity excluir(@PathVariable Long id) {
		new CrudDepartamento(repository).exclusaoLogica(id);
		return ResponseEntity.noContent().build();
	}
}
