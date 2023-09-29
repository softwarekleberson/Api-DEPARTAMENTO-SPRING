package api.rh.api.domain.cargo.usecase;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import api.rh.api.domain.cargo.entity.Cargo;
import api.rh.api.domain.cargo.infra.persistencia.jpa.CargoRepository;
import api.rh.api.domain.cargo.infra.web.dto.list.DadosListagemCargo;
import api.rh.api.domain.cargo.infra.web.dto.put.DadosAtualizarCargo;
import jakarta.validation.Valid;

public class CrudCargo {

	private CargoRepository cargorepositoty;
	
	public CrudCargo(CargoRepository cargoRepository) {
		this.cargorepositoty = cargoRepository;
	}
	
	public void executeCreate(Cargo cargo) {
		cargorepositoty.save(cargo);
	}

	public Cargo listAll(Long id) {
		var cargo = cargorepositoty.getReferenceById(id);
		return cargo;
	}

	public Cargo atualizarDados(@Valid DadosAtualizarCargo dados) {
		Optional<Cargo> opDataBaseCargo = cargorepositoty.findById(dados.id());
		
		if(opDataBaseCargo.isPresent()) {
			Cargo databaseCargo = opDataBaseCargo.get();
			databaseCargo.setNome(dados.nome());
			databaseCargo.setDescricao(dados.descricao());
			databaseCargo.setSalario_Base(dados.salarioBase());
			databaseCargo.setSalario_Maximo(dados.salarioMaximo());
			return databaseCargo;
		}
		return null;
	}

	public void exclusaoLogica(Long id) {
		var cargo = cargorepositoty.getReferenceById(id);
		excluir(cargo);
	}
	
	private void excluir(Cargo cargo) {
		cargo.setAtivo(false);
	}

	public Page listarAtivos(Pageable paginacao) {
		return cargorepositoty.findByAtivoTrue(paginacao).map(DadosListagemCargo::new);
	}
}