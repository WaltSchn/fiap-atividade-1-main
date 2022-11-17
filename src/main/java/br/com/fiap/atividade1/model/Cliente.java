package br.com.fiap.atividade1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "name", nullable = false, length = 100)
	private String name;

	@Column(name = "celular", nullable = false, length = 9)
	private String celular;

	@Column(name = "email", nullable = false, length = 100)
	private String email;

	@Column(name = "cpf", nullable = false, length = 11)
	private String cpf;

	@Column(name = "rua", nullable = false, length = 100)
	private String rua;

	@Column(name = "numero", nullable = false)
	private Integer numero;

	@Column(name = "bairro", nullable = false, length = 40)
	private String bairro;

	@Column(name = "cidade", nullable = false, length = 35)
	private String cidade;

	@Column(name = "complemento", nullable = false, length = 100)
	private String complemento;

	@OneToMany(cascade = CascadeType.ALL,
			orphanRemoval = true)
	private List<Pedido> pedidos = new ArrayList<>();
}
