package pe.gob.service;

import java.util.List;


import pe.gob.model.Usuarios;


public interface IUsuariosService {
	
	public boolean insertar(Usuarios usuario);
	List<Usuarios> listar();
	
}
