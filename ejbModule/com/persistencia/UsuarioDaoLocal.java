package com.persistencia;

import javax.ejb.Local;

import com.entidad.Usuario;

@Local
public interface UsuarioDaoLocal extends IDao<Usuario> {

}
