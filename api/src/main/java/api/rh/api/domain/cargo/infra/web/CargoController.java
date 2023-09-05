package api.rh.api.domain.cargo.infra.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.rh.api.domain.cargo.entity.Cargo;
import api.rh.api.domain.cargo.infra.persistencia.jpa.CargoRepository;
import api.rh.api.domain.cargo.infra.web.dto.DadosCadastroCargo;

@RestController
@RequestMapping("cargo")
public class CargoController {
	
	@Autowired
	private CargoRepository repository;
	
	@PostMapping
	public void cadastrar(@RequestBody DadosCadastroCargo dados) {
		repository.save(new Cargo(dados));
	}
}
