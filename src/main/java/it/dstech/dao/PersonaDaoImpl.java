package it.dstech.dao;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import it.dstech.model.Persona;

@Component
@Transactional
public class PersonaDaoImpl implements PersonaDao{
	
	@Autowired //annotazione che definisce a spring di annotarci quest'oggetto, oggetto di hibernateConfiguration.class, stiamo usando la connessione al db configurato in hibernate
	private SessionFactory sessionFactory;
	
	@Override
	public Persona search(Long id) {
		Persona find = sessionFactory.getCurrentSession().find(Persona.class, id);
		return find;
	}

	@Override
	public Persona findBySurname(String cognome) {
		@SuppressWarnings("deprecation")
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Persona.class);
		criteria.add(Restrictions.eq("username", cognome));
		Persona persona = (Persona) criteria.uniqueResult();
		return persona;
	}

	@Override
	public void create(Persona persona) {
		sessionFactory.getCurrentSession().persist(persona);
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void delete(Persona persona) {
		sessionFactory.getCurrentSession().remove(persona);		
	}

	@Override
	public void update(Persona persona) {
		sessionFactory.getCurrentSession().merge(persona);
	}

}
