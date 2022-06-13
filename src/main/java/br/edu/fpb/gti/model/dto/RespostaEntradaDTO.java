package br.edu.fpb.gti.model.dto;

import java.sql.Blob;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Base64;
import java.util.Objects;

import br.edu.fpb.gti.model.entity.Funcionario;
import br.edu.fpb.gti.model.entity.RegistroEntrada;

public class RespostaEntradaDTO {
	
	private Long id;
	
	private String nome;
	
	private String telefone;
	
	private Timestamp dataEntrada;
	
	private Timestamp dataSaidaEstimada;
	
	private Timestamp dataSaidaEfetiva;
	
	private String operador;
	
	private Integer tipoAutorizacao;
	
	private String cpf;
	
	private String empresa;
	
	private String cargo;
	
	private String placaVeiculo;
	
	private String modeloVeiculo;
	
	private String corVeiculo;
	
	private String imagemDocumento;
	
	private String imagemRosto;
	
	private String nomeMorador;
	
	private String telefoneMorador;
	
	private String enderecoDestino;
	
	private Integer numeroDestino;
	
	private String blocoDestino;
	
	private String aptoDestino;
	
	private String observacao;
	
	public RespostaEntradaDTO(RegistroEntrada registro) {
		this.id = registro.getId();
		this.nome = registro.getNome();
		this.telefone = registro.getTelefone();
		this.dataEntrada = registro.getDataEntrada();
		this.dataSaidaEstimada = registro.getDataSaidaEstimada();
		this.operador = retornarOperador(registro.getOperador());
		this.tipoAutorizacao = registro.getTipoAutorizacao();
		this.cpf = registro.getCpf();
		this.empresa = registro.getEmpresa();
		this.cargo = registro.getCargo();
		this.placaVeiculo = registro.getPlacaVeiculo();
		this.corVeiculo = registro.getCorVeiculo();
		this.modeloVeiculo = registro.getModeloVeiculo();
		this.imagemDocumento = blobToBase64(registro.getImagemDocumento());
		this.imagemRosto = blobToBase64(registro.getImagemRosto());
		this.nomeMorador = registro.getNomeMorador();
		this.telefoneMorador = registro.getTelefoneMorador();
		this.enderecoDestino = registro.getEnderecoDestino();
		this.numeroDestino = registro.getNumeroDestino();
		this.blocoDestino = registro.getBlocoDestino();
		this.aptoDestino = registro.getApartamentoDestino();
		this.observacao = registro.getObservacao();
	}
	
	private String retornarOperador(Funcionario funcionario) {
		return Objects.nonNull(funcionario) ? funcionario.getNome() : null;
	}
	
	private String blobToBase64(Blob blob) {
		byte[] byteArray = null;
		
		String base64 = null;
		
		if(Objects.nonNull(blob)) {
			try {
				byteArray = blob.getBytes(1l, (int) blob.length());
				
				base64 = Base64.getEncoder().encodeToString(byteArray);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return base64;
	}

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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Timestamp getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Timestamp dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public Timestamp getDataSaidaEstimada() {
		return dataSaidaEstimada;
	}

	public void setDataSaidaEstimada(Timestamp dataSaidaEstimada) {
		this.dataSaidaEstimada = dataSaidaEstimada;
	}

	public String getOperador() {
		return operador;
	}

	public void setOperador(String operador) {
		this.operador = operador;
	}

	public Timestamp getDataSaidaEfetiva() {
		return dataSaidaEfetiva;
	}

	public void setDataSaidaEfetiva(Timestamp dataSaidaEfetiva) {
		this.dataSaidaEfetiva = dataSaidaEfetiva;
	}

	public Integer getTipoAutorizacao() {
		return tipoAutorizacao;
	}

	public void setTipoAutorizacao(Integer tipoAutorizacao) {
		this.tipoAutorizacao = tipoAutorizacao;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getPlacaVeiculo() {
		return placaVeiculo;
	}

	public void setPlacaVeiculo(String placaVeiculo) {
		this.placaVeiculo = placaVeiculo;
	}

	public String getImagemDocumento() {
		return imagemDocumento;
	}

	public void setImagemDocumento(String imagemDocumento) {
		this.imagemDocumento = imagemDocumento;
	}

	public String getImagemRosto() {
		return imagemRosto;
	}

	public void setImagemRosto(String imagemRosto) {
		this.imagemRosto = imagemRosto;
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

	public String getAptoDestino() {
		return aptoDestino;
	}

	public void setAptoDestino(String aptoDestino) {
		this.aptoDestino = aptoDestino;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
}
