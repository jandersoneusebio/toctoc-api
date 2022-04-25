package br.edu.fpb.gti.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.fpb.gti.model.entity.Apartamento;

public interface ApartamentoRepository extends JpaRepository<Apartamento, Long> {
	
	public Optional<Apartamento> findByNumero(Integer numero);

}
