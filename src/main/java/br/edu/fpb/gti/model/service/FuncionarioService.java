package br.edu.fpb.gti.model.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fpb.gti.model.entity.Funcionario;
import br.edu.fpb.gti.model.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
	
	@Autowired
	private FuncionarioRepository repository;
	
	public Funcionario buscarPorId(Long id) {
		
		Optional<Funcionario> funcionario = repository.findById(id);
		
		return funcionario.get();
		
	}
}
