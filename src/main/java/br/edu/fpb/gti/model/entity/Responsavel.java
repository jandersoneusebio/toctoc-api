package br.edu.fpb.gti.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "responsaveis")
public class Responsavel implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 7328395819680332573L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SQ_RESPONSAVEL")
	private Long id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

}
