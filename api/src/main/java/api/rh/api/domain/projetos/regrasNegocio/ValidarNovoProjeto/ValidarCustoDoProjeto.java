package api.rh.api.domain.projetos.regrasNegocio.ValidarNovoProjeto;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.rh.api.commun.domain.humanResource.ValidacaoException;
import api.rh.api.domain.departamento.entity.Departamento;
import api.rh.api.domain.departamento.infra.persistencia.jpa.DepartamentoRepositoryJpa;
import api.rh.api.domain.projetos.infra.web.dto.post.DadosCadastroProjeto;

@Service
public class ValidarCustoDoProjeto implements ValidarNovoProjeto{

	@Autowired
	private DepartamentoRepositoryJpa repository;
	
	@Override
	public void validar(DadosCadastroProjeto dados) {
		
		Long idDepartamento = dados.idDepartamento();
		BigDecimal valorProjeto = dados.custo();
		
		Departamento departamento = repository.findByIdAndAtivoTrue(idDepartamento);
		BigDecimal orcamentoAtual = departamento.getOrcamento().getOrcamento();
		
		if(valorProjeto.compareTo(orcamentoAtual) > 0) {
			throw new ValidacaoException("Custo do projeto superior ao permitido");
		}
	}
}
