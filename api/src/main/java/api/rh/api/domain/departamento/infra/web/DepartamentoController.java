package api.rh.api.domain.departamento.infra.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.rh.api.domain.departamento.entity.Departamento;
import api.rh.api.domain.departamento.infra.persistencia.jpa.DepartamentoRepoitory;
import api.rh.api.domain.departamento.infra.web.dto.list.DadosListagemDepartamento;
import api.rh.api.domain.departamento.infra.web.dto.post.DadosCadastroDepartamento;
import jakarta.validation.Valid;

@RestController
@RequestMapping("departamento")
public class DepartamentoController {

	@Autowired
	private DepartamentoRepoitory repository;
	
	@PostMapping
	public void cadastrar(@RequestBody @Valid DadosCadastroDepartamento dados ) {
		repository.save(new Departamento(dados));
	}
	
	@GetMapping
	public List<DadosListagemDepartamento> listar(){
		return repository.findAll().stream().map(DadosListagemDepartamento::new).toList();
	}
}
