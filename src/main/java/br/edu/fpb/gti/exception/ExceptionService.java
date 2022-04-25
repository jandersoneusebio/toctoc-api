package br.edu.fpb.gti.exception;

public class ExceptionService {
	
	public static void lancarExcecao() throws BusinessException {
		throw new BusinessException();
	}
	
	public static void lancarExcecao(String msg) throws BusinessException {
		throw new BusinessException(msg);
	}
	
	public static void lancarExcecao(String msg, Throwable ex) throws BusinessException {
		throw new BusinessException(msg, ex);
	}
}
