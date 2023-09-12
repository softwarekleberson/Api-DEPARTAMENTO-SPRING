package api.rh.api.domain.funcionario.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import api.rh.api.domain.funcionario.infra.web.dto.post.DadosCadastroFuncionarios;
import api.rh.api.domain.funcionario.infra.web.dto.post.Profissao;
import api.rh.api.domain.funcionario.infra.web.dto.put.DadosAtualizarFuncionario;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "funcionarios")
@Entity(name = "Funcionario")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Funcionario {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate contratacao;
	private BigDecimal salario;
	
	@Embedded
	private Pessoa pessoa;
	
	@Enumerated(EnumType.STRING)
	private Profissao profissao;
	
	 public Funcionario(DadosCadastroFuncionarios dados) {
		 this.contratacao = dados.funcionario().contratacao();
		 this.salario = dados.funcionario().salario();
		 this.pessoa = new Pessoa(dados.funcionario().pessoa());
		 this.profissao = dados.profissao();
	 }

	public void atualizarInfomacoes(@Valid DadosAtualizarFuncionario dados) {
		if(dados.nome() != null) {
			this.getPessoa().atualizarInformacoesNome(dados.nome());
		}
		
		if(dados.telefone() != null) {
			this.getPessoa().getTelefone().atualizatTelefone(dados.telefone());
		}	
	}
}
