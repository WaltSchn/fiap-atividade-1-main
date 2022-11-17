package br.com.fiap.atividade1.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import br.com.fiap.atividade1.dto.PedidoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_pizza")
public class Pizza {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
	
	@Column(name = "name", nullable = false, length = 100)
	private String name;
	
	@ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST }, fetch = FetchType.EAGER)
	@JoinTable(
	  name = "tb_pizza_ingredients", 
	  joinColumns = @JoinColumn(name = "pizza_id"),
	  inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
	private List<Ingrediente> ingredients = new ArrayList<>();

	@ManyToMany(mappedBy = "pizzas")
	private List<Pedido> pedidos;
}
