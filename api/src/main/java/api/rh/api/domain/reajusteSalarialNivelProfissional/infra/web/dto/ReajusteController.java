package api.rh.api.domain.reajusteSalarialNivelProfissional.infra.web.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import api.rh.api.domain.reajusteSalarialNivelProfissional.infra.web.dto.post.DadosCadastroReajusteSalarioal;
import api.rh.api.domain.reajusteSalarialNivelProfissional.regrasNegocio.ServiceReajuste;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("reajuste")
public class ReajusteController {
	
	@Autowired
	private ServiceReajuste service;
	
	@PostMapping
	@Transactional
	public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroReajusteSalarioal dados, UriComponentsBuilder uriBuilder) {
		
		var dto = service.criar(dados);
		var uri = uriBuilder.path("/reajuste/{id}").buildAndExpand(dto.id()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
}
