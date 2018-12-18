package com.erojas.repository;

import java.util.List;

import com.erojas.model.Persona;

public interface PersonaDAO {
	List<Persona> findAll();
	Persona getOne(Integer id);
	void deleteById(Integer id);
	void save(Persona persona);
	void update(Persona persona);
	int generateId();
}
