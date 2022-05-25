package br.edu.fpb.gti.exception;

import org.springframework.http.HttpStatus;

public class ErroJson {

	private Integer statusCode;
	
	private String mensagem;
	
	public ErroJson() {
		
	}
	
	public ErroJson(HttpStatus status, String mensagem) {
		this.statusCode = status.value();
		this.mensagem = mensagem;
	}
	
	public ErroJson(Integer status, String mensagem) {
		this.statusCode = status;
		this.mensagem = mensagem;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	
	
}
