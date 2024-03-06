package api.rh.api.domain.reajusteSalarialNivelProfissional.regrasNegocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.rh.api.domain.departamento.usecase.crud.DepartamentoDaoJpa;
import api.rh.api.domain.funcionario.entity.Funcionario;
import api.rh.api.domain.funcionario.infra.persistencia.jpa.FuncionarioRepositoryJpa;
import api.rh.api.domain.reajusteSalarialNivelProfissional.entity.ReajusteSalarioCargo;
import api.rh.api.domain.reajusteSalarialNivelProfissional.infra.web.dto.post.DadosCadastroReajusteSalarioal;
import api.rh.api.domain.reajusteSalarialNivelProfissional.infra.web.dto.post.DadosDetalhamentoReajuste;
import api.rh.api.domain.reajusteSalarialNivelProfissional.regrasNegocio.ValidarNovoReajuste.ValidarNovoReajuste;
import api.rh.api.domain.reajusteSalarialNivelProfissional.usecase.crud.ReajusteDaoJpa;

@Service
public class ServiceReajuste {
	
	@Autowired
	private ReajusteDaoJpa reajusteDaoJpa;
	
	@Autowired
	private FuncionarioRepositoryJpa funcionarioDaoJpa;
		
	@Autowired
	private List<ValidarNovoReajuste> validadores;
	
	public DadosDetalhamentoReajuste criar(DadosCadastroReajusteSalarioal dto) {
		
		validadores.forEach(v -> v.validar(dto));
		ReajusteSalarioCargo reajuteSalarial = new ReajusteSalarioCargo(dto);
		reajusteDaoJpa.executeCreate(reajuteSalarial);
		
		Funcionario funcionario = funcionarioDaoJpa.findByIdAndAtivoTrue(dto.idFuncionario());
		reajusteDaoJpa.reajustarSalarioFuncionario(funcionario, dto.novoSalario());
		
		
		return new DadosDetalhamentoReajuste(reajuteSalarial);
	}
}