package com.uniovi.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Professor {
	@Id
	private String dni;
	private String nombre;
	private String apellidos;
	private String categoria;
	
	public Professor(String dni, String name, String apellidos, String categoria) {
		super();
		this.dni = dni;
		this.nombre = name;
		this.apellidos = apellidos;
		this.categoria = categoria;
	}
	
	public Professor() {
		
	}
	
	public String getDni() {
		return dni;
	}
	
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellidos() {
		return apellidos;
	}
	
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public String toString() {
		return "DNI: " + dni + "; Nombre: " + nombre + "; Apellidos: " + apellidos +
				"; Categoria: " + categoria + " :: "; 
	}
}
