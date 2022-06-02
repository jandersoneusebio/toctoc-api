package br.edu.fpb.gti.model.repository;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.fpb.gti.model.entity.RegistroEntrada;

@Repository
public interface EntradaRepository extends JpaRepository<RegistroEntrada, Long> {

	//@Query("SELECT reg FROM RegistroEntrada WHERE reg.dataSaidaEfetiva IS NULL")
	public List<RegistroEntrada> findRegistrosAbertos();
	
	public List<RegistroEntrada> findAllRegistrosFechados();
	
	public List<RegistroEntrada> findRegistrosFechadosPorPeriodoDeEntrada();

	public List<RegistroEntrada> findRegistrosFechadosPorPeriodoDeSaida();

	//List<RegistroEntrada> findByDataSaidaEstimada(null);
	
	
	
}
