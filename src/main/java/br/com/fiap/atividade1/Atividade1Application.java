package br.com.fiap.atividade1;

import br.com.fiap.atividade1.business.ClienteBusiness;
import br.com.fiap.atividade1.business.PizzaBusiness;
import br.com.fiap.atividade1.dto.ClienteDTO;
import br.com.fiap.atividade1.dto.PizzaDTO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@SpringBootApplication
public class Atividade1Application {

	public static void main(String[] args) {
		SpringApplication.run(Atividade1Application.class, args);
	}

	@Bean
	CommandLineRunner run(PizzaBusiness pizzaBusiness, ClienteBusiness clienteBusiness) {
		return args -> {
			List<PizzaDTO> pizzas = new ArrayList();

			pizzas.add(new PizzaDTO("Calabresa", 1L, new HashSet<>(Arrays.asList("Calabresa", "Cebola", "Azeitonas verdes")) ));
			pizzas.add(new PizzaDTO("Mussarela", 2L, new HashSet<>(Arrays.asList("Alho", "Queijo Mussarela"))));
			pizzas.add(new PizzaDTO("Marguerita", 3L, new HashSet<>(Arrays.asList("Mussarela", "Tomate", "Manjericão"))));
			pizzas.add(new PizzaDTO("Brasileira", 4L, new HashSet<>(Arrays.asList("Molho de tomate", "Requeijão", "Presunto", "Azeitonas pretas"))));
			pizzas.add(new PizzaDTO("Vegetariana", 5L, new HashSet<>(Arrays.asList("Champignon", "Pimentão verde", "Cebolinha"))));
			pizzas.add(new PizzaDTO("4 Queijos", 6L, new HashSet<>(Arrays.asList("Parmesão", "Provolone", "Cream Cheese", "Queijo Prato"))));

			pizzaBusiness.createBatch(pizzas);

			ClienteDTO cliente = new ClienteDTO(
					"cliente 1",
					"999999999",
					"email@email.com",
					"12345678910",
					"endereco generico",
					10,
					"bairro",
					"cidade",
					"complemento"
			);

			clienteBusiness.create(cliente);

		};
	}
}

