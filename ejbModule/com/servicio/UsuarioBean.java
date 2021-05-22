package com.servicio;

import com.entidad.Usuario;
import com.interfaz.UsuarioBeanRemote;
import com.persistencia.UsuarioDaoLocal;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class UsuarioBean
 */
@Stateless
//@LocalBean
public class UsuarioBean implements UsuarioBeanRemote {
	
	@EJB
	private UsuarioDaoLocal usuarioDao;

    /**
     * Default constructor. 
     */
    public UsuarioBean() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
	public boolean create(Usuario o) {
		
		return usuarioDao.create(o);
		
	}

	@Override
	public Usuario read(Long id) {
		
		return usuarioDao.read(id);
	}

	@Override
	public List<Usuario> readAll() {
		
		return usuarioDao.readAll();
	}

	@Override
	public boolean update(Usuario o) {
		
		return usuarioDao.update(o);
		
	}

	@Override
	public boolean delete(Long id) {
		
		return usuarioDao.delete(id);
		
	}

}
