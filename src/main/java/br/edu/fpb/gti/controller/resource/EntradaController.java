package br.edu.fpb.gti.controller.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fpb.gti.controller.service.EntradaService;
import br.edu.fpb.gti.exception.BusinessException;
import br.edu.fpb.gti.model.dto.RegistroEntradaDTO;
import br.edu.fpb.gti.model.dto.RespostaEntradaDTO;
import br.edu.fpb.gti.model.entity.RegistroEntrada;

@RestController
@RequestMapping("interno/entrada")
public class EntradaController {
	
	@Autowired
	private EntradaService entradaService;
	
	@GetMapping("listar-entradas-abertas")
	public ResponseEntity<List<RespostaEntradaDTO>> listarEntradasAbertas(){
		List<RespostaEntradaDTO> lista = entradaService.listarEntradasAbertas();
		
		return new ResponseEntity<List<RespostaEntradaDTO>>(lista, HttpStatus.OK);
	}

	@PostMapping("registrar")
	public ResponseEntity<RegistroEntrada> registrarEntrada(@RequestBody RegistroEntradaDTO registroDTO){
		RegistroEntrada registroEntrada = entradaService.registrarEntrada(registroDTO);
		
		return new ResponseEntity<RegistroEntrada>(registroEntrada, HttpStatus.CREATED);
	}
	
	@PutMapping("fechar-registro")
	public ResponseEntity<?> fecharRegistro(@RequestParam Long id){
		try {
			entradaService.fecharRegistroById(id);
		} catch(BusinessException be) {
			return new ResponseEntity<BusinessException>(be, HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}
	
}
