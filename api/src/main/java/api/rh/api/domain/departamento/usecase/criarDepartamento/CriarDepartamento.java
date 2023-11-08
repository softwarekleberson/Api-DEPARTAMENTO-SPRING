package api.rh.api.domain.departamento.usecase.criarDepartamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.rh.api.domain.departamento.infra.web.dto.post.DadosCadastroDepartamento;
import api.rh.api.domain.departamento.usecase.crud.DepartamentoDaoJpa;

@Service
public class CriarDepartamento {

	@Autowired
	private DepartamentoDaoJpa repositoy;
	
	public void criarCadastro(DadosCadastroDepartamento dados) {
		
		
	}
}
