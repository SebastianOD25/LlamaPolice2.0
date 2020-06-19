package pe.gob.service;

import java.util.List;
import java.util.Optional;

import pe.gob.model.Comisaria;

public interface ComisariaService {
	
	public Optional<Comisaria> listarId(int idComisaria);
	
	List<Comisaria> lista();
	
	List<Comisaria> buscarNombre(String nomComisaria);
	
}
