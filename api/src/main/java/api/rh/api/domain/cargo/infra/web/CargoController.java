package api.rh.api.domain.cargo.infra.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.rh.api.domain.cargo.entity.Cargo;
import api.rh.api.domain.cargo.infra.persistencia.jpa.CargoRepository;
import api.rh.api.domain.cargo.infra.web.dto.list.DadosListagemCargo;
import api.rh.api.domain.cargo.infra.web.dto.post.DadosCadastroCargo;
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
	public List<DadosListagemCargo> listar(){
		return repository.findAll().stream().map(DadosListagemCargo::new).toList();
	}
}
