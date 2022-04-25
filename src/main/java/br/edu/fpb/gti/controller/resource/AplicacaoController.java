package br.edu.fpb.gti.controller.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fpb.gti.controller.service.AplicacaoService;
import br.edu.fpb.gti.model.dto.VersaoDTO;

@RestController
@RequestMapping("aplicacao")
public class AplicacaoController {
	
	@Autowired
	private AplicacaoService service;
	
	@GetMapping("versao")
	public ResponseEntity<VersaoDTO> getVersao(){
		
		return new ResponseEntity<VersaoDTO>(service.getVersao(), HttpStatus.OK);
	}
	
}
