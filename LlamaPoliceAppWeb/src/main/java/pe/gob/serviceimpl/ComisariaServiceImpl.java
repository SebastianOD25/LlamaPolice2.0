package pe.gob.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.model.Comisaria;
import pe.gob.repository.ComisariaRepository;
import pe.gob.service.ComisariaService;

@Service
public class ComisariaServiceImpl implements ComisariaService{
	
	@Autowired
	private ComisariaRepository rComisaria;

	@Override
	@Transactional(readOnly = true)
	public List<Comisaria> lista() {
		return rComisaria.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Comisaria> buscarNombre(String nomComisaria) {
		return rComisaria.buscarNombre(nomComisaria);
	}

	@Override
	public boolean insertar(Comisaria comisaria) {
		Comisaria objComisaria = rComisaria.save(comisaria);
		if (objComisaria!=null)
			return true;
		else 
			return false;
	}

}
