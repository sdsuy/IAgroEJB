package com.entidad;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Usuario
 *
 */
@Entity
@Table(name="usuarios")
@SequenceGenerator(name = "default_gen", sequenceName = "usuario_seq", allocationSize = 1)
@NamedQuery(name="Usuario.readAll", query="SELECT u FROM Usuario u")
@NamedQuery(name="Usuario.login", query="SELECT u FROM Usuario u WHERE u.nickname = :nickname AND u.clave = :clave")
public class Usuario extends Base implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Column(length = 40, nullable = false)
	private String nombre;
	
	@Column(length = 40, nullable = false)
	private String apellido;
	
	@Column(length = 20, nullable = true, unique = true)
	private String documento;
	
	@Column(length = 20, nullable = false)
	private String clave;
	
	@Column(length = 40, nullable = true, unique = true)
	private String email;
	
	@Column(length = 20, nullable = false, unique = true)
	private String nickname;
	
	@Column(length = 50, nullable = true)
	private String instituto;
	
	@Column(length = 30, nullable = true)
	private String profesion;
	
//	@Enumerated(EnumType.STRING)
	@ManyToOne(optional = false)
	private Rol rol;

	public Usuario() {
		super();
	}
	
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getDocumento() {
		return documento;
	}


	public void setDocumento(String documento) {
		this.documento = documento;
	}


	public String getClave() {
		return clave;
	}


	public void setClave(String clave) {
		this.clave = clave;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getNickname() {
		return nickname;
	}


	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	public Rol getRol() {
		return rol;
	}

	// sobrecarga de setter (para cuando el rol aun NO existe en la base de datos)
	public void setRol(Roles rol) {
		this.rol = new Rol();
		this.rol.setRol(rol);
	}
	
	// sobrecarga de setter (para cuando el rol ya existe en la base de datos)
	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public String getInstituto() {
		return instituto;
	}

	public void setInstituto(String instituto) {
		this.instituto = instituto;
	}

	public String getProfesion() {
		return profesion;
	}

	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}
   
}
