package api.rh.api.domain.funcionario.infra.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.rh.api.domain.funcionario.infra.web.dto.DadosCadastroFuncionarios;


@RestController
@RequestMapping("funcionario")
public class FuncionarioController {

	@PostMapping
	public void cadastra(@RequestBody DadosCadastroFuncionarios dados) {
		System.out.println(dados);
	}
}
