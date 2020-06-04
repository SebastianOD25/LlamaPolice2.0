package pe.gob.service;

import java.util.List;
import java.util.Optional;

import pe.gob.model.Comisaria;

public interface ComisariaService {
	
	public boolean insertar(Comisaria comisaria);
	
	public boolean modificar(Comisaria comisaria);
	
	public void eliminar(int idComisaria);
	
	public Optional<Comisaria> listarId(int idComisaria);
	
	List<Comisaria> lista();
	
	List<Comisaria> buscarNombre(String nomComisaria);
	
}
