package pe.gob.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.model.Delitos;
import pe.gob.repository.DelitosRepository;
import pe.gob.service.DelitosService;

@Service
public class DelitosServiceImpl implements DelitosService{
	
	@Autowired
	private DelitosRepository rDelitos;

	@Override
	@Transactional(readOnly = true)
	public Optional<Delitos> listarId(int idDelitos) {
		return rDelitos.findById(idDelitos);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Delitos> lista() {
		return rDelitos.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Delitos> buscarNombre(String nomDelitos) {
		return rDelitos.buscarNombre(nomDelitos);
	}
}
