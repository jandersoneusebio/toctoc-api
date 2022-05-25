package br.edu.fpb.gti.model.dto;

import java.util.List;

public class UsuarioDTO {
	
	private String nome;
	
	private List<String> permissoes;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<String> getPermissoes() {
		return permissoes;
	}

	public void setPermissoes(List<String> permissoes) {
		this.permissoes = permissoes;
	}
	
	
}
