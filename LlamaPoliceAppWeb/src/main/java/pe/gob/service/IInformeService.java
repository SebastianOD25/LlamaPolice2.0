package pe.gob.service;


import java.util.List;
import pe.gob.model.Informe;

public interface IInformeService {
	
	public boolean insertar(Informe info);
	public List<Informe> listar();
	public List<Informe> buscarRespuesta(String resp);
	
}
