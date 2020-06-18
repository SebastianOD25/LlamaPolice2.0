package pe.gob.service;

import java.util.List;
import java.util.Optional;

import pe.gob.model.Delitos;

public interface DelitosService {
	
	public Optional<Delitos> listarId(int idDelitos);
	
	List<Delitos> lista();
	
	List<Delitos> buscarNombre(String nomDelitos);
	
}
