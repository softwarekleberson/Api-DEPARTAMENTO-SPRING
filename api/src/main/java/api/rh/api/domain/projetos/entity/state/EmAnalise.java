package api.rh.api.domain.projetos.entity.state;

import org.springframework.stereotype.Component;

import api.rh.api.commun.domain.humanResource.ValidacaoException;
import api.rh.api.domain.projetos.entity.Projeto;
import api.rh.api.domain.projetos.entity.StatusProjeto;

@Component
public class EmAnalise extends State{

	@Override
	public void verificaEtapasProjeto(Projeto projeto) {
		
	}
	
	@Override
	public void aprovar(Projeto projeto) throws ValidacaoException {
		projeto.setState(new Aprovado());
		projeto.setStatusProjeto(StatusProjeto.APROVADO);
	}

	@Override
	public void reprovar(Projeto projeto) throws ValidacaoException {
		projeto.setState(new Reprovado());
		projeto.setStatusProjeto(StatusProjeto.REPROVADO);
	}
}
