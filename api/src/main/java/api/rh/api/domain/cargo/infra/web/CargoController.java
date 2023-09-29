package api.rh.api.domain.cargo.infra.web;

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

import api.rh.api.domain.cargo.entity.Cargo;
import api.rh.api.domain.cargo.infra.persistencia.jpa.CargoRepository;
import api.rh.api.domain.cargo.infra.web.dto.list.DadosListagemCargo;
import api.rh.api.domain.cargo.infra.web.dto.post.DadosCadastroCargo;
import api.rh.api.domain.cargo.infra.web.dto.put.DadosAtualizarCargo;
import api.rh.api.domain.cargo.infra.web.dto.put.DadosDetalhamentoCargo;
import api.rh.api.domain.cargo.usecase.CrudCargo;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("cargo")
public class CargoController {
	
	@Autowired
	private CargoRepository repository;
	
	@Transactional
	@PostMapping
	public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroCargo dados, UriComponentsBuilder uriBuilder) {
		var cargo = new Cargo(dados);
		new CrudCargo(repository).executeCreate(cargo);
		
		var uri = uriBuilder.path("/cargos/{id}").buildAndExpand(cargo.getId()).toUri();
		return ResponseEntity.created(uri).body(new DadosDetalhamentoCargo(cargo));
	}
	
	@GetMapping
	public ResponseEntity<Page<DadosListagemCargo>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
		var page = new CrudCargo(repository).listarAtivos(paginacao);
		return ResponseEntity.ok(page);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity listarCargo(@PathVariable Long id) {
		var cargo = new CrudCargo(repository).listAll(id);
		return ResponseEntity.ok(new DadosDetalhamentoCargo(cargo));
	}
	
	@Transactional
	@PutMapping
	public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizarCargo dados) {
		var cargo = new CrudCargo(repository).atualizarDados(dados);
		if(cargo == null) {
        	throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		return ResponseEntity.ok(new DadosDetalhamentoCargo(cargo));
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity excluir(@PathVariable Long id) {
		new CrudCargo(repository).exclusaoLogica(id);		
		return ResponseEntity.noContent().build();
	}
}
