package api.rh.api.domain.projetos.entity.state;

import api.rh.api.commun.domain.humanResource.ValidacaoException;
import api.rh.api.domain.projetos.entity.Projeto;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class State {

	public abstract void verificaEtapasProjeto (Projeto projeto);
	
	public void aprovar (Projeto projeto) throws ValidacaoException {
		throw new ValidacaoException("Projeto não pode seguir");
	}
	
	public void reprovar (Projeto projeto) throws ValidacaoException {
		throw new ValidacaoException("Projeto não pode seguir");
	}
	
	public void finalizar (Projeto projeto) throws ValidacaoException {
		throw new ValidacaoException("Projeto não pode seguir");
	}
}
