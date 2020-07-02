package pe.gob.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.model.Informe;
import pe.gob.repository.IInformeRepository;
import pe.gob.service.IInformeService;

@Service
public class InformeServiceImpl implements IInformeService{

	@Autowired
	private IInformeRepository rInfo;
	
	@Override
	public boolean insertar(Informe info) {
		Informe objinfo = rInfo.save(info);
		if(objinfo!=null) 
			return true;
		else
			return false;
	}

	@Override
	public List<Informe> listar() {
		return rInfo.findAll();
	}

	@Override
	public List<Informe> buscarRespuesta(String resp) {
		return rInfo.buscarInforme(resp);
	}

}
