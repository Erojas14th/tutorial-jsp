package com.erojas.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erojas.model.Persona;
import com.erojas.service.PersonaService;
import com.erojas.service.impl.PersonaServiceImpl;

@WebServlet("/persona")
public class PersonaController extends HttpServlet {

	private PersonaService personaService;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	

	public PersonaController() {
		personaService= new PersonaServiceImpl();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String direccion = req.getParameter("direccion");
			String ruta="";
			if(direccion.equals("findAll")) {
				
				req.setAttribute("lista", personaService.findAll());
				ruta="/WEB-INF/templates/persona_list.jsp";
			}else
				if(direccion.equals("getOne")) {
					String codigo = req.getParameter("id");
					Integer id= Integer.parseInt(codigo);
					Persona persona = personaService.getOne(id);
					req.setAttribute("persona", persona);
					ruta="/WEB-INF/templates/persona_form.jsp";
				}else if(direccion.equals("deleteById")) {
					String codigo = req.getParameter("id");
					Integer id = Integer.parseInt(codigo);
					personaService.deleteById(id);
					
					req.setAttribute("lista", personaService.findAll());
					ruta="/WEB-INF/templates/persona_list.jsp";
					
				}else if(direccion.equals("goSave")){
					
					req.setAttribute("persona", new Persona());
					ruta="/WEB-INF/templates/persona_form.jsp";
				}
			
			RequestDispatcher vista = req.getRequestDispatcher(ruta);
			vista.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				String ayuda=req.getParameter("ayuda");
				Integer modo = Integer.parseInt(ayuda);
				String codigo = req.getParameter("id");
				Integer id = Integer.parseInt(codigo);
				String nombre=req.getParameter("nombre");
				Persona persona = new Persona(id,nombre);
				if(modo==1) {
					personaService.update(persona);
				}else {
					personaService.save(persona);
				}
				req.setAttribute("lista", personaService.findAll());
				String ruta = "/WEB-INF/templates/persona_list.jsp";
				RequestDispatcher vista = req.getRequestDispatcher(ruta);
				vista.forward(req, resp);
	}
}
