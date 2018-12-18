package com.erojas.app;

import java.sql.Connection;
import java.util.List;

import com.erojas.model.Persona;
import com.erojas.service.PersonaService;
import com.erojas.service.impl.PersonaServiceImpl;
import com.erojas.util.Conexion;

public class App {
	public static void main(String[] args) {

		// Probando la conexion:
		Connection cn = Conexion.conectar();
		if (cn != null) {
			System.out.println("COnexion okay");
		} else {
			System.out.println("No hay conexion");
		}
		PersonaService dao = new PersonaServiceImpl();
		/*
		 * PersonaDAO dao = new PersonaDAOImpl(); // save Persona persona = new
		 * Persona(6,"Freddy");
		 * 
		 * dao.save(persona);
		 * 
		 * dao.deleteById(6);
		 * 
		 * List<Persona> lista = dao.findAll(); lista.stream().forEach(p ->
		 * System.out.println(p.getNombre()));
		 * 
		 * Persona persona = new Persona(5,"Pepelucho"); dao.update(persona); Persona
		 * persona2=dao.getOne(5); System.out.println(persona2.getNombre());
		 */
			
	}
}
