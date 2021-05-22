package com.entidad;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Rol
 *
 */
@Entity
@Table(name="roles")
@SequenceGenerator(name = "default_gen", sequenceName = "rol_seq", allocationSize = 1)
@NamedQuery(name="Rol.read", query="SELECT r FROM Rol r WHERE r.rol = :rol")
public class Rol extends Base implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Enumerated(EnumType.STRING)
	private Roles rol;

	public Rol() {
		super();
	}

	public Roles getRol() {
		return rol;
	}

	public void setRol(Roles rol) {
		this.rol = rol;
	}
   
}
