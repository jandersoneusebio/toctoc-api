package br.edu.fpb.gti.controller.service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fpb.gti.exception.BusinessException;
import br.edu.fpb.gti.exception.ExceptionService;
import br.edu.fpb.gti.model.dto.RegistroEntradaDTO;
import br.edu.fpb.gti.model.entity.RegistroEntrada;
import br.edu.fpb.gti.model.repository.EntradaRepository;
import br.edu.fpb.gti.util.DataUtil;

@Service
public class EntradaService {
	
	@Autowired
	private EntradaRepository entradaDAO;
	
	public List<RegistroEntrada> listarEntradasAbertas(){
		List<RegistroEntrada> listaEntradasAbertas = entradaDAO.findRegistrosAbertos();
		
		return listaEntradasAbertas;
	}

	public RegistroEntrada registrarEntrada(RegistroEntradaDTO dto) {
		
		RegistroEntrada registro = montarRegistroEntrada(dto);
		
		return entradaDAO.save(registro);
		
	}
	
	public void fecharRegistroById(Long id) throws BusinessException {
		RegistroEntrada registro = entradaDAO.findById(id).get();
		
		if(Objects.isNull(registro)) {
			ExceptionService.lancarExcecao("Registro nao encontrado. ID: " + id);
		}
		
		registro.setDataSaidaEfetiva(DataUtil.retornarTimestampAtual());
		
		entradaDAO.save(registro);
	}
	
	private RegistroEntrada montarRegistroEntrada(RegistroEntradaDTO dto) {
		RegistroEntrada registro = new RegistroEntrada();
		
		try {
			registro.setCpfCnpj(dto.getCpfCnpj());
			registro.setNome(dto.getNome());
			registro.setMotivo(dto.getMotivo());
			registro.setMotivoDescricao(dto.getMotivoDescricao());
			registro.setDataEntrada(new Timestamp(new Date().getTime()));
			registro.setDataSaidaEstimada(calcularDataSaida(dto.getDataEntrada(), dto.getTempoPermanencia()));
			registro.setTempoPermanencia(dto.getTempoPermanencia());
		} catch(ParseException ex) {
			ex.printStackTrace();
		}
		
		return registro;
	}
	
	public Timestamp calcularDataSaida(Timestamp dataEntrada, LocalTime tempoPermanencia) throws ParseException {
		LocalDateTime dataSaidaEstimada = dataEntrada.toLocalDateTime();
		
		dataSaidaEstimada = dataSaidaEstimada.plusNanos(tempoPermanencia.toNanoOfDay());
		
		return new Timestamp(DataUtil.converterLocalDateTimeParaDate(dataSaidaEstimada).getTime());
		
	}
	
}
