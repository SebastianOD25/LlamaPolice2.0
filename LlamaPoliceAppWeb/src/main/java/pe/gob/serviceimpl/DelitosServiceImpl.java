package pe.gob.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.model.Comisaria;
import pe.gob.repository.ComisariaRepository;
import pe.gob.service.ComisariaService;

@Service
public class DelitosServiceImpl implements ComisariaService{
	
	@Autowired
	private ComisariaRepository rComisaria;

	@Override
	@Transactional
	public boolean insertar(Comisaria comisaria) {
		Comisaria objComisaria = rComisaria.save(comisaria);
		if(objComisaria == null) {
			return false;
		}else
		return true;
	}

	@Override
	@Transactional
	public boolean modificar(Comisaria comisaria) {
		boolean flag = false;
		try {
			rComisaria.save(comisaria);
			flag = true;
		} catch (Exception ex) {
			System.out.println("Ocurrio un error, intentelo de nuevo");
		}
		return flag;
	}

	@Override
	@Transactional(readOnly = true)
	public void eliminar(int idComisaria) {
		rComisaria.deleteById(idComisaria);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Comisaria> listarId(int idComisaria) {
		return rComisaria.findById(idComisaria);
	}

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

}
