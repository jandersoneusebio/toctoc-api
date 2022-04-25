package br.edu.fpb.gti.controller.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.edu.fpb.gti.model.dto.VersaoDTO;

@Service
public class AplicacaoService {

	@Value("${application.version}")
	private String versao;
	
	@Value("${application.name}")
	private String nome;
	
	@Value("${application.desc}")
	private String descricao;
	
	public VersaoDTO getVersao() {
		return new VersaoDTO(versao, nome, descricao);
	}
	
}
