package api.rh.api.domain.departamento.regraNegocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.rh.api.domain.departamento.entity.Departamento;
import api.rh.api.domain.departamento.infra.web.dto.post.DadosCadastroDepartamento;
import api.rh.api.domain.departamento.infra.web.dto.put.DadosDetalhamentoDepartamento;
import api.rh.api.domain.departamento.regraNegocio.validarNovoDepartamento.ValidarCriacaoDepartamento;
import api.rh.api.domain.departamento.usecaseCrud.crud.DepartamentoDaoJpa;

@Service
public class ServiceDepartamento {

	@Autowired
	private DepartamentoDaoJpa departamentoDao;
	
	@Autowired
	private List<ValidarCriacaoDepartamento> validadores;
	
	public DadosDetalhamentoDepartamento criar(DadosCadastroDepartamento dadosDepartamento) {
		
		validadores.forEach(v-> v.validar(dadosDepartamento));
		
		Departamento departamento = new Departamento(dadosDepartamento);
		departamentoDao.executeCreate(departamento);
		
		return new DadosDetalhamentoDepartamento(departamento);
	}
}
