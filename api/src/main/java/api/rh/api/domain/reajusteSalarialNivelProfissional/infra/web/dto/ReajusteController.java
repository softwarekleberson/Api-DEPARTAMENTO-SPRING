package api.rh.api.domain.reajusteSalarialNivelProfissional.infra.web.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import api.rh.api.domain.reajusteSalarialNivelProfissional.entity.ReajusteSalarioCargo;
import api.rh.api.domain.reajusteSalarialNivelProfissional.infra.web.dto.post.DadosCadastroReajusteSalarioal;
import api.rh.api.domain.reajusteSalarialNivelProfissional.regrasNegocio.ServiceReajuste;
import jakarta.validation.Valid;

@RestController
@RequestMapping("reajuste")
public class ReajusteController {

	@Autowired
	private ServiceReajuste service;
	
	public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroReajusteSalarioal dados, UriComponentsBuilder uriBuilder) {
		
		var dto = new ReajusteSalarioCargo(dados);
		var reajuste = service.criar(dto);
		return null;
	}
}
