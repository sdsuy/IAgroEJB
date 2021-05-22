package com.persistencia;

import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entidad.Rol;
import com.entidad.Roles;
import com.entidad.Usuario;

/**
 * Session Bean implementation class UsuarioDao
 */
@Singleton
//@LocalBean
public class UsuarioDao implements UsuarioDaoLocal {
	
	@PersistenceContext
	private EntityManager em;

    /**
     * Default constructor. 
     */
    public UsuarioDao() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
	public boolean create(Usuario o){
		try {
			TypedQuery<Rol> query = em.createNamedQuery("Rol.read", Rol.class);
			query.setParameter("rol", o.getRol().getRol());
			try {
				Rol rol = query.getSingleResult();
				o.setRol(rol); // si el rol ya existe en la base de datos, no hago nada, solo lo asigno completo al Usuario o
			} catch (NoResultException  e) {
				em.persist(o.getRol()); // si el rol no existe en la base de datos lo creo (persist)
			} finally {
				// Si el el rol del usuario es comun y el documento es null throw NullPointerException
				if(o.getRol().getRol().name().equals(Roles.COMUN.name()) && o.getDocumento() == null) {
					throw new NullPointerException("Se debe asignar un documento para el rol " + o.getRol().getRol().name() + ".");
				}
			}
			em.persist(o);
			em.flush();
			return true;
		} catch (PersistenceException e) {
			e.getMessage();
			return false;
		}
		
	}

	@Override
	public Usuario read(Long id) {
		
		return em.find(Usuario.class, id);
	}

	@Override
	public List<Usuario> readAll() {
		TypedQuery<Usuario> query = em.createNamedQuery("Usuario.readAll", Usuario.class);
		return query.getResultList();
	}

	@Override
	public boolean update(Usuario o) {
		try {
			TypedQuery<Rol> query = em.createNamedQuery("Rol.read", Rol.class);
			query.setParameter("rol", o.getRol().getRol());
			try {
				Rol rol = query.getSingleResult();
				o.setRol(rol); // si el rol ya existe en la base de datos, no hago nada, solo lo asigno completo al Usuario o
			} catch (NoResultException  e) {
				em.persist(o.getRol()); // si el rol no existe en la base de datos lo creo (persist)
			} finally {
				// Si el el rol del usuario es comun y el documento es null throw NullPointerException
				if(o.getRol().getRol().name().equals(Roles.COMUN.name()) && o.getDocumento() == null) {
					throw new NullPointerException("Se debe asignar un documento para el rol " + o.getRol().getRol().name() + ".");
				}
			}
			em.merge(o);
			em.flush();
			return true;
		} catch (PersistenceException e) {
			e.getMessage();
			return false;
		}
		
		
	}

	@Override
	public boolean delete(Long id) {
		try {
			Usuario o = em.find(Usuario.class, id);
			em.remove(o);
			em.flush();
			return true;
		} catch (PersistenceException e) {
			e.getMessage();
			return false;
		}		
		
	}

}
