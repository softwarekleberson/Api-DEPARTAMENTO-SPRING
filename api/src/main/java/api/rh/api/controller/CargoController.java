package api.rh.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.rh.api.cargo.DadosCadastroCargo;

@RestController
@RequestMapping("cargo")
public class CargoController {

	@PostMapping
	public void cadastrar(@RequestBody DadosCadastroCargo dados) {
		System.out.println(dados);
	}
}
