package br.com.fiap.atividade1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fiap.atividade1.dto.PizzaDTO;
import br.com.fiap.atividade1.model.Pizza;

/**
 * The Interface PizzaRepository.
 */
public interface PizzaRepository extends JpaRepository<Pizza, Long> {
	
    /**
     * Find by id DTO.
     *
     * @param id the id
     * @return the pizza DTO
     */
    @Query(value = "SELECT new br.com.fiap.atividade1.dto.PizzaDTO(p) FROM Pizza p WHERE p.id = :id")
    PizzaDTO findByIdDTO(Long id);
    
    /**
     * Find all DTO.
     *
     * @return the list
     */
    @Query(value = "SELECT new br.com.fiap.atividade1.dto.PizzaDTO(p) FROM Pizza p")
    List<PizzaDTO> findAllDTO();
	
}