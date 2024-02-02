package api.rh.api.domain.funcionario.regrasNegocio.ValidarNovoFuncionario;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.stereotype.Service;

import api.rh.api.commun.domain.humanResource.ValidacaoException;
import api.rh.api.domain.funcionario.infra.web.dto.post.DadosCadastroFuncionarios;

@Service
public class ValidarIdadeMinimaFuncionario implements ValidarCriacaoFuncionario{

	public static final int IDADE_MINIMA = 15;
	
	@Override
	public void validar(DadosCadastroFuncionarios dados) {
				
		LocalDate nacimentoFuncionario = dados.funcionario().pessoa().nacimento();
		LocalDate anoAtual = LocalDate.now();
		
		Period idade = Period.between(nacimentoFuncionario, anoAtual);
		if(idade.getYears() < IDADE_MINIMA) {
			throw new ValidacaoException("Idade minima para o trabalho deve ser 15 anos");
		}
	}
}
