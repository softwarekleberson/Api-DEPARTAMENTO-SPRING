package api.rh.api.domain.projetos.infra.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import api.rh.api.domain.projetos.infra.persistencia.jpa.ProjetoRepositoryJpa;
import api.rh.api.domain.projetos.infra.web.dto.list.DadosListagemProjeto;
import api.rh.api.domain.projetos.infra.web.dto.post.DadosCadastroProjeto;
import api.rh.api.domain.projetos.infra.web.dto.put.DadosAtualizarProjeto;
import api.rh.api.domain.projetos.infra.web.dto.put.DadosDetalhamentoProjeto;
import api.rh.api.domain.projetos.regrasNegocio.ServiceProjeto;
import api.rh.api.domain.projetos.usecase.crud.ProjetoDaoJpa;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("projeto")
public class ProjetoController {

	@Autowired
	private ProjetoRepositoryJpa repository;
	
	@Autowired
	private ServiceProjeto service;
	
	@PostMapping
	@Transactional
	public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroProjeto dados, UriComponentsBuilder uriBuilder) {
	    var dto = service.criar(dados);	    
	    var uri = uriBuilder.path("/projetos/{id}").buildAndExpand(dto.id()).toUri();
	    return ResponseEntity.created(uri).body(dto);
	}

	
	@GetMapping
	public ResponseEntity<Page<DadosListagemProjeto>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
		var page = new ProjetoDaoJpa(repository).listAssets(paginacao);
		return ResponseEntity.ok(page);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity listarProjeto(@PathVariable Long id) {
		var projeto = new ProjetoDaoJpa(repository).listAllDate(id);
		return ResponseEntity.ok(new DadosDetalhamentoProjeto(projeto));
	}
	
	@Transactional
	@PutMapping
	public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizarProjeto dados) {
		var projeto = new ProjetoDaoJpa(repository).updateData(dados);
		if(projeto == null) {
        	throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		return ResponseEntity.ok(new DadosDetalhamentoProjeto(projeto));
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity excluir(@PathVariable Long id) {
		new ProjetoDaoJpa(repository).exclusionLogic(id);		
		return ResponseEntity.noContent().build();
	}
}
