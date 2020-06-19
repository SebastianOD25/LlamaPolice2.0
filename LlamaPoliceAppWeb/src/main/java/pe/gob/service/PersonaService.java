package pe.gob.service;

import java.util.List;
import java.util.Optional;
import pe.gob.model.Persona;


public interface PersonaService {
	
	public boolean insertar(Persona persona);
	public boolean modificar(Persona persona);
	public Optional<Persona> buscarId(int idPersona);
	public Optional<Persona> listarId(int idPersona);
	public List<Persona> listar();
	public List<Persona> buscarNombre(String namePersona);
	
}
