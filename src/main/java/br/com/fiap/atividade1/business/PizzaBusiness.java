package br.com.fiap.atividade1.business;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.atividade1.dto.PizzaDTO;
import br.com.fiap.atividade1.model.Ingrediente;
import br.com.fiap.atividade1.model.Pizza;
import br.com.fiap.atividade1.repository.IngredienteRepository;
import br.com.fiap.atividade1.repository.PizzaRepository;

/**
 * The Class PizzaBusiness.
 */
@Service
public class PizzaBusiness {
	
	/** The pizza repository. */
	@Autowired
	private PizzaRepository pizzaRepository;
	
	/** The ingrediente repository. */
	@Autowired
	private IngredienteRepository ingredienteRepository;

	/**
	 * Gets the all.
	 *
	 * @return the all
	 */
	public List<PizzaDTO> getAll() {
		return this.pizzaRepository.findAllDTO();
	}

	/**
	 * Gets the pizza by Id.
	 *
	 * @param id the id
	 * @return the optional
	 */
	public PizzaDTO get(Long id) {
		return this.pizzaRepository.findByIdDTO(id);
	}

	/**
	 * Creates the.
	 *
	 * @param dto the dto
	 * @return the pizza
	 */
	public PizzaDTO create(PizzaDTO dto) {
		Pizza entity = new Pizza();
		
		this.mapDtoToEntity(dto, entity);
		
		Pizza pizza = this.pizzaRepository.save(entity);
		
		return new PizzaDTO(pizza);
	}

	/**
	 * Create batch list.
	 *
	 * @param dto the dto
	 * @return the list
	 */
	public List<PizzaDTO> createBatch(List<PizzaDTO> dto) {
		List<PizzaDTO> pizzas = new ArrayList<>();

		for(PizzaDTO p : dto) {
			PizzaDTO created = this.create(p);

			pizzas.add(created);
		}

		return pizzas;
	}

	/**
	 * Update.
	 *
	 * @param id  the id
	 * @param dto the dto
	 * @return the optional
	 */
	public PizzaDTO update(long id, PizzaDTO dto) {
		Pizza oldPizza = pizzaRepository.findById(id).orElse(null);
		
		if(oldPizza == null) return null;
        
        oldPizza.getIngredients().clear();
        
        mapDtoToEntity(dto, oldPizza);
        
        pizzaRepository.save(oldPizza);
        
        return new PizzaDTO(oldPizza);
	}

	/**
	 * Delete.
	 *
	 * @param id the id
	 * @return the response entity
	 */
	public ResponseEntity<Object> delete(long id) {
		Optional<Pizza> pizza = this.pizzaRepository.findById(id);
		
        if(pizza.isPresent()) {
            pizzaRepository.delete(pizza.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	

	/**
	 * Map dto to entity.
	 *
	 * @param dto the dto
	 */
	private void mapDtoToEntity(PizzaDTO dto, Pizza entity) {
		entity.setName(dto.getName());
		
		for(String ingredientName : dto.getIngredients()) {
			Ingrediente ingredient = ingredienteRepository.findByName(ingredientName);
            if (ingredient == null) {
            	ingredient = new Ingrediente(ingredientName);
            	ingredient.setPizzas(new ArrayList<>());
            }
            entity.getIngredients().add(ingredient);
		}
    }
}