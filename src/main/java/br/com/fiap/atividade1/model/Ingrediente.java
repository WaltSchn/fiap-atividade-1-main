package br.com.fiap.atividade1.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_ingredient")
public class Ingrediente {
	
	/** The id. */
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
	
	/** The name. */
	@Column(name = "name", nullable = false, length = 100, unique = true)
	private String name;
	
	/** The pizzas. */
	@ManyToMany(mappedBy = "ingredients")
	private List<Pizza> pizzas;
	
	/**
	 * Instantiates a new ingrediente.
	 *
	 * @param name the name
	 */
	public Ingrediente(String name) {
		this.name = name;
	}
	
}
