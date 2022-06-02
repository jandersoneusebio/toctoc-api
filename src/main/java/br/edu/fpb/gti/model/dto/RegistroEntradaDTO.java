package br.edu.fpb.gti.model.dto;

import java.sql.Timestamp;
import java.time.LocalTime;

public class RegistroEntradaDTO {
	
	private Integer numeroApartamento;
	
	private Long operador;
	
	private String nome;

	private String cpfCnpj;

	private Integer motivo;

	private String motivoDescricao;

	private Timestamp dataEntrada;

	private LocalTime tempoPermanencia;

	private Timestamp dataSaidaEstimada;

	private Timestamp dataSaidaEfetiva;
	
	private String telefone;
	
	private String placa;
	
	private String empresa;
	
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

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public Integer getMotivo() {
		return motivo;
	}

	public void setMotivo(Integer motivo) {
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	
	
}
