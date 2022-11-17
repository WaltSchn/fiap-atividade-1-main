package br.com.fiap.atividade1.repository;

import br.com.fiap.atividade1.dto.PizzaDTO;
import br.com.fiap.atividade1.model.Pizza;
import br.com.fiap.atividade1.model.PizzaMontada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * The Interface PizzaRepository.
 */
public interface PizzaMontadaRepository extends JpaRepository<PizzaMontada, Long> {
	
}