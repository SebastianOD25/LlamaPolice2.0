package pe.gob.service;

import java.util.List;
import java.util.Optional;

import pe.gob.model.Reporte;



public interface IReporteService {
	
	public boolean insertar(Reporte reporte);
	public boolean modificar(Reporte reporte);
	public void eliminar(int idReporte);
	public Optional<Reporte> buscarId(int idReporte);
	public Optional<Reporte> listarId(int idReporte);
	public List<Reporte> listar();
	public List<Reporte> buscarPolicia(String nomPolicia);
	
}