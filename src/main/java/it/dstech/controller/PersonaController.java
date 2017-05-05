package it.dstech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.dstech.dao.PersonaDao;
import it.dstech.model.Persona;

@RestController
public class PersonaController {
	
	@Autowired	//definiamo i comandi solo di personaDao
	private PersonaDao persona;
	
	@RequestMapping(value = "/persona/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Persona ricercaPersona(@PathVariable(value = "id") long id){
		return persona.search(id);
	}
	
	@RequestMapping(value = "/persona", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void aggiungiPersona(@RequestBody Persona p){
		persona.create(p);
	}
	
	@RequestMapping(value = "/persona", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void modificaPersona(@RequestBody Persona p){//controllo per id sessione
		persona.update(p);
	}
	
	@RequestMapping(value = "/persona", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void rimuoviPersona(@RequestBody Persona p){
		persona.delete(p);
	}
	
}
