package api.rh.api.domain.cargo.regraNegocio.validarNovoCargo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.rh.api.commun.domain.humanResource.ValidacaoException;
import api.rh.api.domain.cargo.infra.persistencia.jpa.CargoRepositoryJpa;
import api.rh.api.domain.cargo.infra.web.dto.post.DadosCadastroCargo;

@Service
public class ValidarCargoComNomeIgual implements ValidarCriacaoCargo{

	@Autowired
	private CargoRepositoryJpa repository;
	
	@Override
	public void validar(DadosCadastroCargo dados) {
		
		var nome = dados.nome().trim();
		boolean cargoCadastradoAnteriormente = repository.existsByNome(nome);
		if(cargoCadastradoAnteriormente) {
			throw new ValidacaoException("O cargo já foi cadastrado anteriormente. Por favor, forneça um nome de cargo único.");
		}
	}
}
