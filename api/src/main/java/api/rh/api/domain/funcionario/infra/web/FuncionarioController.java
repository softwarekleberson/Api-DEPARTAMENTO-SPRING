package api.rh.api.domain.funcionario.infra.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import api.rh.api.domain.cargo.usecase.CrudCargo;
import api.rh.api.domain.funcionario.entity.Funcionario;
import api.rh.api.domain.funcionario.infra.persistencia.jpa.FuncionarioRepository;
import api.rh.api.domain.funcionario.infra.web.dto.list.DadosListagemFuncionario;
import api.rh.api.domain.funcionario.infra.web.dto.post.DadosCadastroFuncionarios;
import api.rh.api.domain.funcionario.infra.web.dto.put.DadosAtualizarFuncionario;
import api.rh.api.domain.funcionario.infra.web.dto.put.DadosDetalhamentoFuncionario;
import api.rh.api.domain.funcionario.usecase.CrudFuncionario;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;


@RestController
@RequestMapping("funcionario")
public class FuncionarioController {

	@Autowired
	private FuncionarioRepository repository;
	
	@PostMapping
	public ResponseEntity cadastra(@RequestBody @Valid DadosCadastroFuncionarios dados, UriComponentsBuilder uriComponentsBuilder) {
		
		var funcionario = new Funcionario(dados);		
		new CrudFuncionario(repository).criarFuncionario(funcionario);
		
		var uri = uriComponentsBuilder.path("/funcionarios/{id}").buildAndExpand(funcionario.getId()).toUri();
		return ResponseEntity.created(uri).body(new DadosDetalhamentoFuncionario(funcionario));
	}
	
	@GetMapping
	public ResponseEntity<Page<DadosListagemFuncionario>> listar(@PageableDefault(size = 10, sort = {"salario"}) Pageable paginacao){
		var page = new CrudFuncionario(repository).listarAtivo(paginacao);
		return ResponseEntity.ok(page);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity detalharFuncionarios(@PathVariable Long id) {
		var funcionario = new CrudFuncionario(repository).detalharFuncionario(id);
		return ResponseEntity.ok(new DadosDetalhamentoFuncionario(funcionario));
	}
	
	@PutMapping
	@Transactional
	public ResponseEntity atualizarFuncionario(@RequestBody @Valid DadosAtualizarFuncionario dados) {
		
		var funcionario = new CrudFuncionario(repository).atualizarFuncionario(dados);
		if(funcionario == null) {
        	throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		return ResponseEntity.ok(new DadosDetalhamentoFuncionario(funcionario));
	}
	
	
	@Transactional
	@DeleteMapping("/{id}")
	public ResponseEntity excluir(@PathVariable Long id) {
		new CrudFuncionario(repository).exclusaoLogica(id);
		return ResponseEntity.noContent().build();
	}
}
