package com.erojas.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.erojas.model.Persona;
import com.erojas.util.Conexion;

public class PersonaDAOImpl implements PersonaDAO {

	private Connection cn;

	public PersonaDAOImpl() {
		cn = Conexion.conectar();
	}


	@Override
	public List<Persona> findAll() {
		String sql = "select * from persona";
		List<Persona> lista= new ArrayList<>();
		try {
			Statement st = cn.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				Persona persona = new Persona();
				persona.setId(rs.getInt("id"));
				persona.setNombre(rs.getString("nombre"));
				lista.add(persona);
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;
	}

	@Override
	public Persona getOne(Integer id) {
		String sql = "select * from persona where id=?";
		Persona persona = new Persona();
		PreparedStatement ps;
		try {
			ps = cn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				persona.setId(rs.getInt("id"));
				persona.setNombre(rs.getString("nombre"));
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return persona;
	}

	@Override
	public void deleteById(Integer id) {
		String sql = "delete from persona where id=?";
		PreparedStatement ps;
		try {
			ps = cn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	@Override
	public void save(Persona persona) {
		String sql = "insert into persona (id,nombre) values (?,?)";
		PreparedStatement ps;
		try {
			ps = cn.prepareStatement(sql);
			ps.setInt(1, persona.getId());
			ps.setString(2, persona.getNombre());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void update(Persona persona) {
		String sql = "update persona set nombre=? where id=?";
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			
			ps.setString(1, persona.getNombre());
			ps.setInt(2, persona.getId());
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
