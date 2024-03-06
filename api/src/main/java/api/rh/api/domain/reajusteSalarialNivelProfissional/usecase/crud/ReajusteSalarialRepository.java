package api.rh.api.domain.reajusteSalarialNivelProfissional.usecase.crud;

import java.math.BigDecimal;

import api.rh.api.domain.funcionario.entity.Funcionario;
import api.rh.api.domain.reajusteSalarialNivelProfissional.entity.ReajusteSalarioCargo;

public interface ReajusteSalarialRepository {

	void executeCreate(ReajusteSalarioCargo reajuste);
	ReajusteSalarioCargo listAllDate(Long id);
	void reajustarSalarioFuncionario(Funcionario funcionario, BigDecimal novoSalario);
	
}
