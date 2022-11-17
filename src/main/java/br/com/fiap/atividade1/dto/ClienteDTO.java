package br.com.fiap.atividade1.dto;

import br.com.fiap.atividade1.model.Cliente;
import br.com.fiap.atividade1.model.Ingrediente;
import br.com.fiap.atividade1.model.Pizza;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.HashSet;
import java.util.Set;

/**
 * The type Cliente dto.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {

	private String name;

	private String celular;

	private String email;

	private String cpf;

	private String rua;

	private Integer numero;

	private String bairro;

	private String cidade;

	private String complemento;

	public ClienteDTO(Cliente cliente) {
		this.name = cliente.getName();
		this.celular = cliente.getCelular();
		this.email = cliente.getEmail();
		this.cpf = cliente.getCpf();
		this.rua = cliente.getRua();
		this.numero = cliente.getNumero();
		this.bairro = cliente.getBairro();
		this.cidade = cliente.getCidade();
		this.complemento = cliente.getComplemento();
	}

}
