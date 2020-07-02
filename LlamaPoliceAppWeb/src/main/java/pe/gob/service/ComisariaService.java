package pe.gob.service;

import java.util.List;


import pe.gob.model.Comisaria;


public interface ComisariaService {

	public boolean insertar(Comisaria comisaria);
	
	List<Comisaria> lista();
	
	List<Comisaria> buscarNombre(String nomComisaria);
	
}
