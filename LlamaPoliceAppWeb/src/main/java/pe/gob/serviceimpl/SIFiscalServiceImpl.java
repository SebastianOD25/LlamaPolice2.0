package pe.gob.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.model.Fiscal;
import pe.gob.repository.IFiscalRepository;
import pe.gob.service.IFiscalService;

@Service
public class FiscalServiceImpl implements IFiscalService{

	@Autowired
	private IFiscalRepository dFiscal;
	
	@Override
	@Transactional
	public boolean insertar(Fiscal fiscal) {
		Fiscal objFiscal = dFiscal.save(fiscal);
		if (objFiscal!=null)
			return true;
		else 
			return false;
	}

	@Override
	@Transactional
	public boolean modificar(Fiscal fiscal) {
		boolean flag = false;
		try {
			dFiscal.save(fiscal);
			flag = true;
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idFiscal) {
		dFiscal.deleteById(idFiscal);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Fiscal> buscarId(int idFiscal) {
		return dFiscal.findById(idFiscal);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Fiscal> listarId(int idFiscal) {
		return dFiscal.findById(idFiscal);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Fiscal> listar() {
		return dFiscal.findAll();
	}

	@Override
	public List<Fiscal> buscarNombre(String nameFiscal) {
		return dFiscal.buscarNombre(nameFiscal);
	}


}