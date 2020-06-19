package pe.gob.service;

import java.util.List;
import java.util.Optional;

import pe.gob.model.Policia;



public interface IPoliciaService {
	
	public boolean insertar(Policia policia);
	public boolean modificar(Policia policia);
	public void eliminar(int idPolicia);
	public Optional<Policia> buscarId(int idPolicia);
	public Optional<Policia> listarId(int idPolicia);
	public List<Policia> listar();
	public List<Policia> buscarNombre(String namePolicia);
	public List<Policia> buscarComisaria(String nombreComisaria);
	
}
