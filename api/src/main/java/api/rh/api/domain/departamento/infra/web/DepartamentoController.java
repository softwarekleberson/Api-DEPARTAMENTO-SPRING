package api.rh.api.domain.departamento.infra.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.rh.api.domain.departamento.infra.web.dto.DadosCadastroDepartamento;

@RestController
@RequestMapping("departamento")
public class DepartamentoController {

	@PostMapping
	public void cadastrar(@RequestBody DadosCadastroDepartamento dados ) {
		System.out.println(dados);
	}
}
