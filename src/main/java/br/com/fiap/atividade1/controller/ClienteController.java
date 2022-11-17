package br.com.fiap.atividade1.controller;

import br.com.fiap.atividade1.business.ClienteBusiness;
import br.com.fiap.atividade1.dto.ClienteDTO;
import br.com.fiap.atividade1.dto.PedidoDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class ClienteController {
	
	@Autowired
	private ClienteBusiness clienteBusiness;
	
	/**
	 * Gets the all.
	 *
	 * @return the all
	 */
	@CrossOrigin
	@RequestMapping(value = "/clientes", method = RequestMethod.GET)
    public List<ClienteDTO> getAll() {
        return clienteBusiness.getAll();
    }
	
	/**
	 * Gets the cliente.
	 *
	 * @param id the id
	 * @return the cliente
	 */
	@CrossOrigin
	@RequestMapping(value = "/cliente/{id}", method = RequestMethod.GET)
    public ResponseEntity<ClienteDTO> get(@PathVariable(value = "id") long id)
    {
        ClienteDTO cliente = clienteBusiness.get(id);
        
        if(cliente != null)
            return new ResponseEntity<>(cliente, HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
	
	/**
	 * Post.
	 *
	 * @param cliente the cliente
	 * @return the cliente
	 */
	@CrossOrigin
	@RequestMapping(value = "/cliente/create", method =  RequestMethod.POST)
	public ClienteDTO create(@RequestBody ClienteDTO cliente)
    {
        return clienteBusiness.create(cliente);
    }

    /**
     * Put.
     *
     * @param id the id
     * @param newcliente the new cliente
     * @return the response entity
     */
	@CrossOrigin
    @RequestMapping(value = "/cliente/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<ClienteDTO> update(@PathVariable(value = "id") long id, @RequestBody ClienteDTO newcliente)
    {
    	ClienteDTO updatedcliente = this.clienteBusiness.update(id, newcliente);
        
    	if(updatedcliente != null) {
    		return new ResponseEntity<ClienteDTO>(updatedcliente, HttpStatus.OK);
        }

    	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Delete.
     *
     * @param id the id
     * @return the response entity
     */
	@CrossOrigin
    @RequestMapping(value = "/cliente/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable(value = "id") long id)
    {
    	return this.clienteBusiness.delete(id);
    }

	@CrossOrigin
	@RequestMapping(value = "/pedido", method =  RequestMethod.POST)
	public ResponseEntity<Object> novoPedido(@RequestBody PedidoDTO pedido)
	{
		return clienteBusiness.novoPedido(pedido);
	}
}