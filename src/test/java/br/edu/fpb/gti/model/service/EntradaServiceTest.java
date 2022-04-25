package br.edu.fpb.gti.model.service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.time.LocalTime;
import java.util.Date;

import org.junit.jupiter.api.Test;

import br.edu.fpb.gti.controller.service.EntradaService;

class EntradaServiceTest {

	@Test
	void testCalcularDataSaidaEstimada() {
		Timestamp timestamp = new Timestamp(new Date().getTime());
		
		LocalTime tempoPermanencia = LocalTime.of(2, 0);
		
		
		Timestamp dataSaida = null;
		try {
			dataSaida = new EntradaService().calcularDataSaida(timestamp, tempoPermanencia);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(dataSaida);
	}

}
