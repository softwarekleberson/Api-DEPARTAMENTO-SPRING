package api.rh.api.domain.reajusteSalarialNivelProfissional.regrasNegocio.ValidarNovoReajuste;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.rh.api.commun.domain.humanResource.ValidacaoException;
import api.rh.api.commun.domain.humanResource.cpf.Cpf;
import api.rh.api.domain.funcionario.entity.Funcionario;
import api.rh.api.domain.funcionario.infra.persistencia.jpa.FuncionarioRepositoryJpa;
import api.rh.api.domain.reajusteSalarialNivelProfissional.entity.ReajusteSalarioCargo;
import api.rh.api.domain.reajusteSalarialNivelProfissional.infra.persistencia.jpa.ReajusteRepositoryJpa;
import api.rh.api.domain.reajusteSalarialNivelProfissional.infra.web.dto.post.DadosCadastroReajusteSalarioal;

@Service
public class VerificaDiasPermitidosReajuste implements ValidarNovoReajuste{

	@Autowired
	private FuncionarioRepositoryJpa repositoryFuncionario;
	
	@Autowired
	private ReajusteRepositoryJpa repositoryReajuste;
	
	public static final int DIAS_PERMITIDOS_PARA_REAJUSTE = 1;
	
	@Override
	public void validar(DadosCadastroReajusteSalarioal dados) {
				
		String cpfFuncionario = dados.cpf().cpf();
		Cpf cpf = new Cpf(cpfFuncionario);
		Optional<Funcionario> cpfAtivo = repositoryFuncionario.findByCpfAndAtivoTrue(cpf);
		
		if(cpfAtivo.get().getAtivo()) {
			Optional<ReajusteSalarioCargo> reajuste = repositoryReajuste.findByCpfFuncionario(cpf);
			if(reajuste.isPresent()) {
				LocalDate ultimoReajuste = reajuste.get().getDiaReajuste();
				LocalDate dataAtual = LocalDate.now();
				Long diferencaDias = ChronoUnit.DAYS.between(ultimoReajuste, dataAtual);
				
				if(diferencaDias < DIAS_PERMITIDOS_PARA_REAJUSTE) {
					throw new ValidacaoException("Para que um reajuste seja aplicado, é necessário aguardar pelo menos " + DIAS_PERMITIDOS_PARA_REAJUSTE + " dias desde o último reajuste.");
				}
			}
		}
	}
}