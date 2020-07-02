package pe.gob.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.model.Reporte;
import pe.gob.repository.IReporteRepository;
import pe.gob.service.IReporteService;

@Service
public class ReporteServiceImpl implements IReporteService{

	@Autowired
	private IReporteRepository rReporte;
	
	@Override
	@Transactional
	public boolean insertar(Reporte reporte) {
		Reporte objReporte = rReporte.save(reporte);
		if(objReporte!=null) 
			return true;
		else
			return false;
	}

	@Override
	public List<Reporte> listar() {
		return rReporte.findAll();
	}

}
