package api.rh.api.domain.reajusteSalarialNivelProfissional.regrasNegocio.ValidarNovoReajuste;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.rh.api.commun.domain.humanResource.ValidacaoException;
import api.rh.api.domain.reajusteSalarialNivelProfissional.entity.ReajusteSalarioCargo;
import api.rh.api.domain.reajusteSalarialNivelProfissional.infra.persistencia.jpa.ReajusteRepositoryJpa;
import api.rh.api.domain.reajusteSalarialNivelProfissional.infra.web.dto.post.DadosCadastroReajusteSalarioal;

@Service
public class VerificaDiasPermitidosReajuste implements ValidarNovoReajuste{

	@Autowired
	private ReajusteRepositoryJpa repository;
	
	@Override
	public void validar(DadosCadastroReajusteSalarioal dados) {
				
		Optional<ReajusteSalarioCargo> reajuste = repository.findById(dados.idFuncionario());
		ReajusteSalarioCargo reajusteSalarial = reajuste.orElseThrow(() -> new NoSuchElementException("O objeto com o ID fornecido não foi encontrado."));
		LocalDate dataUltimoReajuste = reajusteSalarial.getDiaReajuste();
		
		int diasReajuste = 120;
		LocalDate dataAtual = LocalDate.now();
		Long diferencaDias = ChronoUnit.DAYS.between(dataUltimoReajuste, dataAtual);
		
		if(diferencaDias < diasReajuste) {
			throw new ValidacaoException("Para que haja um reajuste, é necessário"
										+ " que haja uma diferença de 360 dias em relação"
										+ " ao último reajuste.");
		}
	}
}