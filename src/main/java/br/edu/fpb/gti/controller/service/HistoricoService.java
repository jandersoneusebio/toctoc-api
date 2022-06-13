package br.edu.fpb.gti.controller.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fpb.gti.model.dto.RespostaEntradaDTO;
import br.edu.fpb.gti.model.entity.RegistroEntrada;
import br.edu.fpb.gti.model.repository.EntradaRepository;

@Service
public class HistoricoService {
	
	@Autowired
	private EntradaRepository entradaRepository;
	
	public List<RespostaEntradaDTO> getAllRegistrosFechados(){
		List<RegistroEntrada> registros = entradaRepository.findAllRegistrosFechados();
		return montarRespostaEntradasAbertas(registros);
	}
	
	private List<RespostaEntradaDTO> montarRespostaEntradasAbertas(List<RegistroEntrada> entradas){
		
		List<RespostaEntradaDTO> resposta = entradas.stream()
				.map(registro -> new RespostaEntradaDTO(registro))
				.collect(Collectors.toList());
		
		return resposta;
		
	}
	
}
