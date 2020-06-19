package pe.gob.service;

import java.util.List;
import java.util.Optional;

import pe.gob.model.Denuncias;


public interface IDenunciasService {
	
	public boolean insertar(Denuncias den);
	public void eliminar(int idDenuncias);
	public Optional<Denuncias> buscarId(int idDenuncias);
	public Optional<Denuncias> listarId(int idDenuncias);
	public List<Denuncias> listar();
	public List<Denuncias> buscarLugar(String lugar);
	public List<Denuncias> buscarDelitos(String nombreDelitos);
	public List<Denuncias> buscarComisaria(String nomComisaria);
	
}
