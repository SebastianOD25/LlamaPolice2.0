package pe.gob.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.model.Reporte;
import pe.gob.repository.IReporteRepository;
import pe.gob.service.IReporteService;

@Service
public class ReporteServiceImpl implements IReporteService{

	@Autowired
	private IReporteRepository dReporte;
	
	@Override
	@Transactional
	public boolean insertar(Reporte reporte) {
		Reporte objReporte = dReporte.save(reporte);
		if (objReporte!=null)
			return true;
		else 
			return false;
	}
	@Override
	@Transactional
	public boolean modificar(Reporte reporte) {
		boolean flag = false;
		try {
			dReporte.save(reporte);
			flag = true;
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idReporte) {
		dReporte.deleteById(idReporte);

	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Reporte> buscarId(int idReporte) {
		return dReporte.findById(idReporte);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Reporte> listarId(int idReporte) {
		return dReporte.findById(idReporte);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Reporte> listar() {
		return dReporte.findAll();
	}

	

	@Override
	@Transactional
	public List<Reporte> buscarPolicia(String nomPolicia) {
		return dReporte.buscarPolicia(nomPolicia);
	}
	
	
	
}