package br.edu.fpb.gti.controller.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fpb.gti.controller.service.HistoricoService;
import br.edu.fpb.gti.model.entity.RegistroEntrada;

@RestController
@RequestMapping("historico")
public class HistoricoController {

	@Autowired
	private HistoricoService historicoService;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<RegistroEntrada>> getAllRegistrosFechados(){
		
		List<RegistroEntrada> registros = historicoService.getAllRegistrosFechados();
		
		return new ResponseEntity<List<RegistroEntrada>>(registros, HttpStatus.OK);
	}
	
}
