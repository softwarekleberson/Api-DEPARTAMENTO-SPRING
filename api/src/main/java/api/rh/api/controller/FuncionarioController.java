package api.rh.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.rh.api.funcionario.DadosCadastroFuncionario;

@RestController
@RequestMapping("funcionario")
public class FuncionarioController {

	@PostMapping
	public void cadastra(@RequestBody DadosCadastroFuncionario dados) {
		System.out.println(dados);
	}
}
