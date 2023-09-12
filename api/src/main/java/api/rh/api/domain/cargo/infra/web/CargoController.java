package api.rh.api.domain.cargo.infra.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.rh.api.domain.cargo.entity.Cargo;
import api.rh.api.domain.cargo.infra.persistencia.jpa.CargoRepository;
import api.rh.api.domain.cargo.infra.web.dto.list.DadosListagemCargo;
import api.rh.api.domain.cargo.infra.web.dto.post.DadosCadastroCargo;
import api.rh.api.domain.cargo.infra.web.dto.put.DadosAtualizarCargo;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("cargo")
public class CargoController {
	
	@Autowired
	private CargoRepository repository;
	
	@Transactional
	@PostMapping
	public void cadastrar(@RequestBody @Valid DadosCadastroCargo dados) {
		repository.save(new Cargo(dados));
	}
	
	@GetMapping
	public Page<DadosListagemCargo> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
		return repository.findByAtivoTrue(paginacao).map(DadosListagemCargo::new);
	}
	
	@Transactional
	@PutMapping
	public void atualizar(@RequestBody @Valid DadosAtualizarCargo dados) {
		var cargo = repository.getReferenceById(dados.id());
		cargo.atualizarInformacoes(dados);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public void excluir(@PathVariable Long id) {
		var cargo = repository.getReferenceById(id);
		cargo.excluir();
	}
}
