package it.dstech.dao;

import it.dstech.model.Persona;

public interface PersonaDao {
	
	Persona search(Long id);
	
	Persona findBySurname(String cognome);
	
	void create(Persona persona);
	
	void delete(Persona persona);
	
	void update(Persona persona); 
	
}
