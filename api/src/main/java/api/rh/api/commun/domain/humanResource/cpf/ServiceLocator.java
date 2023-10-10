package api.rh.api.commun.domain.humanResource.cpf;

import api.rh.api.commun.domain.humanResource.cpf.implementacao.CaelunCpfValidacao;

public class ServiceLocator {

	public static CpfValidacao getCpfValidator() {
		return new CaelunCpfValidacao();
	}
}
