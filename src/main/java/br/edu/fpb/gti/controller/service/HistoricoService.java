package br.edu.fpb.gti.controller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fpb.gti.model.entity.RegistroEntrada;
import br.edu.fpb.gti.model.repository.EntradaRepository;

@Service
public class HistoricoService {
	
	@Autowired
	private EntradaRepository entradaRepository;
	
	public List<RegistroEntrada> getAllRegistrosFechados(){
		return entradaRepository.findAllRegistrosFechados();
	}
	
}
