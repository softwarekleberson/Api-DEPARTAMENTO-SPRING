package api.rh.api.domain.projetos.usecase.crud;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import api.rh.api.domain.projetos.entity.Projeto;
import api.rh.api.domain.projetos.infra.persistencia.jpa.ProjetoRepositoryJpa;
import api.rh.api.domain.projetos.infra.web.dto.list.DadosListagemProjeto;
import api.rh.api.domain.projetos.infra.web.dto.put.DadosAtualizarProjeto;
import api.rh.api.domain.projetos.usecase.ProjetoRepository;
import jakarta.validation.Valid;

@Service
public class ProjetoDaoJpa implements ProjetoRepository{

	private ProjetoRepositoryJpa projetoRepository;
	
	public ProjetoDaoJpa(ProjetoRepositoryJpa projetoRepository) {
		this.projetoRepository = projetoRepository;
	}

	@Override
	public void executeCreate(Projeto projeto) {
		projetoRepository.save(projeto);
	}

	@Override
	public Projeto listAllDate(Long id) {
		return projetoRepository.getReferenceById(id);
	}

	@Override
	public Projeto updateData(@Valid DadosAtualizarProjeto dados) {
		Optional<Projeto> optDataBase = projetoRepository.findById(dados.id());
		
		if(optDataBase.isPresent()) {
			Projeto databaseProjeto = optDataBase.get();
			
			if(dados.custo() != null) {
				databaseProjeto.setCustoProjeto(dados.custo());
			}
			
			projetoRepository.save(databaseProjeto);
			return databaseProjeto;
		}
		return null;
	}

	@Override
	public void exclusionLogic(Long id) {
		var projeto = projetoRepository.getReferenceById(id);
		exclusion(projeto);
	}

	@Override
	public void exclusion(Projeto projeto) {
		projeto.setAtivo(false);
		
	}

	@Override
	public Page listAssets(Pageable paginacao) {
		return projetoRepository.findByAtivoTrue(paginacao)
			   .map(DadosListagemProjeto::new);
	}	
}
