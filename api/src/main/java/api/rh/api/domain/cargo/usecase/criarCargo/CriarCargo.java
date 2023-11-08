package api.rh.api.domain.cargo.usecase.criarCargo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.rh.api.commun.domain.humanResource.ValidacaoException;
import api.rh.api.domain.cargo.entity.Cargo;
import api.rh.api.domain.cargo.infra.web.dto.post.DadosCadastroCargo;
import api.rh.api.domain.cargo.usecase.crud.CargoDaoJpa;
import api.rh.api.domain.departamento.infra.persistencia.jpa.DepartamentoRepositoryJpa;

@Service
public class CriarCargo {
	
	@Autowired
	private CargoDaoJpa cargoDaoJpa;
	
	@Autowired
	private DepartamentoRepositoryJpa departamentoReposiytory;
	
	public void criarCadastro(DadosCadastroCargo dados) {
		
		if(!departamentoReposiytory.existsById(dados.idDepartamento())) {
			throw new ValidacaoException("Id do departamento incorreto");
		}
		
			
		var cargo = new Cargo();
		cargo.setId(null);
		cargo.setNome(dados.nome());
		cargo.setDescricao(dados.descricao());
		cargo.setSalario_Base(dados.salarioBase());
		cargo.setSalario_Maximo(dados.salarioMaximo());
		cargo.setNivel(dados.nivel());
		cargo.setDepartamento(dados.idDepartamento());
		
		cargoDaoJpa.executeCreate(cargo);
		
	}
}
