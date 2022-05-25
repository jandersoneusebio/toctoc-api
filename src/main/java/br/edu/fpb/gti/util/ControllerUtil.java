package br.edu.fpb.gti.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.edu.fpb.gti.exception.ErroJson;

public class ControllerUtil {
	
	public static ResponseEntity<?> retornarErro(Integer status, String mensagem){
		ErroJson erro = new ErroJson(status, mensagem);
		
		return new ResponseEntity<ErroJson>(erro, HttpStatus.resolve(status));
	}

	public static ResponseEntity<?> retornarErro(HttpStatus status, String mensagem){
		ErroJson erro = new ErroJson(status, mensagem);
		
		return new ResponseEntity<ErroJson>(erro, status);
	}
	
}
