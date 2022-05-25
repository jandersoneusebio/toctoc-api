package br.edu.fpb.gti.controller.resource;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fpb.gti.controller.service.UsuarioService;
import br.edu.fpb.gti.exception.BusinessException;
import br.edu.fpb.gti.model.dto.CadastroUsuarioDTO;
import br.edu.fpb.gti.model.dto.LoginDTO;
import br.edu.fpb.gti.model.dto.UsuarioDTO;
import br.edu.fpb.gti.util.ControllerUtil;

@RestController
@RequestMapping("interno/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	@PostMapping("cadastro")
	public ResponseEntity<?> cadastrar(@RequestBody CadastroUsuarioDTO cadastro){
		
		try {
			service.cadastrarUsuario(cadastro);
			
			return new ResponseEntity<>(HttpStatus.OK);
			
		} catch(BusinessException be) {
			
			return ControllerUtil.retornarErro(HttpStatus.BAD_REQUEST, be.getMessage());
			
		} catch(NoSuchAlgorithmException | UnsupportedEncodingException ne) {
			
			return ControllerUtil.retornarErro(HttpStatus.INTERNAL_SERVER_ERROR, ne.getMessage());
					
		}
		
	}
	
	@PostMapping("login")
	public ResponseEntity<?> login(@RequestBody LoginDTO login){
		
		try {
			UsuarioDTO usuario = service.login(login);
			
			return new ResponseEntity<UsuarioDTO>(usuario, HttpStatus.OK);
			
		} catch(BusinessException be) {
			
			return ControllerUtil.retornarErro(HttpStatus.BAD_REQUEST, be.getMessage());
			
		} catch(NoSuchAlgorithmException | UnsupportedEncodingException ne) {
			
			return ControllerUtil.retornarErro(HttpStatus.INTERNAL_SERVER_ERROR, ne.getMessage());
					
		}
		
	}
	
}
