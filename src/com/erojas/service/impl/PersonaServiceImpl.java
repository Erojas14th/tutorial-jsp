package com.erojas.service.impl;

import java.util.List;

import com.erojas.model.Persona;
import com.erojas.repository.PersonaDAO;
import com.erojas.repository.PersonaDAOImpl;
import com.erojas.service.PersonaService;

public class PersonaServiceImpl implements PersonaService{
	
	private PersonaDAO dao;
	
	public PersonaServiceImpl() {
		dao=new PersonaDAOImpl();
	}
	@Override
	public List<Persona> findAll() {
		return dao.findAll();
		
	}

	@Override
	public Persona getOne(Integer id) {
		
		return dao.getOne(id);
	}

	@Override
	public void deleteById(Integer id) {
		
		dao.deleteById(id);
	}

	@Override
	public void save(Persona persona) {
		
		dao.save(persona);
	}

	@Override
	public void update(Persona persona) {
		
		dao.update(persona);
	}
	@Override
	public int generateId() {
		// TODO Auto-generated method stub
		return dao.generateId();
	}

}
