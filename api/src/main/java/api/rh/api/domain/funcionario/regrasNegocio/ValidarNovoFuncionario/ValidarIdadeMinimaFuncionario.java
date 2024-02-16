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
				
		LocalDate nacimentoFuncionario = dados.funcionario().pessoa().nascimento();
		LocalDate anoAtual = LocalDate.now();
		
		Period idade = Period.between(nacimentoFuncionario, anoAtual);
		if(idade.getYears() < IDADE_MINIMA) {
			throw new ValidacaoException("A idade mínima para trabalhar é de 15 anos. Por favor, verifique a data de nascimento e insira uma idade válida.");
		}
	}
}
