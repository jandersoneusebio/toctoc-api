package br.edu.fpb.gti.controller.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fpb.gti.controller.service.FuncionarioService;
import br.edu.fpb.gti.model.entity.Funcionario;

@RestController
@RequestMapping("admin/funcionario")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioService service;
	
	@GetMapping("buscar-por-id/{id}")
	@ResponseBody
	public ResponseEntity<Funcionario> getFuncionarioPorId(@PathVariable("id") Long id){
		System.out.println("opa");
		
		Funcionario func = service.buscarPorId(id);
		
		return new ResponseEntity<Funcionario>( func, HttpStatus.OK );
	}
	
}
