package api.rh.api.domain.cargo.usecaseCrud.crud;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import api.rh.api.domain.cargo.entity.Cargo;
import api.rh.api.domain.cargo.infra.persistencia.jpa.CargoRepositoryJpa;
import api.rh.api.domain.cargo.infra.web.dto.list.DadosListagemCargo;
import api.rh.api.domain.cargo.infra.web.dto.put.DadosAtualizarCargo;
import api.rh.api.domain.cargo.usecaseCrud.CargoRepository;
import jakarta.validation.Valid;

@Service
public class CargoDaoJpa implements CargoRepository{

	private CargoRepositoryJpa cargorepository;
	
	public CargoDaoJpa(CargoRepositoryJpa cargoRepository) {
		this.cargorepository = cargoRepository;
	}
	
	@Override
	public void executeCreate(Cargo cargo) {
		cargorepository.save(cargo);
	}

	@Override
	public Cargo listAllDate(Long id) {
		var cargo = cargorepository.getReferenceById(id);
		return cargo;
	}

	@Override
	public Cargo updateData(@Valid DadosAtualizarCargo dados) {
		Optional<Cargo> opDataBaseCargo = cargorepository.findById(dados.id());
		
		if(opDataBaseCargo.isPresent()) {
			Cargo databaseCargo = opDataBaseCargo.get();
			
			if(dados.nome() != null) {
				databaseCargo.setNome(dados.nome());
			}
			
			if(dados.descricao() != null) {
				databaseCargo.setDescricao(dados.descricao());
			}
			
			if(dados.salarioBase() != null) {
				databaseCargo.setSalario_Base(dados.salarioBase());
			}
			
			if(dados.salarioMaximo() != null) {
				databaseCargo.setSalario_Maximo(dados.salarioMaximo());
			}
			
			cargorepository.save(databaseCargo);
			return databaseCargo;
		}
		return null;
	}

	@Override
	public void exclusionLogic(Long id) {
		var cargo = cargorepository.getReferenceById(id);
		exclusion(cargo);
	}
	
	@Override
	public void exclusion(Cargo cargo) {
		cargo.setAtivo(false);
	}

	@Override
	public Page listAssets(Pageable paginacao) {
		return cargorepository.findByAtivoTrue(paginacao).map(DadosListagemCargo::new);
	}
	
	public boolean existsByNome(String nome) {
		return cargorepository.existsByNome(nome);
	}
	
}
