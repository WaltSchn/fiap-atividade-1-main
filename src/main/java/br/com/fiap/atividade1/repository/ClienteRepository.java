package br.com.fiap.atividade1.repository;

import br.com.fiap.atividade1.dto.ClienteDTO;
import br.com.fiap.atividade1.dto.PizzaDTO;
import br.com.fiap.atividade1.model.Cliente;
import br.com.fiap.atividade1.model.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * The interface Cliente repository.
 */
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	/**
	 * Find by id DTO.
	 *
	 * @param id the id
	 * @return the cliente DTO
	 */
	@Query(value = "SELECT new br.com.fiap.atividade1.dto.ClienteDTO(p) FROM Cliente p WHERE p.id = :id")
	ClienteDTO findByIdDTO(Long id);

	/**
	 * Find all DTO.
	 *
	 * @return the list
	 */
	@Query(value = "SELECT new br.com.fiap.atividade1.dto.ClienteDTO(p) FROM Cliente p")
	List<ClienteDTO> findAllDTO();
}