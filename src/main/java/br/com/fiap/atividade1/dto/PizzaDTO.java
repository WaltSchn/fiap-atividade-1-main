package br.com.fiap.atividade1.dto;

import java.util.HashSet;
import java.util.Set;

import br.com.fiap.atividade1.model.Ingrediente;
import br.com.fiap.atividade1.model.Pizza;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PizzaDTO {
	
	private String name;

	private Long id;
	
	private Set<String> ingredients;
	
	public PizzaDTO(Pizza pizza) {
		this.name = pizza.getName();
		
		Set<String> ingredientes = new HashSet<>();
		
		for(Ingrediente p : pizza.getIngredients()) {
			ingredientes.add(p.getName());
		}
		this.ingredients = ingredientes;

		this.id = pizza.getId();
	}

}
