package api.rh.api.domain.departamento.entity;

import java.time.LocalDate;

import api.rh.api.commun.domain.humanResource.contato.Email;
import api.rh.api.commun.domain.humanResource.contato.Telefone;
import api.rh.api.commun.domain.humanResource.endereco.Endereco;
import api.rh.api.domain.departamento.infra.web.dto.post.DadosCadastroDepartamento;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "departamentos")
@Entity(name = "Departamento")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Departamento {

	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private String nome;
    private String descricao;
    private LocalDate criacao;
    
    @Embedded
    private Telefone telefone;
    
    @Embedded
    private Email email;
    
    @Embedded
    private Endereco endereco;
    
    public Departamento(DadosCadastroDepartamento dados) {
    	this.nome = dados.departamento().nome();
    	this.descricao = dados.departamento().descricao();
    	this.criacao = dados.departamento().criacao();
    	this.telefone = new Telefone(dados.telefone());
    	this.email = new Email(dados.email());
    	this.endereco = new Endereco(dados.endereco());
    }
    
}
