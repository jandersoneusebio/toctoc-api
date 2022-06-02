package br.edu.fpb.gti.model.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import br.edu.fpb.gti.model.enums.TipoVisitanteEnum;

@Entity
@Table(name = "registros_entrada")
@NamedQueries({
	@NamedQuery(
		name = "RegistroEntrada.findRegistrosAbertos", 
		query = "SELECT r FROM RegistroEntrada r WHERE r.dataSaidaEfetiva IS NULL"
	),
	@NamedQuery(
		name = "RegistroEntrada.findAllRegistrosFechados", 
		query = "SELECT r FROM RegistroEntrada r WHERE r.dataSaidaEfetiva IS NOT NULL"
	),
	@NamedQuery(
		name = "RegistroEntrada.findRegistrosFechadosPorPeriodoDeEntrada", 
		query = "SELECT r FROM RegistroEntrada r WHERE r.dataSaidaEfetiva IS NOT NULL AND r.dataEntrada BETWEEN :inicio AND :fim"
	),
	@NamedQuery(
		name = "RegistroEntrada.findRegistrosFechadosPorPeriodoDeSaida", 
		query = "SELECT r FROM RegistroEntrada r WHERE r.dataSaidaEfetiva IS NOT NULL AND r.dataSaidaEfetiva BETWEEN :inicio AND :fim"
	)
	
})
public class RegistroEntrada implements Serializable {

	private static final long serialVersionUID = -1542516200656290582L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SQ_REG_ENTRADA")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "SQ_APT")
	private Apartamento apartamento;
	
	@Column(name = "NOME")
	private String nome;

	@Column(name = "CPF")
	private String cpfCnpj;

	@Column(name = "MOTIVO")
	@Enumerated(EnumType.ORDINAL)
	private TipoVisitanteEnum motivo;

	@Column(name = "MOTIVO_DESCRICAO")
	private String motivoDescricao;

	@Column(name = "DATA_ENTRADA")
	private Timestamp dataEntrada;

	@Column(name = "TEMPO_PERMANENCIA")
	private LocalTime tempoPermanencia;

	@Column(name = "DATA_SAIDA_ESTIMADA")
	private Timestamp dataSaidaEstimada;

	@Column(name = "DATA_SAIDA")
	private Timestamp dataSaidaEfetiva;
	
	@ManyToOne
	@JoinColumn(name = "SQ_FUNCIONARIO")
	private Funcionario operador;
	
	@Column(name = "TELEFONE")
	private String telefone;
	
	@Column(name = "EMPRESA")
	private String empresa;
	
	@Column(name = "PLACA")
	private String placa;
	
	@Column(name = "MODELO")
	private String modelo;
	
	@Column(name = "COR")
	private String cor;

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

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public TipoVisitanteEnum getMotivo() {
		return motivo;
	}

	public void setMotivo(TipoVisitanteEnum motivo) {
		this.motivo = motivo;
	}

	public String getMotivoDescricao() {
		return motivoDescricao;
	}

	public void setMotivoDescricao(String motivoDescricao) {
		this.motivoDescricao = motivoDescricao;
	}

	public Timestamp getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Timestamp dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public LocalTime getTempoPermanencia() {
		return tempoPermanencia;
	}

	public void setTempoPermanencia(LocalTime tempoPermanencia) {
		this.tempoPermanencia = tempoPermanencia;
	}

	public Timestamp getDataSaidaEstimada() {
		return dataSaidaEstimada;
	}

	public void setDataSaidaEstimada(Timestamp dataSaidaEstimada) {
		this.dataSaidaEstimada = dataSaidaEstimada;
	}

	public Timestamp getDataSaidaEfetiva() {
		return dataSaidaEfetiva;
	}

	public void setDataSaidaEfetiva(Timestamp dataSaidaEfetiva) {
		this.dataSaidaEfetiva = dataSaidaEfetiva;
	}

	public Apartamento getApartamento() {
		return apartamento;
	}

	public void setApartamento(Apartamento apartamento) {
		this.apartamento = apartamento;
	}

	public Funcionario getOperador() {
		return operador;
	}

	public void setOperador(Funcionario operador) {
		this.operador = operador;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}
	
	
	
}
