package br.com.fiap.atividade1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.atividade1.model.Ingrediente;

public interface IngredienteRepository extends JpaRepository<Ingrediente, Long> {

	Ingrediente findByName(String ingredientName);
	
}