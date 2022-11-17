package br.com.fiap.atividade1.business;

import br.com.fiap.atividade1.dto.PizzaDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * The type Pizza business test.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class PizzaBusinessTest {
	
	@Autowired
	private PizzaBusiness pizzaBusiness;

	/**
	 * Get.
	 */
	@Test
	public void get() {
		PizzaDTO pizza = this.pizzaBusiness.get(3L);
		String[] ingredients = pizza.getIngredients().toArray(new String[pizza.getIngredients().size()]);

		assertEquals("Vegana", pizza.getName());
		assertEquals("Brócolis", ingredients[0]);
		assertEquals("Queijo Mussarela", ingredients[1]);
	}

	/**
	 * Gets all.
	 */
	@Test
	public void getAll() {
		List<PizzaDTO> pizzas = this.pizzaBusiness.getAll();

		assertEquals("Calabresa", pizzas.get(0).getName());
		assertEquals("Vegetariana", pizzas.get(1).getName());
	}

	/**
	 * Create.
	 */
	@Test
	public void create() {
		PizzaDTO pizza = new PizzaDTO("Vegetariana", new HashSet<>(Arrays.asList("Brócolis", "Queijo Mussarela")));
		this.pizzaBusiness.create(pizza);

		pizza = this.pizzaBusiness.get(3L);

		String[] ingredients = pizza.getIngredients().toArray(new String[pizza.getIngredients().size()]);

		assertEquals("Vegetariana", pizza.getName());
		assertEquals("Brócolis", ingredients[0]);
		assertEquals("Queijo Mussarela", ingredients[1]);
	}

	/**
	 * Update.
	 */
	@Test
	public void update() {
		PizzaDTO pizza = this.pizzaBusiness.get(3L);

		pizza.setName("Vegana");

		pizza = this.pizzaBusiness.update(3L, pizza);

		String[] ingredients = pizza.getIngredients().toArray(new String[pizza.getIngredients().size()]);

		assertEquals("Vegana", pizza.getName());
		assertEquals("Brócolis", ingredients[0]);
		assertEquals("Queijo Mussarela", ingredients[1]);
	}

	/**
	 * Delete.
	 */
	@Test
	public void delete() {
		this.pizzaBusiness.delete(1L);

		assertNull(this.pizzaBusiness.get(1L));
	}
}
