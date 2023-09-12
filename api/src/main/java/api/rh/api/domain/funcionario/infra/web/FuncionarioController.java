package api.rh.api.domain.funcionario.infra.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.rh.api.domain.funcionario.entity.Funcionario;
import api.rh.api.domain.funcionario.infra.persistencia.jpa.FuncionarioRepository;
import api.rh.api.domain.funcionario.infra.web.dto.list.DadosListagemFuncionario;
import api.rh.api.domain.funcionario.infra.web.dto.post.DadosCadastroFuncionarios;
import api.rh.api.domain.funcionario.infra.web.dto.put.DadosAtualizarFuncionario;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;


@RestController
@RequestMapping("funcionario")
public class FuncionarioController {

	@Autowired
	private FuncionarioRepository repository;
	
	@PostMapping
	public void cadastra(@RequestBody @Valid DadosCadastroFuncionarios dados) {
		repository.save(new Funcionario(dados));
	}
	
	@GetMapping
	public Page<DadosListagemFuncionario> listar(@PageableDefault(size = 10, sort = {"salario"}) Pageable paginacao){
		return repository.findByAtivoTrue(paginacao).map(DadosListagemFuncionario::new);
	}
	
	@PutMapping
	@Transactional
	public void atualizarFuncionario(@RequestBody @Valid DadosAtualizarFuncionario dados) {
		var funcionario = repository.getReferenceById(dados.id());
		funcionario.atualizarInfomacoes(dados);
	}
	
	@Transactional
	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Long id) {
		var funcionarios = repository.getReferenceById(id);
		funcionarios.excluir();
	}
}
