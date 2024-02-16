package api.rh.api.domain.projetos.entity.state;

import org.springframework.stereotype.Component;

import api.rh.api.commun.domain.humanResource.ValidacaoException;
import api.rh.api.domain.projetos.entity.Projeto;
import api.rh.api.domain.projetos.entity.StatusProjeto;

@Component
public class Aprovado extends State{

	@Override
	public void verificaEtapasProjeto(Projeto projeto) {
		
	}

	@Override
	public void finalizar(Projeto projeto) throws ValidacaoException {
		projeto.setState(new Finalizado());
		projeto.setStatusProjeto(StatusProjeto.FINALIZADO);
	}
}
