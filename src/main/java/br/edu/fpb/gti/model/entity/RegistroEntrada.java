package br.edu.fpb.gti.model.entity;

import java.io.Serializable;
import java.sql.Blob;
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
	private String cpf;

	@Column(name = "MOTIVO")
	@Enumerated(EnumType.ORDINAL)
	private TipoVisitanteEnum tipoAutorizacao;

	@Column(name = "MOTIVO_DESCRICAO")
	private String observacao;

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
	private String placaVeiculo;
	
	@Column(name = "MODELO")
	private String modeloVeiculo;
	
	@Column(name = "COR")
	private String corVeiculo;
	
	@Column(name = "CARGO")
	private String cargo;
	
	@Column(name = "NOME_MORADOR")
	private String nomeMorador;
	
	@Column(name = "TELEFONE_MORADOR")
	private String telefoneMorador;
	
	@Column(name = "ENDERECO_DESTINO")
	private String enderecoDestino;
	
	@Column(name = "NUMERO_DESTINO")
	private Integer numeroDestino;
	
	@Column(name = "BLOCO_DESTINO")
	private String blocoDestino;
	
	@Column(name = "APARTAMENTO_DESTINO")
	private String apartamentoDestino;
	
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Integer getTipoAutorizacao() {
		return tipoAutorizacao.getCodigo();
	}

	public void setTipoAutorizacao(TipoVisitanteEnum tipoAutorizacao) {
		this.tipoAutorizacao = tipoAutorizacao;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
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

	public String getPlacaVeiculo() {
		return placaVeiculo;
	}

	public void setPlacaVeiculo(String placaVeiculo) {
		this.placaVeiculo = placaVeiculo;
	}

	public String getModeloVeiculo() {
		return modeloVeiculo;
	}

	public void setModeloVeiculo(String modeloVeiculo) {
		this.modeloVeiculo = modeloVeiculo;
	}

	public String getCorVeiculo() {
		return corVeiculo;
	}

	public void setCorVeiculo(String corVeiculo) {
		this.corVeiculo = corVeiculo;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getNomeMorador() {
		return nomeMorador;
	}

	public void setNomeMorador(String nomeMorador) {
		this.nomeMorador = nomeMorador;
	}

	public String getTelefoneMorador() {
		return telefoneMorador;
	}

	public void setTelefoneMorador(String telefoneMorador) {
		this.telefoneMorador = telefoneMorador;
	}

	public String getEnderecoDestino() {
		return enderecoDestino;
	}

	public void setEnderecoDestino(String enderecoDestino) {
		this.enderecoDestino = enderecoDestino;
	}

	public Integer getNumeroDestino() {
		return numeroDestino;
	}

	public void setNumeroDestino(Integer numeroDestino) {
		this.numeroDestino = numeroDestino;
	}

	public String getBlocoDestino() {
		return blocoDestino;
	}

	public void setBlocoDestino(String blocoDestino) {
		this.blocoDestino = blocoDestino;
	}

	public String getApartamentoDestino() {
		return apartamentoDestino;
	}

	public void setApartamentoDestino(String apartamentoDestino) {
		this.apartamentoDestino = apartamentoDestino;
	}
	
	
	
	
}
