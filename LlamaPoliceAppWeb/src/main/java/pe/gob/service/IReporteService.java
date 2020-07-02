package pe.gob.service;

import java.util.List;

import pe.gob.model.Reporte;

public interface IReporteService {
	
	public boolean insertar(Reporte reporte);
	public List<Reporte> listar();
	
}
