package br.edu.fpb.gti.model.dto;

import java.io.Serializable;

public class VersaoDTO implements Serializable {

	private static final long serialVersionUID = -7165753136927954310L;

	private String versao;
	
	private String nome;
	
	private String descricao;
	
	

	public VersaoDTO(String versao, String nome, String descricao) {
		this.versao = versao;
		this.nome = nome;
		this.descricao = descricao;
	}

	public String getVersao() {
		return versao;
	}

	public void setVersao(String versao) {
		this.versao = versao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
}
