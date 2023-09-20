package api.rh.api.domain.cargo.infra.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
import org.springframework.web.util.UriComponentsBuilder;

import api.rh.api.domain.cargo.entity.Cargo;
import api.rh.api.domain.cargo.infra.persistencia.jpa.CargoRepository;
import api.rh.api.domain.cargo.infra.web.dto.list.DadosListagemCargo;
import api.rh.api.domain.cargo.infra.web.dto.post.DadosCadastroCargo;
import api.rh.api.domain.cargo.infra.web.dto.put.DadosAtualizarCargo;
import api.rh.api.domain.cargo.infra.web.dto.put.DadosDetalhamentoCargo;
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
		repository.save(cargo);
		
		var uri = uriBuilder.path("/cargos/{id}").buildAndExpand(cargo.getId()).toUri();
		return ResponseEntity.created(uri).body(new DadosDetalhamentoCargo(cargo));
	}
	
	@GetMapping
	public ResponseEntity<Page<DadosListagemCargo>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
		var page = repository.findByAtivoTrue(paginacao).map(DadosListagemCargo::new);
		return ResponseEntity.ok(page);
	}
	
	@Transactional
	@PutMapping
	public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizarCargo dados) {
		var cargo = repository.getReferenceById(dados.id());
		cargo.atualizarInformacoes(dados);
		
		return ResponseEntity.ok(new DadosDetalhamentoCargo(cargo));
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity excluir(@PathVariable Long id) {
		var cargo = repository.getReferenceById(id);
		cargo.excluir();
		
		return ResponseEntity.noContent().build();
	}
}
