package pe.gob.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.model.Policia;
import pe.gob.repository.IPoliciaRepository;
import pe.gob.service.IPoliciaService;

@Service
public class PoliciaServiceImpl implements IPoliciaService{

	@Autowired
	private IPoliciaRepository dPolicia;
	
	@Override
	@Transactional
	public boolean insertar(Policia policia) {
		Policia objPolicia = dPolicia.save(policia);
		if (objPolicia!=null)
			return true;
		else 
			return false;
	}

	@Override
	@Transactional
	public boolean modificar(Policia policia) {
		boolean flag = false;
		try {
			dPolicia.save(policia);
			flag = true;
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idPolicia) {
		dPolicia.deleteById(idPolicia);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Policia> buscarId(int idPolicia) {
		return dPolicia.findById(idPolicia);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Policia> listarId(int idPolicia) {
		return dPolicia.findById(idPolicia);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Policia> listar() {
		return dPolicia.findAll();
	}

	@Override
	public List<Policia> buscarNombre(String namePolicia) {
		return dPolicia.buscarNombre(namePolicia);
	}

	@Override
	public List<Policia> buscarComisaria(String nombreComisaria) {
		return dPolicia.buscarComisaria(nombreComisaria);
	}

}
