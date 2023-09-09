package api.rh.api.domain.departamento.infra.web.dto.put;

public record DadosAtualizarDepartamento(
		
		Long id,
		String nome,
		String descricao,
		String ddd,
		String ddi,
		String telefone,
		String pais,
		String estado,
		String cidade,
		String rua,
		String numero,
		String cep
			
		) {

}
