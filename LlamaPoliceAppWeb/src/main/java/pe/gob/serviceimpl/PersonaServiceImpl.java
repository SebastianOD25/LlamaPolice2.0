package pe.gob.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.model.Persona;
import pe.gob.repository.IPersonaRepository;
import pe.gob.service.PersonaService;

@Service
public class PersonaServiceImpl implements PersonaService {

	@Autowired
	private IPersonaRepository pPersona;
	
	@Override
	@Transactional
	public boolean insertar(Persona persona) {
		Persona objPersona = pPersona.save(persona);
		if (objPersona!=null)
			return true;
		else 
			return false;
	}

	@Override
	@Transactional
	public boolean modificar(Persona persona) {
		boolean flag = false;
		try {
			pPersona.save(persona);
			flag = true;
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return flag;
	}

	@Override
	public Optional<Persona> buscarId(int idPersona) {
		return pPersona.findById(idPersona);
	}

	@Override
	public Optional<Persona> listarId(int idPersona) {
		return pPersona.findById(idPersona);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Persona> listar() {
		return pPersona.findAll();
	}

	@Override
	public List<Persona> buscarNombre(String nombrePersona) {
		return pPersona.buscarNombre(nombrePersona);
	}
	
}
