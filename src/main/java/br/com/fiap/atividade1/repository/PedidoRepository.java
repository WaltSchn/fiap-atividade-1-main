package br.com.fiap.atividade1.repository;

import br.com.fiap.atividade1.model.Pedido;
import br.com.fiap.atividade1.model.PizzaMontada;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The Interface PizzaRepository.
 */
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
	
}