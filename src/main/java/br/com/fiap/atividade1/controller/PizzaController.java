package br.com.fiap.atividade1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.fiap.atividade1.business.PizzaBusiness;
import br.com.fiap.atividade1.dto.PizzaDTO;
import lombok.extern.slf4j.Slf4j;

/**
 * The Class PizzaController.
 */
@RestController
@Slf4j
public class PizzaController {
	
	/** The pizza business. */
	@Autowired
	private PizzaBusiness pizzaBusiness;
	
	/**
	 * Gets the all.
	 *
	 * @return the all
	 */
	@CrossOrigin
	@RequestMapping(value = "/pizzas", method = RequestMethod.GET)
    public List<PizzaDTO> getAll() {
        return pizzaBusiness.getAll();
    }
	
	/**
	 * Gets the pizza.
	 *
	 * @param id the id
	 * @return the pizza
	 */
	@CrossOrigin
	@RequestMapping(value = "/pizza/{id}", method = RequestMethod.GET)
    public ResponseEntity<PizzaDTO> get(@PathVariable(value = "id") long id)
    {
        PizzaDTO pizza = pizzaBusiness.get(id);
        
        if(pizza != null)
            return new ResponseEntity<PizzaDTO>(pizza, HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
	
	/**
	 * Post.
	 *
	 * @param pizza the pizza
	 * @return the pizza
	 */
	@CrossOrigin
	@RequestMapping(value = "/pizza/create", method =  RequestMethod.POST)
    public PizzaDTO create(@RequestBody PizzaDTO pizza)
    {
        return pizzaBusiness.create(pizza);
    }

    /**
     * Put.
     *
     * @param id the id
     * @param newPizza the new pizza
     * @return the response entity
     */
	@CrossOrigin
	@RequestMapping(value = "/pizza/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<PizzaDTO> update(@PathVariable(value = "id") long id, @RequestBody PizzaDTO newPizza)
    {
    	PizzaDTO updatedPizza = this.pizzaBusiness.update(id, newPizza);
        
    	if(updatedPizza != null) {
    		return new ResponseEntity<PizzaDTO>(updatedPizza, HttpStatus.OK);
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
	@RequestMapping(value = "/pizza/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable(value = "id") long id)
    {
    	return this.pizzaBusiness.delete(id);
    }
}