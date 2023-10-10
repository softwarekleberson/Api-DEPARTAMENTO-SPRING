package api.rh.api.commun.domain.humanResource.cpf.implementacao;

import api.rh.api.commun.domain.humanResource.cpf.CpfValidacao;
import br.com.caelum.stella.validation.CPFValidator;

public class CaelunCpfValidacao implements CpfValidacao{

	@Override
	public boolean isValid(String cpf) {
		CPFValidator cpfValidator = new CPFValidator();
		
		try {
			cpfValidator.assertValid(cpf);
			return true;
			
		} catch (Exception e) {
			return false;
		}
	}
}
