package br.edu.fpb.gti.controller.service;

import java.sql.Blob;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;
import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.Service;

import br.edu.fpb.gti.exception.BusinessException;
import br.edu.fpb.gti.exception.ExceptionService;
import br.edu.fpb.gti.model.dto.RegistroEntradaDTO;
import br.edu.fpb.gti.model.dto.RespostaEntradaDTO;
import br.edu.fpb.gti.model.entity.Apartamento;
import br.edu.fpb.gti.model.entity.Funcionario;
import br.edu.fpb.gti.model.entity.RegistroEntrada;
import br.edu.fpb.gti.model.enums.TipoVisitanteEnum;
import br.edu.fpb.gti.model.repository.ApartamentoRepository;
import br.edu.fpb.gti.model.repository.EntradaRepository;
import br.edu.fpb.gti.model.repository.FuncionarioRepository;
import br.edu.fpb.gti.util.DataUtil;

@Service
public class EntradaService {
	
	@Autowired
	private EntradaRepository entradaRepository;
	
	@Autowired
	private ApartamentoRepository apartamentoRepository;
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	public List<RespostaEntradaDTO> listarEntradasAbertas(){
		List<RegistroEntrada> listaEntradasAbertas = entradaRepository.findRegistrosAbertos();
		
		return montarRespostaEntradasAbertas(listaEntradasAbertas);
	}
	
	private List<RespostaEntradaDTO> montarRespostaEntradasAbertas(List<RegistroEntrada> entradas){
		
		List<RespostaEntradaDTO> resposta = entradas.stream()
				.map(registro -> new RespostaEntradaDTO(registro))
				.collect(Collectors.toList());
		
		return resposta;
		
	}

	public RegistroEntrada registrarEntrada(RegistroEntradaDTO dto) {
		
		RegistroEntrada registro = montarRegistroEntrada(dto);
		
		return entradaRepository.save(registro);
		
	}
	
	public void fecharRegistroById(Long id) throws BusinessException {
		RegistroEntrada registro = entradaRepository.findById(id).get();
		
		if(Objects.isNull(registro)) {
			ExceptionService.lancarExcecao("Registro nao encontrado. ID: " + id);
		}
		
		registro.setDataSaidaEfetiva(DataUtil.retornarTimestampAtual());
		
		entradaRepository.save(registro);
	}
	
	private RegistroEntrada montarRegistroEntrada(RegistroEntradaDTO dto) {
		RegistroEntrada registro = new RegistroEntrada();
		
		try {
			registro.setCpf(dto.getCpf());
			registro.setNome(dto.getNome());
			registro.setTipoAutorizacao(TipoVisitanteEnum.getByCodigo(dto.getTipoAutorizacao()));
			registro.setObservacao(dto.getObservacao());
			registro.setDataEntrada(dto.getDataEntrada());
			registro.setDataSaidaEstimada(dto.getDataSaidaEstimada());
			registro.setTempoPermanencia(dto.getTempoPermanencia());
			//registro.setApartamento(buscarApartamento(dto.getNumeroApartamento()));
			registro.setOperador(buscarOperador(dto.getOperador()));
			registro.setTelefone(dto.getTelefone());
			registro.setEmpresa(dto.getEmpresa());
			registro.setPlacaVeiculo(dto.getPlacaVeiculo());
			registro.setCorVeiculo(dto.getCorVeiculo());
			registro.setModeloVeiculo(dto.getModeloVeiculo());
			registro.setNomeMorador(dto.getNomeMorador());
			registro.setTelefoneMorador(dto.getTelefoneMorador());
			registro.setEnderecoDestino(dto.getEnderecoDestino());
			registro.setNumeroDestino(dto.getNumeroDestino());
			registro.setCargo(dto.getCargo());
			registro.setBlocoDestino(dto.getBlocoDestino());
			registro.setApartamentoDestino(dto.getApartamentoDestino());
			registro.setImagemDocumento(converterBase64ToBlob(dto.getImagemDocumento()));
			registro.setImagemRosto(converterBase64ToBlob(dto.getImagemRosto()));
		} catch(RuntimeException | SQLException ex) {
			ex.printStackTrace();
		}
		
		return registro;
	}
	
	private Blob converterBase64ToBlob(String imagemStr) throws SerialException, SQLException {
		
		String base64 = imagemStr.contains(",") ? imagemStr.split(",")[1] : imagemStr;
		
		byte[] byteArray = java.util.Base64.getDecoder().decode(base64);
		
		return new SerialBlob(byteArray);
	}
	
	private Apartamento buscarApartamento(Integer id) {
		return apartamentoRepository.findByNumero(id).orElse(null);
	}
	
	private Funcionario buscarOperador(Long id) {
		return funcionarioRepository.findById(id).orElse(null);
	}
	
	public Timestamp calcularDataSaida(Timestamp dataEntrada, LocalTime tempoPermanencia) throws ParseException {
		LocalDateTime dataSaidaEstimada = dataEntrada.toLocalDateTime();
		
		
		
		dataSaidaEstimada = dataSaidaEstimada.plusNanos(tempoPermanencia.toNanoOfDay());
		
		return new Timestamp(DataUtil.converterLocalDateTimeParaDate(dataSaidaEstimada).getTime());
		
	}
	
}
