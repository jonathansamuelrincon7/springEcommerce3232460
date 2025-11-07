package com.sena.springecommerce.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY ) //anotacion JPA
	private Integer Id;
	private String nombre;
	private String telefono;
	private String email;
	private String direccion;
	private String rol;
	private String password;
	
	
	//relaciones en Data base
	@OneToMany(mappedBy = "usuario")
	private List<Producto>productos;
	
	@OneToMany(mappedBy = "usuario")
	private List<Orden>ordenes;
	
	//constructor vacio
	public Usuario() {
		
	}

	public Usuario(Integer id, String nombre, String telefono, String email, String direccion, String rol,
			String password) {
		super();
		Id = id;
		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;
		this.direccion = direccion;
		this.rol = rol;
		this.password = password;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Usuario [Id=" + Id + ", nombre=" + nombre + ", telefono=" + telefono + ", email=" + email
				+ ", direccion=" + direccion + ", rol=" + rol + ", password=" + password + "]";
	}
	
	
	
	
	
	

}
