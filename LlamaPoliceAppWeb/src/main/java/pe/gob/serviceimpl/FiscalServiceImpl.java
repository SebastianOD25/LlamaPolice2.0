package pe.gob.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import pe.gob.model.Fiscal;
import pe.gob.repository.IFiscalRepository;
import pe.gob.service.IFiscalService;

public class FiscalServiceImpl implements IFiscalService{

	@Autowired
	private IFiscalRepository pFiscal; 
	
	@Override
	public boolean insertar(Fiscal persona) {
		Fiscal objFiscal = pFiscal.save(persona);
		if (objFiscal!=null)
			return true;
		else 
			return false;
	}

	@Override
	public boolean modificar(Fiscal persona) {
		boolean flag = false;
		try {
			pFiscal.save(persona);
			flag = true;
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return flag;
	}

	@Override
	public Optional<Fiscal> listarId(int idFiscal) {
		return pFiscal.findById(idFiscal);
	}

	@Override
	public List<Fiscal> listar() {
		return pFiscal.findAll();
	}

	@Override
	public List<Fiscal> buscarNombre(String nombreFiscal) {
		return pFiscal.buscarNombre(nombreFiscal);
	}

}
