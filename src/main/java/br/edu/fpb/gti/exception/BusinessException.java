package br.edu.fpb.gti.exception;

public class BusinessException extends Exception {

	private static final long serialVersionUID = 8705518451096202052L;
	
	private String msg;

	public BusinessException() {
		super();
		this.msg = "Erro nao mapeado";
	}
	
	public BusinessException(String msg) {
		super(msg);
		this.msg = msg;
	}
	
	public BusinessException(String msg, Throwable ex) {
		super(msg, ex);
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	
}
