package pe.gob.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.model.Denuncias;
import pe.gob.repository.IDenunciasRepository;
import pe.gob.service.IDenunciasService;

@Service
public class DenunciasServiceImpl implements IDenunciasService{

	@Autowired
	private IDenunciasRepository dDenuncias;
	
	@Override
	@Transactional
	public boolean insertar(Denuncias den) {
		Denuncias objDenuncias = dDenuncias.save(den);
		if (objDenuncias!=null)
			return true;
		else 
			return false;
	}

	@Override
	@Transactional
	public void eliminar(int idDenuncias) {
		dDenuncias.deleteById(idDenuncias);

	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Denuncias> buscarId(int idDenuncias) {
		return dDenuncias.findById(idDenuncias);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Denuncias> listarId(int idDenuncias) {
		return dDenuncias.findById(idDenuncias);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Denuncias> listar() {
		return dDenuncias.findAll();
	}

	@Override
	@Transactional
	public List<Denuncias> buscarLugar(String lugar) {
		return dDenuncias.buscarLugar(lugar);
	}

	@Override
	@Transactional
	public List<Denuncias> buscarDelitos(String nombreDelitos) {
		return dDenuncias.buscarDelito(nombreDelitos);
	}

	@Override
	@Transactional
	public List<Denuncias> buscarComisaria(String nomComisaria) {
		return dDenuncias.buscarComisaria(nomComisaria);
	}
	
	
	
}
