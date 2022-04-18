package br.edu.fpb.gti.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name = "cargos")
public class Cargo implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = -8839233144366641151L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SQ_CARGO")
	private Long id;

	@Column(name = "NOME_CARGO")
	private String nome;

	// Por enquanto
	@Transient
	private String descFuncao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescFuncao() {
		return descFuncao;
	}

	public void setDescFuncao(String descFuncao) {
		this.descFuncao = descFuncao;
	}
	
	

}
