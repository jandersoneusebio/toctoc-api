package br.edu.fpb.gti.model.dto;

import java.sql.Blob;
import java.sql.Timestamp;
import java.time.LocalTime;

public class RegistroEntradaDTO {
	
	private Integer numeroApartamento;
	
	private Long operador;
	
	private String nome;

	private String cpf;

	private Integer tipoAutorizacao;

	private String observacao;

	private Timestamp dataEntrada;

	private LocalTime tempoPermanencia;

	private Timestamp dataSaidaEstimada;

	private Timestamp dataSaidaEfetiva;
	
	private String telefone;
	
	private String placaVeiculo;
	
	private String modeloVeiculo;
	
	private String corVeiculo;
	
	private String empresa;
	
	private String cargo;
	
	private String telefoneMorador;
	
	private String nomeMorador;
	
	private String enderecoDestino;
	
	private Integer numeroDestino;
	
	private String blocoDestino;
	
	private String apartamentoDestino;
	
	private String imagemRosto;
	
	private String imagemDocumento;
	
	public Integer getNumeroApartamento() {
		return numeroApartamento;
	}

	public void setNumeroApartamento(Integer numeroApartamento) {
		this.numeroApartamento = numeroApartamento;
	}

	public Long getOperador() {
		return operador;
	}

	public void setOperador(Long operador) {
		this.operador = operador;
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
		return tipoAutorizacao;
	}

	public void setTipoAutorizacao(Integer tipoAutorizacao) {
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getPlacaVeiculo() {
		return placaVeiculo;
	}

	public void setPlacaVeiculo(String placaVeiculo) {
		this.placaVeiculo = placaVeiculo;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
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

	public String getTelefoneMorador() {
		return telefoneMorador;
	}

	public void setTelefoneMorador(String telefoneMorador) {
		this.telefoneMorador = telefoneMorador;
	}

	public String getNomeMorador() {
		return nomeMorador;
	}

	public void setNomeMorador(String nomeMorador) {
		this.nomeMorador = nomeMorador;
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

	public String getImagemRosto() {
		return imagemRosto;
	}

	public void setImagemRosto(String imagemRosto) {
		this.imagemRosto = imagemRosto;
	}

	public String getImagemDocumento() {
		return imagemDocumento;
	}

	public void setImagemDocumento(String imagemDocumento) {
		this.imagemDocumento = imagemDocumento;
	}

	public String getModeloVeiculo() {
		return modeloVeiculo;
	}

	public void setModeloVeiculo(String modeloVeiculo) {
		this.modeloVeiculo = modeloVeiculo;
	}
	
	

}
