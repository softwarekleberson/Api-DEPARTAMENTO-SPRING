package api.rh.api.domain.projetos.regrasNegocio;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import api.rh.api.commun.domain.humanResource.ValidacaoException;
import api.rh.api.domain.departamento.entity.Departamento;
import api.rh.api.domain.departamento.infra.persistencia.jpa.DepartamentoRepositoryJpa;
import api.rh.api.domain.departamento.usecase.crud.DepartamentoDaoJpa;
import api.rh.api.domain.projetos.entity.Projeto;
import api.rh.api.domain.projetos.infra.web.dto.post.DadosCadastroProjeto;
import api.rh.api.domain.projetos.infra.web.dto.put.DadosDetalhamentoProjeto;
import api.rh.api.domain.projetos.regrasNegocio.ValidarNovoProjeto.ValidarNovoProjeto;
import api.rh.api.domain.projetos.usecase.crud.ProjetoDaoJpa;

@Component
public class ServiceProjeto {

	@Autowired
	private DepartamentoRepositoryJpa repository;
	
	@Autowired 
	private DepartamentoDaoJpa departamentoDao;
	
	@Autowired
	private ProjetoDaoJpa projetoDao;
	
	@Autowired
	private List<ValidarNovoProjeto> validadores;
	
	public DadosDetalhamentoProjeto criar(DadosCadastroProjeto dados) {
		
		if(!repository.existsByAtivoTrueAndId(dados.idDepartamento())) {
			throw new ValidacaoException("Id invalido ou inexcinete");
		}
		
		validadores.forEach(v-> v.validar(dados));
		
		Projeto projeto = new Projeto(dados);
		Departamento departamento = repository.findByIdAndAtivoTrue
				(dados.idDepartamento());
		
		BigDecimal orcamentoTotal = departamento.getOrcamento().getOrcamento();
		BigDecimal custoProjeto = projeto.getCustoProjeto();
		BigDecimal orcamentoAtualizado = orcamentoTotal.subtract(custoProjeto);
		
		departamentoDao.subtrairCustosDoOrcamento(departamento, orcamentoAtualizado);
		
		projetoDao.executeCreate(projeto);
		return new DadosDetalhamentoProjeto(projeto);
	}
}
